package com.example.demo.controller.controllerimpl;

import com.example.demo.controller.TransactionController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TransactionControllerImpl implements TransactionController{

    /**
     * 订单管理页面
     * @return
     */
    @Override
    @RequestMapping(value = "/order")
    public ModelAndView order() {
        return new ModelAndView("order");
    }

    @RequestMapping(value = "/head")
    public ModelAndView dead(){
        return new ModelAndView("head");
    }

    @Override
    @RequestMapping(value = "/change")
    public ModelAndView change() {
        return new ModelAndView("change");
    }

    @Override
    @RequestMapping(value = "/comment")
    public ModelAndView comment() {
        return new ModelAndView("comment");
    }

    @Override
    @RequestMapping(value = "/orderinfo")
    public ModelAndView orderinfo() {
        return new ModelAndView("orderinfo");
    }
}
