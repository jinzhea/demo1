package com.example.demo.controller;


import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    static Integer tap = 0;

    @Autowired
    private UserDao userDao;

    /**
     * 跳转到首页的方法
     *
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    /**
     * 跳转到添加页面的方法
     *
     * @return
     */
    @RequestMapping(value = "/add")
    public ModelAndView add(Model model) {
        model.addAttribute("user", new User());
        return new ModelAndView("adduser");
    }


    /**
     * 添加用户的方法
     * @param user
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(value = "/adduser")
    public ModelAndView adduser(@Valid User user, BindingResult result, Model model) {
        ModelAndView mv = new ModelAndView();
        model.addAttribute("user", user);
        mv.setViewName("adduser");
            if (!result.hasErrors()) {
                user.setCreat_time(new Date());
                user.setUpdate_time(new Date());
                userDao.save(user);
                mv.setViewName("redirect:/findallByPage?page=1&size=10");
            }
        return mv;
    }

    /**
     * 查找用户列表的方法
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/userlist")
    public ModelAndView userlist(Model model) {
        List<User> userlist = userDao.find();
        model.addAttribute("userlist", userlist);
        model.addAttribute("size",5);
        model.addAttribute("page",0);
        model.addAttribute("pagesize",2);
        model.addAttribute("pagenumber",1);
        model.addAttribute("elesize",10);
        return new ModelAndView("userlist");
    }

    /**
     * 查找用户详细信息的方法
     *
     * @return
     */
    @RequestMapping(value = "/userinfo")
    public ModelAndView userinfo(HttpServletRequest request, Model model) {
        User user = userDao.findById(Integer.parseInt(request.getParameter("id")));
        model.addAttribute("user", user);
        return new ModelAndView("userinfo");
    }

    /**
     * 删除用户的方法
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete")
    public ModelAndView delete(HttpServletRequest request) {
        userDao.delete(Integer.parseInt(request.getParameter("id")));
        return new ModelAndView("redirect:/findallByPage?page=1&size=10");
    }

    /**
     * 跳转到修改页面的方法
     *
     * @return
     */
    @RequestMapping(value = "/userupdate")
    public ModelAndView userupdate(HttpServletRequest request, Model model) {
        User user = userDao.findById(Integer.parseInt(request.getParameter("id")));
        model.addAttribute("user", user);
        return new ModelAndView("userupdate");
    }

    /**
     * 修改用户的方法
     * @param user
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(value = "/update")
    public ModelAndView update(@Valid User user, BindingResult result, Model model) {
        ModelAndView mv = new ModelAndView("userupdate");
        model.addAttribute("user", user);
        if (!result.hasErrors()) {
            user.setCreat_time(userDao.findById(user.getId()).getCreat_time());
            user.setUpdate_time(new Date());
            userDao.saveAndFlush(user);
            mv.setViewName("redirect:findallByPage?page=1&size=10");
        }
        return mv;
    }

    /**
     * 通过模糊查询查找用户的方法
     *
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/likefind")
    public ModelAndView likefind( @RequestParam(name = "likename") String likename, Model model) {
        List<User> userlist = userDao.findByKeyNameLimit(likename);
        model.addAttribute("userlist", userlist);
        model.addAttribute("pagesize",0);
        model.addAttribute("tip",0);
        model.addAttribute("count",userlist.size());
        return new ModelAndView("userlist");
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @param model
     * @return
     */
    @RequestMapping(value = "/findallByPage")
    public ModelAndView findAllByPage(@RequestParam(name = "page")Integer page ,@RequestParam(name = "size") Integer size, Model model) {
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page-1,size,sort);
        Page<User> pagelist =  userDao.findAll(pageable);
        Integer pagesize = pagelist.getTotalPages();
        Integer pagenumber = pageable.getPageNumber();
        Long elesize  = pagelist.getTotalElements();
        List<User> userList = pagelist.getContent();
        model.addAttribute("pagesize",pagesize);
        model.addAttribute("pagenumber",pagenumber);
        model.addAttribute("elesize",elesize);
        model.addAttribute("size",size);
        model.addAttribute("tip",1);
        model.addAttribute("userlist",userList);
        return new ModelAndView("userlist");
    }

    /**
     * 验证用户名是否存在
     * @param username
     * @return
     */
    @RequestMapping(value = "/checkname")
    public String checkname(@RequestParam String username){
        String s = "";
        boolean b = userDao.existsByUsername(username);
        if(b == true){
            s="用户名已存在";
        }
        return s;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/del")
    public ModelAndView del(@RequestParam String ids){
        String[] strArray = ids.split(",");
        for(int i=0;i<strArray.length;i++){
           userDao.delete(Integer.parseInt(strArray[i]));
        }
        return new ModelAndView("redirect:findallByPage?page=1&size=10");
    }


}
