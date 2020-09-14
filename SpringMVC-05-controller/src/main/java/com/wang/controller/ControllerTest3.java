package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c3")
public class ControllerTest3 {

    //此时要访问/c3/t1才能访问到下面写的资源
    @RequestMapping("/t1")
    public String test3(Model model) {
        model.addAttribute("msg", "ControllerMapping");
        return "test";
    }
}
