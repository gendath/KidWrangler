package com.perbear.kidwrangler.services.jpa;

import com.perbear.kidwrangler.Model.Doctor;
import com.perbear.kidwrangler.Model.Patient;
import com.perbear.kidwrangler.Model.Visit;
import com.perbear.kidwrangler.repositories.VisitRepository;
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
class VisitJPAServiceTest {
    @Mock
    VisitRepository repository;
    @InjectMocks
    VisitJPAService service;
    Visit visit;
    Long visitId = 1L;

    @BeforeEach
    void setUp() {
        visit = Visit.builder().Id(visitId).doctor(Doctor.builder().Id(1L).build()).patient(Patient.builder().Id(1L).build()).build();
    }

    @Test
    void findAll() {
        Set<Visit> visits = Set.of(visit);
        when(repository.findAll()).thenReturn(visits);
        assertEquals(1,service.findAll().size());
        verify(repository).findAll();
    }

    @Test
    void findById() {
        when(repository.findById(visitId)).thenReturn(Optional.of(visit));
        assertEquals(visitId,service.findById(visitId).getId());
        verify(repository).findById(any());
    }

    @Test
    void save() {
        when(repository.save(visit)).thenReturn(visit);

        assertEquals(visit.getId(),service.save(visit).getId());
        verify(repository).save(any());

    }

    @Test
    void deleteById() {
        service.deleteById(visitId);
        verify(repository).deleteById(any());
    }

    @Test
    void delete() {
        service.delete(visit);

        verify(repository).delete(any());
    }
}