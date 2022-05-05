package com.perbear.kidwrangler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoctorController {

    @RequestMapping({"/doctor","/doctor/index","/doctor/index.html"})
    public String home(Model model){
        return "doctor/index";
    }
}
