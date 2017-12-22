package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private UserDao userDao;

    /**
     * 默认首页
     * 插入数据
     *
     * @return
     */
    @RequestMapping(value = "/")
    public ModelAndView head(Model model) {
        model.addAttribute("user", new User());
        return new ModelAndView("login");
    }

    /**
     * 登录的方法
     * @param user
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView login(User user, Model model, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("login");
        model.addAttribute("user", user);
        request.getSession().setAttribute("user", user);
        Boolean b = userDao.existsByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (b == true) {
            modelAndView.setViewName("index");
        } else {
            model.addAttribute("tip", 1);
        }
        return modelAndView;
    }


    /**
     * 脱出登录
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest request,Model model){
        request.getSession().removeAttribute("user");
        model.addAttribute("user",new User());
        return new ModelAndView("login");
    }

}
