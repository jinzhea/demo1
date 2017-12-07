package com.example.demo.controller;

import org.springframework.web.servlet.ModelAndView;

public interface UserController {
    //个人中心
    public ModelAndView person();

    //个人信息页面
    public ModelAndView index();

    //账户安全
    public ModelAndView safety();

    //地址管理
    public ModelAndView address();

    //快捷支付
    public ModelAndView cardlist();



}
