package com.wang.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        //放行 : 判断什么情况下登录
        //session中存在用户信息的时候放行
        if (session.getAttribute("userLoginInfo") != null) {
            return true;
        }
        //在登录页面的时候也放行
        if (request.getRequestURI().contains("goLogin")) {
            return true;
        }

        //第一次登录也是没有session的, 此时也要放行
        //包含login,说明正在登录
        if (request.getRequestURI().contains("login")) {
            return true;
        }


        //判断什么情况下没有登录
        //不在登录页或者没有登录的, 转发到登录页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }
}
