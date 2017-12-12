package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface UserController {
    //个人中心
    public ModelAndView person();

    //个人信息页面
    public ModelAndView index();

    //账户安全
    public ModelAndView safety();

    //地址管理
    public ModelAndView address(Model model);

    //快捷支付
    public ModelAndView cardlist();

    //跳转到添加银行卡页面银行卡
    public ModelAndView cardmethod();

    //添加银行卡
    public ModelAndView cardmethodadd();

    //新增收货地址
    public ModelAndView insertaddress(HttpServletRequest request);

    //跳转到修改收货人页面
    public ModelAndView updateaddress(HttpServletRequest request,Model model);

    //保存修改的收货人地址并跳转到收货人列表
    public ModelAndView changeaddress(HttpServletRequest request);

    //删除收货人地址并跳转到收货人列表
    public ModelAndView deleteaddress(HttpServletRequest request);

    //保存个人信息
    public ModelAndView saveinfomation(HttpServletRequest request, HttpSession session);

    //修改登录密码
    public ModelAndView password(HttpSession session);

    //设置支付密码
    public ModelAndView setpay();

    //绑定手机
    public ModelAndView bindphone();

    //绑定邮箱
    public ModelAndView email();

    //实名认证
    public ModelAndView idcard();

    //设置安全问题
    public ModelAndView question();


}
