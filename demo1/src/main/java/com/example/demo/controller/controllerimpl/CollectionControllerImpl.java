package com.example.demo.controller.controllerimpl;

import com.example.demo.controller.CollectionController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CollectionControllerImpl implements CollectionController{

    @Override
    @RequestMapping(value = "/collection")
    public ModelAndView collection() {
        return new ModelAndView("collection");
    }

    @Override
    @RequestMapping(value = "/foot")
    public ModelAndView foot() {
        return new ModelAndView("foot");
    }
}
