package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Specialty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SpecialtyMapServiceTest {
    SpecialtyMapService specialtyMapService;
    Long specID = 1L;

    @BeforeEach
    void setUp() {
        specialtyMapService = new SpecialtyMapService();
        specialtyMapService.save(Specialty.builder().Id(specID).description("Radiology").build());

    }

    @Test
    void findAll() {
        Set<Specialty> specialties = specialtyMapService.findAll();
        assertEquals(1,specialtyMapService.findAll().size());
    }

    @Test
    void deleteById() {
        assertEquals(1,specialtyMapService.findAll().size());
        specialtyMapService.deleteById(specID);
        assertEquals(0,specialtyMapService.findAll().size());
    }

    @Test
    void save() {
        Specialty specialty = Specialty.builder().build();
        assertNull(specialty.getId());
        specialtyMapService.save(specialty);
        assertEquals(2,specialtyMapService.findAll().size());
    }
    @Test
    void saveExists() {
        Specialty specialty = Specialty.builder().build();
        assertNull(specialty.getId());
        specialtyMapService.save(specialty);
        assertEquals(2,specialtyMapService.findAll().size());
    }

    @Test
    void delete() {
        Specialty specialty = specialtyMapService.findById(specID);
        assertEquals(1,specialtyMapService.findAll().size());
        specialtyMapService.delete(specialty);
        assertEquals(0,specialtyMapService.findAll().size());
    }

    @Test
    void findById() {
        Specialty specialty = specialtyMapService.findById(specID);

        assertEquals(specID,specialty.getId());

    }
}