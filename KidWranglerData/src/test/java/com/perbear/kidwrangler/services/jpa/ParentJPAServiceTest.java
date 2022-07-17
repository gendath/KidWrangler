package com.perbear.kidwrangler.services.jpa;

import com.perbear.kidwrangler.Model.Parent;
import com.perbear.kidwrangler.repositories.ParentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ParentJPAServiceTest {
    @Mock
    ParentRepository parentRepository;
    @InjectMocks
    ParentJPAService service;


    Long parentId = 1L;

    @Test
    void findByLastName() {
        Parent parent = Parent.builder().Id(parentId).lastName("Shelton").build();
        when(parentRepository.findParentsByLastName("Shelton")).thenReturn(Set.of(parent));
        Set<Parent> returnResult = service.findByLastName("Shelton");
        Parent parentResult = returnResult.stream().findFirst().orElse(null);
        assertEquals(1,returnResult.size());
        assertEquals("Shelton",parentResult.getLastName());
        verify(parentRepository).findParentsByLastName(any());
    }
    @Test
    void findByLastNameThatDoesNotExist() {
        Parent parent = Parent.builder().Id(parentId).lastName("Shelton").build();
        when(parentRepository.findParentsByLastName("foo")).thenReturn(new HashSet<>());
        Set<Parent> returnResult = service.findByLastName("foo");
        Parent parentResult = returnResult.stream().findFirst().orElse(null);
        assertEquals(0,returnResult.size());
        assertNull(parentResult);
        verify(parentRepository).findParentsByLastName(any());
    }


    @Test
    void findAll() {
        Parent parent = Parent.builder().Id(parentId).lastName("Shelton").build();
        when(parentRepository.findAll()).thenReturn(Set.of(parent));
        assertEquals(1, service.findAll().size());
    }

    @Test
    void findById() {
        Optional<Parent> parentOptional = Optional.of(Parent.builder().Id(parentId).lastName("Shelton").build());
        when(parentRepository.findById(parentId)).thenReturn(parentOptional);
        assertEquals(parentId,service.findById(parentId).getId());
    }

    @Test
    void save() {
        Parent parent = Parent.builder().Id(parentId).build();
        Parent parentToSave  = Parent.builder().build();
        when(parentRepository.save(parentToSave)).thenReturn(Parent.builder().Id(parentId+1).build());
        Set<Parent> parents = new HashSet<>();
        parents.add(parent);
        parents.add(parentToSave);
        when(parentRepository.findAll()).thenReturn(parents);
        assertNotNull(service.save(parentToSave));
        assertEquals(2L, service.save(parentToSave).getId());
        assertEquals(2, service.findAll().size());
    }
    @Test
    void saveExists() {
        Parent parent = Parent.builder().Id(parentId).build();
        when(parentRepository.save(parent)).thenReturn(parent);
        when(parentRepository.findAll()).thenReturn(Set.of(parent));
        assertNotNull(service.save(parent));
        assertEquals(1,service.findAll().size());
    }

    @Test
    void deleteById() {

        service.deleteById(1L);
        verify(parentRepository).deleteById(any());
    }

    @Test
    void delete() {

        service.delete(any());
        verify(parentRepository).delete(any());
    }
}