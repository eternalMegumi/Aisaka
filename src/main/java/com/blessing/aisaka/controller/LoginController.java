package com.blessing.aisaka.controller;

import com.blessing.aisaka.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhou.peng
 * @date 2018/03/11
 */
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    IUserService adminService;

    @RequestMapping("login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

}
