package com.perbear.kidwrangler.controllers;

import com.perbear.kidwrangler.services.ParentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/parent")
@Controller
public class ParentController {
    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String home(Model model){
        model.addAttribute("parents",parentService.findAll());
        return "parent/index";
    }
}
