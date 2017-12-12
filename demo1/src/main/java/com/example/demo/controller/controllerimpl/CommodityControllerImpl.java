package com.example.demo.controller.controllerimpl;

import com.example.demo.controller.CommodityController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CommodityControllerImpl implements CommodityController {
    @Override
    @RequestMapping(value = "/introduction")
    public ModelAndView introduction() {
        return new ModelAndView("introduction");
    }
}
