package com.example.demo.controller.controllerimpl;

import com.example.demo.controller.AssetsController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AssetsControllerImpl implements AssetsController {

    @Override
    @RequestMapping(value = "/points")
    public ModelAndView points() {
        return new ModelAndView("points");
    }

    @Override
    @RequestMapping(value = "/coupon")
    public ModelAndView coupon() {
        return new ModelAndView("coupon");
    }

    @Override
    @RequestMapping(value = "/bonus")
    public ModelAndView bonus() {
        return new ModelAndView("bonus");
    }

    @Override
    @RequestMapping(value = "/walletlist")
    public ModelAndView walletlist() {
        return new ModelAndView("walletlist");
    }

    @Override
    @RequestMapping(value = "/bill")
    public ModelAndView bill() {
        return new ModelAndView("bill");
    }

    @Override
    @RequestMapping(value = "/wallet")
    public ModelAndView wallet() {
        return new ModelAndView("wallet");
    }

    @Override
    @RequestMapping(value = "/pointnew")
    public ModelAndView pointnew() {
        return new ModelAndView("pointnew");
    }

    @Override
    @RequestMapping(value = "/billlist")
    public ModelAndView billlist() {
        return new ModelAndView("billlist");
    }
}
