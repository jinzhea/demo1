package com.example.demo.controller.controllerimpl;

import com.example.demo.controller.LoginController;
import com.example.demo.dao.UserJPA;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginControllerImpl implements LoginController {
    @Autowired
    private UserJPA userJPA;

    @Override
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView shouye(){
        return new ModelAndView("home");
    }

    @Override
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("login");
    }

    @Override
    @RequestMapping(value = "/entry",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpSession session, Model model) {
       ModelAndView mv = new ModelAndView();

        User user = userJPA.findByUsernameAndPassword(request.getParameter("username"),request.getParameter("password"));
        if(null!=user){
            mv.setViewName("home");
            session.setAttribute("user",user);
        }else {
            mv.setViewName("login");
            model.addAttribute("tip","用户名或密码错误");
        }
       return mv;
    }
}
