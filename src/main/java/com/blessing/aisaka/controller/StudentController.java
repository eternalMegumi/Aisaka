package com.blessing.aisaka.controller;

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

    @RequestMapping(value = "/student")
    public ModelAndView index() {
        System.out.println("sss");
        return new ModelAndView("addStudent");
    }

}
