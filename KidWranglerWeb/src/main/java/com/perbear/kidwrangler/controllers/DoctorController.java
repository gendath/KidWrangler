package com.perbear.kidwrangler.controllers;

import com.perbear.kidwrangler.services.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/doctor")
@Controller
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String home(Model model){
        model.addAttribute("doctors",doctorService.findAll());
        return "doctor/index";
    }
}
