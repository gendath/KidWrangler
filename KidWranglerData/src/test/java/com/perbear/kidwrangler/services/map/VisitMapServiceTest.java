package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VisitMapServiceTest {
    VisitMapService visitMapService;
    Long visitId = 1L;

    @BeforeEach
    void setUp() {
        visitMapService = new VisitMapService();
        visitMapService.save(Visit.builder().Id(visitId).build());
    }

    @Test
    void findAll() {
        Set<Visit> visits = visitMapService.findAll();

        assertEquals(1,visits.size());
    }
    @Test
    void save() {
        Visit visit = Visit.builder().build();
        assertNull(visit.getId());
        visitMapService.save(visit);
        assertEquals(2,visitMapService.findAll().size());
    }
    @Test
    void saveExists() {
        Visit visit = visitMapService.findById(visitId);
        assertNotNull(visit.getId());
        visitMapService.save(visit);
        assertEquals(1,visitMapService.findAll().size());
    }

    @Test
    void deleteById() {
        assertEquals(1,visitMapService.findAll().size());
        visitMapService.deleteById(visitId);
        assertEquals(0,visitMapService.findAll().size());
    }


    @Test
    void delete() {
        Visit visit = visitMapService.findById(visitId);
        assertEquals(1,visitMapService.findAll().size());
        visitMapService.delete(visit);
        assertEquals(0,visitMapService.findAll().size());
    }

    @Test
    void findById() {
        Visit visit = visitMapService.findById(visitId);
        assertNotNull(visit);
        assertEquals(visitId,visit.getId());
    }
}