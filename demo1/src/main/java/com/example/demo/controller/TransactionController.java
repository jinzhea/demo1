package com.example.demo.controller;

import org.springframework.web.servlet.ModelAndView;

public interface TransactionController {

    //跳转到订单管理页面
    public ModelAndView order();

    //跳转到退换货管理页面
    public ModelAndView change();

    //跳转到评价管理页面
    public ModelAndView comment();

    //跳转到订单详情页面
    public ModelAndView orderinfo();




}
