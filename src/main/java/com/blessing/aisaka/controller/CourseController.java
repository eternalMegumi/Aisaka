package com.blessing.aisaka.controller;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.*;
import com.blessing.aisaka.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/15
 */
@RestController
public class CourseController {

    @Autowired
    private ICourseService courseService;
    @Autowired
    private IMaterialService materialService;
    @Autowired
    private IPaperService paperService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IStudyDurationService studyDurationService;

    /**
     * 添加课程页面
     *
     * @return
     */
    @RequestMapping(value = "/admin/course/new", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("admin/addCourse");
    }

    /**
     * 添加课程操作
     *
     * @param course
     * @return
     */
    @RequestMapping(value = "/admin/course/new", method = RequestMethod.POST)
    public JSONObject addCourse(Course course) {
        return courseService.addCourse(course);
    }

    /**
     * 显示课程页面
     *
     * @return
     */
    @RequestMapping(value = "/admin/course/all", method = RequestMethod.GET)
    public ModelAndView listCourse() {
        ModelAndView mav = new ModelAndView("admin/listCourse");
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
    @RequestMapping(value = "/admin/course/all/{id}", method = RequestMethod.GET)
    public ModelAndView courseDetail(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("admin/editCourse");
        Course course = courseService.queryCourseById(id);
        List<Material> materialList = materialService.queryMaterialByCourseId(course.getId());
        Paper paper = paperService.queryPaperByCourse(course);
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
    @RequestMapping(value = "/admin/course/edit", method = RequestMethod.PATCH)
    public JSONObject editCourse(Course course) {
        return courseService.editCourse(course);
    }

    /**
     * 学生选课页面
     *
     * @return
     */
    @RequestMapping(value = "/user/course/all", method = RequestMethod.GET)
    public ModelAndView selectCourse(Principal principal) {
        ModelAndView mav = new ModelAndView("user/course");
        String username = principal.getName();
        User student = userService.queryStudentByName(username);
        List<Course> otherCourse = courseService.queryOtherCourseByStudent(student.getId());
        mav.addObject("student", student);
        mav.addObject("otherCourse", otherCourse);
        return mav;
    }

    /**
     * 我的课程
     *
     * @param principal
     * @return
     */
    @RequestMapping(value = "/user/course/mine", method = RequestMethod.GET)
    public ModelAndView myCourse(Principal principal) {
        ModelAndView mav = new ModelAndView("user/myCourse");
        User student = userService.queryStudentByName(principal.getName());
        List<StudyDurationDto> selectedList = studyDurationService.queryStudyRelationInfo(student);
        mav.addObject("student", student);
        mav.addObject("selectedList", selectedList);
        return mav;
    }
}
