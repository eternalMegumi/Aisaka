package com.blessing.aisaka.controller;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.User;
import com.blessing.aisaka.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

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
    @RequestMapping("/")
    public ModelAndView login() {
        return new ModelAndView("login");
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
     * 管理员首页
     *
     * @return
     */
    @RequestMapping("/admin/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    /**
     * 学生首页
     *
     * @return
     */
    @RequestMapping("/user/index")
    public ModelAndView home(Principal principal) {
        return new ModelAndView("home");
    }
}
