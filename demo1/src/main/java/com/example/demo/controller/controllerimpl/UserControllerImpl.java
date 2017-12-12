package com.example.demo.controller.controllerimpl;

import com.example.demo.controller.UserController;
import com.example.demo.dao.AddressJPA;
import com.example.demo.dao.UserJPA;
import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RestController
public class UserControllerImpl implements UserController {


    @Autowired
    private AddressJPA addressJPA;

    @Autowired
    private UserJPA userJPA;


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
    public ModelAndView address(Model model) {
        List<Address> list = addressJPA.findAll();
        model.addAttribute("list",list);
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

    @Override
    @RequestMapping(value = "/insertaddress")
    public ModelAndView insertaddress(HttpServletRequest request) {
        Address address =new Address();
        address.setTonsignee(request.getParameter("tonsignee"));
        address.setTelephone(request.getParameter("telephone"));
        address.setProvince(request.getParameter("province"));
        address.setCity(request.getParameter("city"));
        address.setDist(request.getParameter("dist"));
        address.setAddress(request.getParameter("address"));
        addressJPA.save(address);
        return new ModelAndView("redirect:/address");
    }

    @Override
    @RequestMapping(value = "/updateaddress")
    public ModelAndView updateaddress(HttpServletRequest request,Model model) {
        Address address = addressJPA.findById(Integer.parseInt(request.getParameter("id")));
        model.addAttribute("address",address);
        return new ModelAndView("updateaddress");
    }

    @Override
    @RequestMapping(value = "/changeaddress")
    public ModelAndView changeaddress(HttpServletRequest request) {
        Address address = addressJPA.findById(Integer.parseInt(request.getParameter("id")));
        address.setTonsignee(request.getParameter("tonsignee"));
        address.setTelephone(request.getParameter("telephone"));
        address.setProvince(request.getParameter("province"));
        address.setCity(request.getParameter("city"));
        address.setDist(request.getParameter("dist"));
        address.setAddress(request.getParameter("address"));
        addressJPA.saveAndFlush(address);
        return new ModelAndView("redirect:/address");
    }

    @Override
    @RequestMapping(value = "/deleteaddress")
    public ModelAndView deleteaddress(HttpServletRequest request) {
        addressJPA.delete( Integer.parseInt(request.getParameter("id")));
        return new ModelAndView("redirect:/address");
    }


    @Override
    @Transactional
    @RequestMapping(value = "/saveinfomation")
    public ModelAndView saveinfomation(HttpServletRequest request,HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user!=null){
            System.out.println(user);
            String nickname =request.getParameter("nickname");
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            if(nickname!=null&&year!=null&&month!=null&&day!=null&&name!=null&&sex!=null&&phone!=null&&email!=null) {
                String birthday = year + month + day;
                user.setNickname(nickname);
                user.setName(name);
                user.setBirthday(birthday);
                user.setSex(sex);
                user.setPhone(phone);
                user.setEmail(email);
                userJPA.saveAndFlush(user);
                session.setAttribute("user", user);
            }
        }
        return new ModelAndView("redirect:/index");
    }

    @Override
    @RequestMapping(value = "/cardmethod")
    public ModelAndView cardmethod() {
        return new ModelAndView("cardmethod");
    }

    @Override
    @RequestMapping(value = "/cardmethodadd")
    public ModelAndView cardmethodadd() {

        return new ModelAndView("cardlist");
    }

    @Override
    @RequestMapping(value = "/password")
    public ModelAndView password(HttpSession session) {
        return new ModelAndView("password");
    }

    @Override
    @RequestMapping(value = "/setpay")
    public ModelAndView setpay() {
        return new ModelAndView("setpay");
    }

    @Override
    @RequestMapping(value = "/bindphone")
    public ModelAndView bindphone() {
        return new ModelAndView("bindphone");
    }

    @Override
    @RequestMapping(value = "/email")
    public ModelAndView email() {
        return new ModelAndView("email");
    }

    @Override
    @RequestMapping(value = "/idcard")
    public ModelAndView idcard() {
        return new ModelAndView("idcard");
    }

    @Override
    @RequestMapping(value = "/question")
    public ModelAndView question() {
        return new ModelAndView("question");
    }
}
