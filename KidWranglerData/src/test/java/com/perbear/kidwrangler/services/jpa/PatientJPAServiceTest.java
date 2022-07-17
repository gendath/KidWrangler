package com.perbear.kidwrangler.services.jpa;

import com.perbear.kidwrangler.Model.Patient;
import com.perbear.kidwrangler.repositories.PatientRepository;
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
class PatientJPAServiceTest {
    @Mock
    PatientRepository patientRepository;
    @InjectMocks
    PatientJPAService service;

    Long patientId = 1L;

    @Test
    void findByLastName() {
        Patient patient = Patient.builder().Id(patientId).lastName("Shelton").build();
        when(patientRepository.findPatientsByLastName("Shelton")).thenReturn(Set.of(patient));
        Set<Patient> returnResult = service.findByLastName("Shelton");
        Patient patientResult = returnResult.stream().findFirst().orElse(null);
        assertEquals(1,returnResult.size());
        assertEquals("Shelton",patientResult.getLastName());
        verify(patientRepository).findPatientsByLastName(any());
    }
    @Test
    void findByLastNameThatDoesNotExist() {
        Patient patient = Patient.builder().Id(patientId).lastName("Shelton").build();
        when(patientRepository.findPatientsByLastName("foo")).thenReturn(new HashSet<>());
        Set<Patient> returnResult = service.findByLastName("foo");
        Patient patientResult = returnResult.stream().findFirst().orElse(null);
        assertEquals(0,returnResult.size());
        assertNull(patientResult);
        verify(patientRepository).findPatientsByLastName(any());
    }


    @Test
    void findAll() {
        Patient patient = Patient.builder().Id(patientId).lastName("Shelton").build();
        when(patientRepository.findAll()).thenReturn(Set.of(patient));
        assertEquals(1, service.findAll().size());
    }

    @Test
    void findById() {
        Optional<Patient> patientOptional = Optional.of(Patient.builder().Id(patientId).lastName("Shelton").build());
        when(patientRepository.findById(patientId)).thenReturn(patientOptional);
        assertEquals(patientId,service.findById(patientId).getId());
    }

    @Test
    void save() {
        Patient patient = Patient.builder().Id(patientId).build();
        Patient patientToSave  = Patient.builder().build();
        when(patientRepository.save(patientToSave)).thenReturn(Patient.builder().Id(patientId +1).build());
        Set<Patient> patients = new HashSet<>();
        patients.add(patient);
        patients.add(patientToSave);
        when(patientRepository.findAll()).thenReturn(patients);
        assertNotNull(service.save(patientToSave));
        assertEquals(2L, service.save(patientToSave).getId());
        assertEquals(2, service.findAll().size());
    }
    @Test
    void saveExists() {
        Patient patient = Patient.builder().Id(patientId).build();
        when(patientRepository.save(patient)).thenReturn(patient);
        when(patientRepository.findAll()).thenReturn(Set.of(patient));
        assertNotNull(service.save(patient));
        assertEquals(1,service.findAll().size());
    }

    @Test
    void deleteById() {

        service.deleteById(1L);
        verify(patientRepository).deleteById(any());
    }

    @Test
    void delete() {

        service.delete(any());
        verify(patientRepository).delete(any());
    }
}