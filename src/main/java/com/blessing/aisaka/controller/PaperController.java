package com.blessing.aisaka.controller;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.constant.JsonConstant;
import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.entity.Paper;
import com.blessing.aisaka.entity.Report;
import com.blessing.aisaka.entity.User;
import com.blessing.aisaka.service.IPaperService;
import com.blessing.aisaka.service.IReportService;
import com.blessing.aisaka.service.IUserService;
import com.blessing.aisaka.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * @author zhou.peng
 * @date 2019/03/25
 */
@RestController
public class PaperController {

    @Autowired
    private IPaperService paperService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IReportService reportService;

    /**
     * 编辑试卷信息
     *
     * @param paper
     * @return
     */
    @RequestMapping(value = "/admin/paper/edit", method = RequestMethod.PATCH)
    public JSONObject editPaper(Paper paper) {
        return paperService.editPaper(paper);
    }

    /**
     * 上传试卷PDF
     *
     * @param file
     * @param paper
     * @return
     */
    @RequestMapping(value = "/admin/paper/upload", method = RequestMethod.POST)
    public JSONObject uploadPaper(MultipartFile file, Paper paper) {
        return paperService.paperUpload(file, paper);
    }

    /**
     * 学生考试界面
     *
     * @param courseId
     * @return
     */
    @RequestMapping(value = "/user/paper/{courseId}", method = RequestMethod.GET)
    public ModelAndView startExam(Principal principal, @PathVariable Integer courseId) {
        ModelAndView mav = new ModelAndView("user/showPaper");
        Paper paper = paperService.queryPaperByCourse(new Course(courseId));
        User student = userService.queryStudentByName(principal.getName());
        Report report = reportService.queryReportByStudentAndPaper(student.getId(), paper.getId());
        reportService.parseStartTime(student.getId(), paper.getId(), System.currentTimeMillis());
        mav.addObject("paper", paper);
        mav.addObject("report", report);
        return mav;
    }

    /**
     * 交卷
     *
     * @return
     */
    @RequestMapping(value = "/user/paper/submit", method = RequestMethod.POST)
    public JSONObject submitPaper(Principal principal, Integer paperId, String answer) {
        User student = userService.queryStudentByName(principal.getName());
        return reportService.parseReport(student.getId(), paperId, answer);
    }

    /**
     * 判断是否已经考试
     */
    @RequestMapping(value = "/user/paper/", method = RequestMethod.POST)
    public JSONObject isTested(Integer studentId, Integer courseId) {
        return reportService.isComplete(studentId, courseId);
    }

    /**
     * 查询考试剩余时间
     */
    @RequestMapping(value = "/user/paper/restTime", method = RequestMethod.POST)
    public JSONObject restTime(Principal principal, Integer paperId) {
        User student = userService.queryStudentByName(principal.getName());
        return paperService.queryRestTime(student.getId(), paperId);
    }

}
