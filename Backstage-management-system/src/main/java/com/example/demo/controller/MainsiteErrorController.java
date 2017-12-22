package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class MainsiteErrorController implements ErrorController {
    private static final String ERROR_PATH = "/error";

    /**
     * 错误页面统统返回到登录页面
     * @param model
     * @return
     */
    @RequestMapping(value = ERROR_PATH)
    public String handleError(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }


    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
