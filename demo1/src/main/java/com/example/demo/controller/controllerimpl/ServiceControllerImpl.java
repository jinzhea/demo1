package com.example.demo.controller.controllerimpl;

import com.example.demo.controller.ServiceController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ServiceControllerImpl implements ServiceController {


    @Override
    @RequestMapping(value = "/consultation")
    public ModelAndView consultation() {
        return new ModelAndView("consultation");
    }

    @Override
    @RequestMapping(value = "/suggest")
    public ModelAndView suggest() {
        return new ModelAndView("suggest");
    }

    @Override
    @RequestMapping(value = "/news")
    public ModelAndView news() {
        return new ModelAndView("news");
    }
}
