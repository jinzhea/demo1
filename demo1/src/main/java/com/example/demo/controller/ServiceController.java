package com.example.demo.controller;

import org.springframework.web.servlet.ModelAndView;

public interface ServiceController {

    //跳转到商品咨询页面
    public ModelAndView consultation();

    //跳转到意见反馈页面
    public ModelAndView suggest();

    //跳转到我的消息页面
    public ModelAndView news();

    //跳转到新闻页面
    public ModelAndView blog();
}
