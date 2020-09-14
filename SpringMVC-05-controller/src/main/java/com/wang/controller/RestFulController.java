package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {

//    //原来的
//    //http://localhost:8080/add?a=1&b=2
//    //由于此处要求有两个参数, url必须传参, 否则报500错误
//    @RequestMapping("/add")
//    public String test(int a, int b, Model model) {
//        int res = a + b;
//        model.addAttribute("msg", "结果为" + res);
//        return "test";
//    }

//    //使用RestFul风格, 变量用 / 分隔
//    //此时的url: http://localhost:8080/add/1/2
//    @RequestMapping("/add/{a}/{b}")
//    public String test(@PathVariable int a, @PathVariable int b, Model model) {
//        int res = a + b;
//        model.addAttribute("msg", "结果为" + res);
//        return "test";
//    }

    /*
    此注解与下面的注解等价, 都是以get方法去提交
    @RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.GET)
    */
    @GetMapping("/add/{a}/{b}")
    public String test(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "结果为" + res);
        return "test";
    }

}
