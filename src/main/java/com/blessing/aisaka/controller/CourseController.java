package com.blessing.aisaka.controller;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.entity.Material;
import com.blessing.aisaka.entity.Paper;
import com.blessing.aisaka.service.ICourseService;
import com.blessing.aisaka.service.IMaterialService;
import com.blessing.aisaka.service.IPaperService;
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
    @Autowired
    private IMaterialService materialService;
    @Autowired
    private IPaperService paperService;

    /**
     * 添加课程页面
     *
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("addCourse");
    }

    /**
     * 添加课程操作
     *
     * @param course
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public JSONObject addCourse(Course course) {
        return courseService.addCourse(course);
    }

    /**
     * 显示课程页面
     *
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView listCourse() {
        ModelAndView mav = new ModelAndView("listCourse");
        List<Course> courseList = courseService.queryAllCourse();
        mav.addObject("courseList", courseList);
        return mav;
    }

    /**
     * 编辑课程页面
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    public ModelAndView courseDetail(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("editCourse");
        Course course = courseService.queryCourseById(id);
        List<Material> materialList = materialService.queryMaterialByCourseId(course.getId());
        Paper paper = paperService.quertPaperByCourse(course);
        mav.addObject("course", course);
        mav.addObject("materialList", materialList);
        mav.addObject("paper", paper);
        return mav;
    }

    /**
     * 编辑操作
     *
     * @param course
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    public JSONObject editCourse(Course course) {
        return courseService.editCourse(course);
    }
}
