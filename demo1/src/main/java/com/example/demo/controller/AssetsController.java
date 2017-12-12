package com.example.demo.controller;

import org.springframework.web.servlet.ModelAndView;

public interface AssetsController {
    //跳转到我的积分页面
    public ModelAndView points();

    //跳转到优惠券页面
    public ModelAndView coupon();

    //跳转到红包页面
    public ModelAndView bonus();

    //跳转到账单明细页面
    public ModelAndView walletlist();

    //跳转到账单页面
    public ModelAndView bill();

    //跳转到账单明细页面
    public ModelAndView billlist();

    //跳转到账户余额页面
    public ModelAndView wallet();

    //跳转到总积分的页面
    public ModelAndView pointnew();


}
