package com.perbear.kidwrangler.controllers;

import com.perbear.kidwrangler.Model.Parent;
import com.perbear.kidwrangler.services.ParentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ParentControllerTest {
    @Mock
    ParentService service;
    @InjectMocks
    ParentController controller;
    Set<Parent> parents;

    MockMvc mockMvc;


    @BeforeEach
    void setUp() {

        parents = new HashSet<>();
        parents.add(
                Parent.builder()
                        .Id(1L)
                        .build()
        );
        parents.add(
                Parent.builder()
                        .Id(2L)
                        .build()
        );
        parents.add(
                Parent.builder()
                        .Id(3L)
                        .build()
        );

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void home() throws Exception {

        when(service.findAll()).thenReturn(parents);
        mockMvc.perform(get("/parent"))
                .andExpect(status().isOk())
                .andExpect(view().name("parent/index"))
                .andExpect(model().attribute("parents",hasSize(3)));
    }
}