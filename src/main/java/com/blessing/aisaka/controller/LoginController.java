package com.blessing.aisaka.controller;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.User;
import com.blessing.aisaka.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhou.peng
 * @date 2018/03/11
 */
@RestController
public class LoginController {

    @Autowired
    IUserService userService;

    /**
     * 登录界面
     *
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    /**
     * 管理员首页
     *
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    /**
     * 注册界面
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    /**
     * 注册操作
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JSONObject registerAccount(User user) {
        return userService.addStudentAccount(user);
    }

    /**
     * 找回密码界面
     *
     * @return
     */
    @RequestMapping("/forgot-password")
    public ModelAndView forgotPassword() {
        return new ModelAndView("forgot-password");
    }

    /**
     * 学生首页
     *
     * @return
     */
    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home");
    }
}
