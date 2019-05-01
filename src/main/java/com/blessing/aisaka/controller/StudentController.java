package com.blessing.aisaka.controller;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.entity.User;
import com.blessing.aisaka.service.ICourseService;
import com.blessing.aisaka.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/14
 */
@RestController
public class StudentController {

    @Autowired
    IUserService userService;
    @Autowired
    ICourseService courseService;

    /**
     * 新建学生账户界面
     *
     * @return
     */
    @RequestMapping(value = "/admin/student/new", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("admin/addStudent");
    }

    /**
     * 新建学生操作
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/admin/student/new", method = RequestMethod.POST)
    public JSONObject addStudent(User user) {
        return userService.addStudentAccount(user);
    }

    /**
     * 全部学生界面
     *
     * @return
     */
    @RequestMapping(value = "/admin/student/all", method = RequestMethod.GET)
    public ModelAndView listStudent() {
        ModelAndView mav = new ModelAndView("admin/listStudent");
        List<User> studentList = userService.queryAllStudent();
        mav.addObject("studentList", studentList);
        return mav;
    }

    /**
     * 安排学生界面
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/admin/student/arrange/{id}")
    public ModelAndView arrangeStudent(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("admin/arrangeStudent");
        User student = userService.queryStudentById(id);
        List<Course> selectedCourse = courseService.queryCourseByStudent(id);
        List<Course> otherCourse = courseService.queryOtherCourseByStudent(id);
        mav.addObject("otherCourse", otherCourse);
        mav.addObject("selectedList", selectedCourse);
        mav.addObject("student", student);
        return mav;
    }
}
