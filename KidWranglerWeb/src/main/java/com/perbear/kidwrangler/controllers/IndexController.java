package com.perbear.kidwrangler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","index","index.html"})
    public String home(Model model){
        return "index";
    }
    @RequestMapping("/*")
    public String onError(Model model){
        return "notimplemented";
    }
}
