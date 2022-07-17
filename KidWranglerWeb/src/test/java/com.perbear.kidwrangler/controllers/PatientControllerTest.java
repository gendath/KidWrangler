package com.perbear.kidwrangler.controllers;

import com.perbear.kidwrangler.Model.Patient;
import com.perbear.kidwrangler.services.PatientService;
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
class PatientControllerTest {
    @Mock
    PatientService service;
    @InjectMocks
    PatientController controller;
    Set<Patient> patients;

    MockMvc mockMvc;


    @BeforeEach
    void setUp() {

        patients = new HashSet<>();
        patients.add(
                Patient.builder()
                        .Id(1L)
                        .build()
        );
        patients.add(
                Patient.builder()
                        .Id(2L)
                        .build()
        );
        patients.add(
                Patient.builder()
                        .Id(3L)
                        .build()
        );

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void home() throws Exception {

        when(service.findAll()).thenReturn(patients);
        mockMvc.perform(get("/patient"))
                .andExpect(status().isOk())
                .andExpect(view().name("patient/index"))
                .andExpect(model().attribute("patients",hasSize(3)));
    }
}