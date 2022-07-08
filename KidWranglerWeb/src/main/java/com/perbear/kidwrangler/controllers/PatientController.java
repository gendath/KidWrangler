package com.perbear.kidwrangler.controllers;


import com.perbear.kidwrangler.services.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/patient")
@Controller
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @RequestMapping({"","/","/index","/index.html"})
    public String home(Model model){
        model.addAttribute("patients", patientService.findAll());
        return "patient/index";
    }
}
