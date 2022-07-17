package com.perbear.kidwrangler.services.jpa;

import com.perbear.kidwrangler.Model.Doctor;
import com.perbear.kidwrangler.repositories.DoctorRepository;
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
class DoctorJPAServiceTest {
    @Mock
    DoctorRepository doctorRepository
            ;
    @InjectMocks
    DoctorJPAService service;


    Long doctorId = 1L;

    @Test
    void findByLastName() {
        Doctor doctor = Doctor.builder().Id(doctorId).lastName("Shelton").build();
        when(doctorRepository.findDoctorsByLastName("Shelton")).thenReturn(Set.of(doctor));
        Set<Doctor> returnResult = service.findByLastName("Shelton");
        Doctor doctorResult = returnResult.stream().findFirst().orElse(null);
        assertEquals(1,returnResult.size());
        assertEquals("Shelton",doctorResult.getLastName());
        verify(doctorRepository).findDoctorsByLastName(any());
    }
    @Test
    void findByLastNameThatDoesNotExist() {
        Doctor doctor = Doctor.builder().Id(doctorId).lastName("Shelton").build();
        when(doctorRepository.findDoctorsByLastName("foo")).thenReturn(new HashSet<>());
        Set<Doctor> returnResult = service.findByLastName("foo");
        Doctor doctorResult = returnResult.stream().findFirst().orElse(null);
        assertEquals(0,returnResult.size());
        assertNull(doctorResult);
        verify(doctorRepository).findDoctorsByLastName(any());
    }


    @Test
    void findAll() {
        Doctor doctor = Doctor.builder().Id(doctorId).lastName("Shelton").build();
        when(doctorRepository.findAll()).thenReturn(Set.of(doctor));
        assertEquals(1, service.findAll().size());
    }

    @Test
    void findById() {
        Optional<Doctor> doctorOptional = Optional.of(Doctor.builder().Id(doctorId).lastName("Shelton").build());
        when(doctorRepository.findById(doctorId)).thenReturn(doctorOptional);
        assertEquals(doctorId,service.findById(doctorId).getId());
    }

    @Test
    void save() {
        Doctor doctor = Doctor.builder().Id(doctorId).build();
        Doctor doctorToSave  = Doctor.builder().build();
        when(doctorRepository.save(doctorToSave)).thenReturn(Doctor.builder().Id(doctorId+1).build());
        Set<Doctor> doctors = new HashSet<>();
        doctors.add(doctor);
        doctors.add(doctorToSave);
        when(doctorRepository.findAll()).thenReturn(doctors);
        assertNotNull(service.save(doctorToSave));
        assertEquals(2L, service.save(doctorToSave).getId());
        assertEquals(2, service.findAll().size());
    }
    @Test
    void saveExists() {
        Doctor doctor = Doctor.builder().Id(doctorId).build();
        when(doctorRepository.save(doctor)).thenReturn(doctor);
        when(doctorRepository.findAll()).thenReturn(Set.of(doctor));
        assertNotNull(service.save(doctor));
        assertEquals(1,service.findAll().size());
    }

    @Test
    void deleteById() {

        service.deleteById(1L);
        verify(doctorRepository).deleteById(any());
    }

    @Test
    void delete() {

        service.delete(any());
        verify(doctorRepository).delete(any());
    }
}