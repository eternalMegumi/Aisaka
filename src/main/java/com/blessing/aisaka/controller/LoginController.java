package com.blessing.aisaka.controller;

import com.blessing.aisaka.entity.Admin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhou.peng
 * @date 2018/03/11
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/index")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public Admin check(Admin admin) {
//        System.out.println(request.getParameter("username") + ":" + request.getParameter("password"));
        System.out.println(admin.getName() + ":" + admin.getPassword());
        return admin;
    }

    @RequestMapping("/test")
    public String test() {
        System.out.println("---------");
        return "dd";
    }
}
