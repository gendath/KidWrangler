package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PatientMapServiceTest {

    PatientMapService patientMapService;
    Long patientId = 1L;

    @BeforeEach
    void setUp() {
        patientMapService = new PatientMapService();
        patientMapService.save(Patient.builder().Id(patientId).lastName("Shelton").build());
    }

    @Test
    void findByLastNameExists() {
        String lastName = "shelton";
        Set<Patient> patients = patientMapService.findByLastName(lastName);
        assertEquals(1,patients.size());

    }
    @Test
    void findByLastNameDoesNotExist() {
        String lastName = "foo";
        Set<Patient> patients = patientMapService.findByLastName(lastName);
        assertEquals(0,patients.size());

    }

    @Test
    void findAll() {
        Set<Patient> patients = patientMapService.findAll();
        assertEquals(1,patients.size());
    }

    @Test
    void delete() {
        Patient patient = patientMapService.findById(patientId);
        assertEquals(1,patientMapService.findAll().size());
        patientMapService.delete(patient);
        assertEquals(0,patientMapService.findAll().size());

    }

    @Test
    void deleteById() {
        Patient patient = patientMapService.findById(1L);
        assertEquals(1,patientMapService.findAll().size());
        patientMapService.deleteById(1L);
        assertEquals(0,patientMapService.findAll().size());
    }

    @Test
    void save() {
        Patient patient = Patient.builder().build();
        assertNull(patient.getId());
        patientMapService.save(patient);
        assertNotNull(patient.getId());
        assertEquals(2,patientMapService.findAll().size());
    }
    @Test
    void saveExists() {
        Patient patient = patientMapService.findById(patientId);
        patientMapService.save(patient);
        assertEquals(patientId,patient.getId());
        assertEquals(1,patientMapService.findAll().size());
    }

    @Test
    void findById() {
        Patient patient = patientMapService.findById(patientId);
        assertEquals(patientId,patient.getId());
    }
}