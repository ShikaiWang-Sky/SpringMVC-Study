package com.wang.controller;

import com.wang.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test() {
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param => " + name);
        if ("wang".equals(name)){
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2() {
        ArrayList<User> userArrayList = new ArrayList<>();
        //添加数据
        userArrayList.add(new User("wang_1", 1, "male"));
        userArrayList.add(new User("wang_2", 2, "female"));
        userArrayList.add(new User("wang_3", 3, "male"));
        return userArrayList;
    }

    @RequestMapping("/a3")
    public String a3(String name, String pwd) {
        String msg = "";
        if (name != null){
            //"admin"这些数据应该在数据库中查
            if("admin".equals(name)) {
                msg = "ok";
            } else {
                msg = "用户名有误";
            }
        }

        if (pwd != null){
            //"admin"这些数据应该在数据库中查
            if("123456".equals(pwd)) {
                msg = "ok";
            } else {
                msg = "密码有误";
            }
        }
        return msg;
    }
}
