package com.example.demo.controller;

import org.springframework.web.servlet.ModelAndView;

public interface TransactionController {

    //跳转到订单管理页面
    public ModelAndView order();

    //跳转到退换货管理页面
    public ModelAndView change();

    //跳转到评价管理页面
    public ModelAndView comment();

    //跳转到发表评论页面
    public ModelAndView commentlist();

    //跳转到订单详情页面
    public ModelAndView orderinfo();

    //跳转到结算页面
    public ModelAndView pay();

    //跳转到支付成功界面
    public ModelAndView success();

    //跳转到钱款去向页面
    public ModelAndView record();

    //物流跟踪
    public ModelAndView logistics();




}
