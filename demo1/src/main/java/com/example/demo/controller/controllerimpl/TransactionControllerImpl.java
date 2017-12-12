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

    @Override
    @RequestMapping(value = "/pay")
    public ModelAndView pay() {
        return new ModelAndView("pay");
    }

    @Override
    @RequestMapping(value = "/success")
    public ModelAndView success() {
        return new ModelAndView("success");
    }

    @Override
    @RequestMapping(value = "/commentlist")
    public ModelAndView commentlist() {
        return new ModelAndView("commentlist");
    }

    @Override
    @RequestMapping(value = "/record")
    public ModelAndView record() {
        return new ModelAndView("record");
    }

    @Override
    @RequestMapping(value = "/logistics")
    public ModelAndView logistics() {
        return new ModelAndView("logistics");
    }
}
