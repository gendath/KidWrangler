package com.perbear.kidwrangler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/doctor")
@Controller
public class DoctorController {

    @RequestMapping({"","/","/index","/index.html"})
    public String home(Model model){
        return "doctor/index";
    }
}
