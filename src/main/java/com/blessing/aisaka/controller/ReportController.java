package com.blessing.aisaka.controller;

import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.entity.Paper;
import com.blessing.aisaka.entity.Report;
import com.blessing.aisaka.service.ICourseService;
import com.blessing.aisaka.service.IPaperService;
import com.blessing.aisaka.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/18
 */
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ICourseService courseService;
    @Autowired
    IReportService reportService;
    @Autowired
    IPaperService paperService;

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("report");
        List<Course> courseList = courseService.queryAllCourse();
        mav.addObject("courseList", courseList);
        return mav;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView listReport(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("listReport");
        List<Report> reportList = reportService.queryReportsByCourseId(id);
        mav.addObject("reportList", reportList);
        return mav;
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ModelAndView reportDetail(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("reportDetail");
        Report report = reportService.queryReportById(id);
        Paper paper = paperService.queryPaperById(report.getPaperId());
        mav.addObject("report", report);
        mav.addObject("paper", paper);
        return mav;
    }
}
