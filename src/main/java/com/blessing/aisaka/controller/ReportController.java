package com.blessing.aisaka.controller;

import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.entity.Paper;
import com.blessing.aisaka.entity.Report;
import com.blessing.aisaka.entity.User;
import com.blessing.aisaka.service.ICourseService;
import com.blessing.aisaka.service.IPaperService;
import com.blessing.aisaka.service.IReportService;
import com.blessing.aisaka.service.IUserService;
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
 * @date 2019/03/18
 */
@RestController
public class ReportController {

    @Autowired
    private ICourseService courseService;
    @Autowired
    private IReportService reportService;
    @Autowired
    private IPaperService paperService;
    @Autowired
    private IUserService userService;

    /**
     * 成绩界面，显示全部课程
     *
     * @return
     */
    @RequestMapping(value = "/admin/report/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("admin/report");
        List<Course> courseList = courseService.queryAllCourse();
        mav.addObject("courseList", courseList);
        return mav;
    }

    /**
     * 显示某课程的全部成绩
     *
     * @param id 课程ID
     * @return
     */
    @RequestMapping(value = "/admin/report/{id}", method = RequestMethod.GET)
    public ModelAndView listReport(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("admin/listReport");
        List<Report> reportList = reportService.queryReportsByCourseId(id);
        mav.addObject("reportList", reportList);
        return mav;
    }

    /**
     * 查看学生的成绩详情
     *
     * @param id 成绩单ID
     * @return
     */
    @RequestMapping(value = "/admin/report/detail/{id}", method = RequestMethod.GET)
    public ModelAndView reportDetail(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("admin/reportDetail");
        Report report = reportService.queryReportById(id);
        Paper paper = paperService.queryPaperById(report.getPaperId());
        mav.addObject("report", report);
        mav.addObject("paper", paper);
        return mav;
    }

    /**
     * 学生查看成绩
     *
     * @return
     */
    @RequestMapping(value = "/user/report", method = RequestMethod.GET)
    public ModelAndView listReport(Principal principal) {
        ModelAndView mav = new ModelAndView("user/report");
        User student = userService.queryStudentByName(principal.getName());
        List<Report> reportList = reportService.queryReportByStudentId(student.getId());
        mav.addObject("reportList", reportList);
        mav.addObject("student", student);
        return mav;
    }

    /**
     * 学生查看成绩详情
     *
     * @return
     */
    @RequestMapping(value = "/user/report/{reportId}", method = RequestMethod.GET)
    public ModelAndView showReport(Principal principal, @PathVariable Integer reportId) {
        ModelAndView mav = new ModelAndView("user/showReport");
        Report report = reportService.queryReportById(reportId);
        Paper paper = paperService.queryPaperById(report.getPaperId());
        User student = userService.queryStudentByName(principal.getName());
        mav.addObject("report", report);
        mav.addObject("student",student);
        mav.addObject("paper", paper);
        return mav;
    }
}
