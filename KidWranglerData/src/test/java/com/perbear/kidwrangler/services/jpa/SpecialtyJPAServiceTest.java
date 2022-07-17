package com.perbear.kidwrangler.services.jpa;

import com.perbear.kidwrangler.Model.Specialty;
import com.perbear.kidwrangler.repositories.SpecialtyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class SpecialtyJPAServiceTest {
    @Mock
    SpecialtyRepository repository;
    @InjectMocks
    SpecialtyJPAService service;
    Specialty specialty;
    Long specId = 1L;

    @BeforeEach
    void setUp() {
        specialty = Specialty.builder().description("Radiology").Id(specId).build();
    }

    @Test
    void findAll() {
        Set<Specialty> demos = Set.of(specialty);
        when(repository.findAll()).thenReturn(demos);
        assertEquals(1,service.findAll().size());
        verify(repository).findAll();
    }

    @Test
    void findById() {
        when(repository.findById(specId)).thenReturn(Optional.of(specialty));
        assertEquals(specId,service.findById(specId).getId());
        verify(repository).findById(any());
    }

    @Test
    void save() {
        when(repository.save(specialty)).thenReturn(specialty);

        assertEquals(specialty.getId(),service.save(specialty).getId());
        verify(repository).save(any());

    }

    @Test
    void deleteById() {
        service.deleteById(specId);
        verify(repository).deleteById(any());
    }

    @Test
    void delete() {
        service.delete(specialty);

        verify(repository).delete(any());
    }
}