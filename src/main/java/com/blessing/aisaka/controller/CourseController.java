package com.blessing.aisaka.controller;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    public JSONObject addCourse(Course course) {
        return courseService.addCourse(course);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView listCourse() {
        ModelAndView mav = new ModelAndView("listCourse");
        List<Course> courseList = courseService.queryAllCourse();
        mav.addObject("courseList", courseList);
        return mav;
    }

    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    public ModelAndView courseDetail(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("editCourse");
        Course course = courseService.queryCourseById(id);
        mav.addObject("course", course);
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    public JSONObject editCourse(Course course) {
        return courseService.editCourse(course);
    }
}
