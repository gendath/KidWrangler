package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Demographics;
import com.perbear.kidwrangler.enumeration.Gender;
import com.perbear.kidwrangler.enumeration.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DemographicsMapServiceTest {
    DemographicsMapService demographicsMapService;
    Long demoId = 1L;

    @BeforeEach
    void setUp() {
        demographicsMapService = new DemographicsMapService();
        demographicsMapService.save(Demographics.builder().Id(demoId).gender(Gender.MALE).race(Race.WHITE).sexualOrientation("Gay").build());
    }

    @Test
    void findAll() {
        Set<Demographics> demographics = demographicsMapService.findAll();

        assertEquals(1,demographics.size());
    }

    @Test
    void findById() {
        Demographics demographics = demographicsMapService.findById(10000L);
        assertNull(demographics);
        demographics = demographicsMapService.findById(demoId);

        assertEquals(demoId,demographics.getId());
    }

    @Test
    void save() {
        Demographics demographics = new Demographics();
        demographicsMapService.save(demographics);
        assertEquals(2,demographicsMapService.findAll().size());
    }
    @Test
    void saveExists() {
        Demographics demographics = demographicsMapService.findById(demoId);
        demographicsMapService.save(demographics);
        assertEquals(1,demographicsMapService.findAll().size());
    }

    @Test
    void deleteById() {
        assertEquals(1,demographicsMapService.findAll().size());
        demographicsMapService.deleteById(demoId);
        assertEquals(0,demographicsMapService.findAll().size());
    }

    @Test
    void delete() {
        Demographics demographics = demographicsMapService.findById(demoId);
        assertEquals(1,demographicsMapService.findAll().size());
        demographicsMapService.delete(demographics);
        assertEquals(0,demographicsMapService.findAll().size());
    }
}