package com.blessing.aisaka.controller;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.service.ICourseService;
import com.blessing.aisaka.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/15
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("addCourse");
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public JSONObject addCourse(String name, Long min, String deadline) {
        Course course = new Course(name, min, DateUtil.stringToDay(deadline));
        return courseService.addCourse(course);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView listCourse() {
        ModelAndView mav = new ModelAndView("listCourse");
        List<Course> courseList = courseService.queryAllCourse();
        mav.addObject("courseList", courseList);
        return mav;
    }
}
