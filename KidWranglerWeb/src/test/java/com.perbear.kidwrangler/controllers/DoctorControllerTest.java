package com.perbear.kidwrangler.controllers;

import com.perbear.kidwrangler.Model.Doctor;
import com.perbear.kidwrangler.services.DoctorService;
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
class DoctorControllerTest {
    @Mock
    DoctorService service;
    @InjectMocks
    DoctorController controller;
    Set<Doctor> doctors;

    MockMvc mockMvc;


    @BeforeEach
    void setUp() {

        doctors = new HashSet<>();
        doctors.add(
                Doctor.builder()
                        .Id(1L)
                        .build()
        );
        doctors.add(
                Doctor.builder()
                        .Id(2L)
                        .build()
        );
        doctors.add(
                Doctor.builder()
                        .Id(3L)
                        .build()
        );

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void home() throws Exception {

        when(service.findAll()).thenReturn(doctors);
        mockMvc.perform(get("/doctor"))
                .andExpect(status().isOk())
                .andExpect(view().name("doctor/index"))
                .andExpect(model().attribute("doctors",hasSize(3)));
    }
}