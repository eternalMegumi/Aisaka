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
 * @date 2019/03/14
 */
@RestController
public class StudentController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("addStudent");
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public JSONObject addStudent(User user) {
        return userService.addStudentAccount(user);
    }
}
