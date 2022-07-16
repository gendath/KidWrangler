package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Doctor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DoctorMapServiceTest {
    DoctorMapService doctorMapService;
    Long doctorId =1L;

    @BeforeEach
    void setUp() {
        doctorMapService = new DoctorMapService();
        doctorMapService.save(Doctor.builder().Id(doctorId).lastName("Shelton").build());
    }

    @Test
    void findByLastNameThatExists() {
        String lastName = "shelton";
        Set<Doctor> doctors = doctorMapService.findByLastName(lastName);
        assertEquals(1,doctors.size());
    }
    @Test
    void findByLastNameThatDoesNotExist() {
        String lastName = "foo";
        Set<Doctor> doctors = doctorMapService.findByLastName(lastName);
        assertEquals(0,doctors.size());
    }

    @Test
    void findAll() {
        Set<Doctor> doctors = doctorMapService.findAll();
        assertEquals(1,doctors.size());
    }

    @Test
    void delete() {
        assertEquals(1,doctorMapService.findAll().size());
        doctorMapService.delete(doctorMapService.findById(doctorId));
        assertEquals(0,doctorMapService.findAll().size());
    }

    @Test
    void deleteById() {
        assertEquals(1,doctorMapService.findAll().size());
        doctorMapService.deleteById(doctorId);
        assertEquals(0,doctorMapService.findAll().size());
    }

    @Test
    void save() {

        Doctor doctor = new Doctor();
        assertNotNull(doctor);
        doctorMapService.save(doctor);
        assertEquals(2,doctorMapService.findAll().size());
    }
    @Test
    void saveExisting() {

        Doctor doctor = doctorMapService.findById(doctorId);
        assertNotNull(doctor);
        doctorMapService.save(doctor);
        assertEquals(1,doctorMapService.findAll().size());
    }

    @Test
    void findById() {
        Doctor doctor = doctorMapService.findById(doctorId);
        assertEquals(doctorId,doctor.getId());
    }
}