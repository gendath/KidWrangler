package com.perbear.kidwrangler.services.jpa;

import com.perbear.kidwrangler.Model.Demographics;
import com.perbear.kidwrangler.enumeration.Gender;
import com.perbear.kidwrangler.enumeration.Race;
import com.perbear.kidwrangler.repositories.DemographicsRepository;
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
class DemographicsJPAServiceTest {
    @Mock
    DemographicsRepository repository;
    @InjectMocks
    DemographicsJPAService service;
    Demographics demo;
    Long demoId = 1L;

    @BeforeEach
    void setUp() {
        demo = Demographics.builder().gender(Gender.MALE).Id(demoId).race(Race.ASIAN_PACIFIC).sexualOrientation("Gay").build();
    }

    @Test
    void findAll() {
        Set<Demographics> demos = Set.of(demo);
        when(repository.findAll()).thenReturn(demos);
        assertEquals(1,service.findAll().size());
        verify(repository).findAll();
    }

    @Test
    void findById() {
        when(repository.findById(demoId)).thenReturn(Optional.of(demo));
        assertEquals(demoId,service.findById(demoId).getId());
        verify(repository).findById(any());
    }

    @Test
    void save() {
        when(repository.save(demo)).thenReturn(demo);

        assertEquals(demo.getId(),service.save(demo).getId());
        verify(repository).save(any());

    }

    @Test
    void deleteById() {
        service.deleteById(demoId);
        verify(repository).deleteById(any());
    }

    @Test
    void delete() {
        service.delete(demo);

        verify(repository).delete(any());
    }
}