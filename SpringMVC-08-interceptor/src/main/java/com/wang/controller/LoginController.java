package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    //跳转到login
    @RequestMapping("/goLoginPage")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session, Model model) {
        //把用户的信息保存在session中
        session.setAttribute("userLoginInfo", username);

        model.addAttribute("username", username);
        return "main";
    }

    //跳转到main
    @RequestMapping("/goMainPage")
    public String mainPage() {
        return "main";
    }

    //注销
    @RequestMapping("/goOut")
    public String goOut(HttpSession session) {
        //移除节点
        session.removeAttribute("userLoginInfo");
        return "main";
    }
}
