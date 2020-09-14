package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EncodingController {

    //过滤器解决乱码
    @PostMapping("/e/t1")
    public String test(String name, Model model) {

        System.out.println(name);
        model.addAttribute("msg", name);

        //返回的地址为转发的地址
        return "test";
    }
}
