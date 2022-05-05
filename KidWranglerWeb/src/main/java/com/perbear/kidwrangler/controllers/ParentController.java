package com.perbear.kidwrangler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParentController {

    @RequestMapping({"/parent","/parent/index","/parent/index.html"})
    public String home(Model model){
        return "parent/index";
    }
}
