package com.example.demo.controller.controllerimpl;

import com.example.demo.controller.UserController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserControllerImpl implements UserController {

    /**
     * 个人信息页面
     * @return
     */
    @Override
    @RequestMapping(value = "/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    /**
     * 个人中心页面
     * @return
     */
    @Override
    @RequestMapping(value = "/information")
    public ModelAndView person() {
        return new ModelAndView("information");
    }

    /**
     * 安全设置页面
     * @return
     */
    @Override
    @RequestMapping(value = "/safety")
    public ModelAndView safety() {
        return new ModelAndView("safety");
    }

    /**
     * 地址管理页面
     * @return
     */
    @Override
    @RequestMapping(value = "/address")
    public ModelAndView address() {
        return new ModelAndView("address");
    }

    /**
     * 快捷支付页面
     * @return
     */
    @Override
    @RequestMapping(value = "/cardlist")
    public ModelAndView cardlist() {
        return new ModelAndView("cardlist");
    }
}
