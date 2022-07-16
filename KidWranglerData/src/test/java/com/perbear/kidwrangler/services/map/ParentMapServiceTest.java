package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Parent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ParentMapServiceTest {
    ParentMapService parentService;
    Long parentId = 1L;

    @BeforeEach
    void setUp() {
        parentService = new ParentMapService();
        parentService.save(Parent.builder().Id(parentId).lastName("Shelton").build());
    }

    @Test
    void findAll() {
        Set<Parent> parents = parentService.findAll();

        assertEquals(1,parents.size());
    }

    @Test
    void delete() {

        parentService.delete(parentService.findById(parentId));
        Set<Parent> parents = parentService.findAll();

        assertEquals(0,parents.size());
    }

    @Test
    void deleteById() {


        parentService.deleteById(parentId);
        Set<Parent> parents = parentService.findAll();

        assertEquals(0,parents.size());
    }

    @Test
    void saveExistingId() {
        Parent parent = parentService.findById(parentId);
        parent.setState("ca");
        parentService.save(parent);
        assertEquals(1,parentService.findAll().size());
        assertEquals("ca",parentService.findById(parentId).getState());
    }
    @Test
    void saveNewTestId() {
        Parent parent = new Parent();
        assertNull(parent.getId());
        parent = parentService.save(parent);
        log.debug("Saved parent#" + parent.getId());
        assertNotNull(parent.getId());
        assertEquals(2,parentService.findAll().size());
    }

    @Test
    void findById() {
        Parent parent = parentService.findById(parentId);
        assertEquals(parentId,parent.getId());
    }

    @Test
    void findByLastNameExists(){
        Set<Parent> results = parentService.findByLastName("shelton");
        assertEquals(1,results.size());

    }
    @Test
    void findByLastNameNotExisting(){
        Set<Parent> results = parentService.findByLastName("foo");
        assertEquals(0,results.size());

    }
}