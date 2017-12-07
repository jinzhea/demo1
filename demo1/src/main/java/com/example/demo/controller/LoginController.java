package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface LoginController {

    //home目录
    public ModelAndView shouye();

    //跳转到登录页面
    public ModelAndView index();

    //登录验证
    public ModelAndView login(HttpServletRequest request, HttpSession session, Model model);


}
