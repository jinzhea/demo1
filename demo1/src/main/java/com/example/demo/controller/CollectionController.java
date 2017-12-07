package com.example.demo.controller;

import org.springframework.web.servlet.ModelAndView;

public interface CollectionController {

    //跳转到我的收藏页面
    public ModelAndView collection();

    //跳转到我的足记界面
    public ModelAndView foot();
}
