package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//代表这个类会被Spring接管, 这个注解的类中的所有方法, 如果返回值是String, 并且有具体的页面可以跳转, 那么就会被视图解析器解析!
@Controller
public class ControllerTest2 {

    //映射访问路径
    @RequestMapping("/t2")
    public String test2 (Model model) {

        model.addAttribute("msg", "ControllerTest2");

        //此处的返回的字符串与要跳转的页面名一致!
        return "test";
    }

    //映射访问路径
    @RequestMapping("/t3")
    public String test3 (Model model) {

        model.addAttribute("msg", "ControllerTest3");

        //此处的返回的字符串与要跳转的页面名一致!
        return "test";
    }

}
