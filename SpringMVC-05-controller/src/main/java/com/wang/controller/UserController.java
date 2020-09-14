package com.wang.controller;

import com.wang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    //localhost: 8080/user/t1?name=xxx
    //前端的参数名与此处一致,可以直接用
    @GetMapping("/t1")
    public String test1(String name, Model model) {
        //1. 接受前端参数
        System.out.println("接受到前端的参数为: " + name);
        //2. 将返回的结果传递给前端
        model.addAttribute("msg", name);
        return "test";
    }

    //localhost: 8080/user/t1?username=xxx
    //前端的参数名与此处不一致, 需要加注解
    @GetMapping("/t2")
    public String test2(@RequestParam("username") String name, Model model) {
        //1. 接受前端参数
        System.out.println("接受到前端的参数为: " + name);
        //2. 将返回的结果传递给前端
        model.addAttribute("msg", name);
        return "test";
    }

    //前端接收的是一个对象 : id, name, age
    //localhost: 8080/user/t1?id=XXX&name=xxx&age=xxx
    /*
    1. 接受前端用户传递的参数, 判断参数的名字, 假设名字直接在方法上, 可以直接使用
    2. 假设传递的是一个对象User, 匹配User对象中的字段名: 如果名字一致则OK, 否则, 匹配不到
     */

    @GetMapping("/t3")
    public String test3(User user, Model model) {

        System.out.println(user);

        model.addAttribute("msg", user.toString());

        return "test";
    }

    @GetMapping("/t4")
    public String test4 (@RequestParam("username") String name, ModelMap map) {

        map.addAttribute("msg", name);
        System.out.println(name);

        return "test";
    }
}
