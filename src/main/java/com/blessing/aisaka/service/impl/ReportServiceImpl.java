package com.blessing.aisaka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.constant.JsonConstant;
import com.blessing.aisaka.dao.IPaperDao;
import com.blessing.aisaka.dao.IReportDao;
import com.blessing.aisaka.entity.Paper;
import com.blessing.aisaka.entity.Report;
import com.blessing.aisaka.service.IPaperService;
import com.blessing.aisaka.service.IReportService;
import com.blessing.aisaka.utils.JsonUtil;
import com.blessing.aisaka.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhuo.peng
 * @date 2019/03/18
 */
@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private IReportDao reportDao;
    @Autowired
    private IPaperDao paperDao;

    @Override
    public List<Report> queryReportsByCourseId(Integer id) {
        return reportDao.queryReportsByCourseId(id);
    }

    @Override
    public Report queryReportById(Integer id) {
        return reportDao.queryReportById(id);
    }

    @Override
    public List<Report> queryReportByStudentId(Integer studentId) {
        return reportDao.queryReportByStudentId(studentId);
    }

    @Override
    public JSONObject parseReport(Integer studentId, Integer paperId, String answer) {
        Paper paper = paperDao.queryPaperById(paperId);
        Report report = reportDao.queryByStudentIdAndPaperId(studentId, paperId);
        if (report == null) {
            report = new Report();
            report.setCourseId(paper.getCourseId());
            report.setPaperId(paperId);
            report.setStudentId(studentId);
            report.setAnswerTime(0);
            report.setComplete(false);
            reportDao.insertReport(report);
        }
        report = reportDao.queryByStudentIdAndPaperId(studentId, paperId);
        report.setAnswer(answer);
        double score = getScore(answer, paper.getAnswer(), paper.getValue());
        report.setScore(score);
        int thisTime = TimeUtil.milesecondToMintue(System.currentTimeMillis() - report.getStart());
        report.setAnswerTime(report.getAnswerTime() + thisTime);
        report.setComplete(true);
        reportDao.updateScore(report);
        return JsonUtil.buildJson(JsonConstant.SUCCESS, "", score);
    }

    private double getScore(String answer, String correct, double value) {
        char[] answers = answer.toCharArray();
        char[] corrects = correct.toCharArray();
        int correctCount = 0;
        int max = (answers.length > corrects.length ? corrects.length : answers.length);
        for (int i = 0; i < max; i++) {
            if (corrects[i] == answers[i]) {
                correctCount++;
            }
        }
        return value * correctCount;
    }

    @Override
    public JSONObject isComplete(Integer studentId, Integer courseId) {
        Report report = reportDao.queryByStudentAndCourse(studentId, courseId);
        Boolean complete = report.getComplete();
        return JsonUtil.buildJson(JsonConstant.SUCCESS, "", complete);
    }

    @Override
    public Report queryReportByStudentAndPaper(Integer studentId, Integer paperId) {
        Report report = reportDao.queryByStudentIdAndPaperId(studentId, paperId);
        if (report == null) {
            report = new Report();
        }
        return report;
    }

    @Override
    public void parseStartTime(Integer studentId, Integer paperId, long startTime) {
        Report report = reportDao.queryByStudentIdAndPaperId(studentId, paperId);
        reportDao.parseStartTime(report.getId(), startTime);
    }

    @Override
    public void parseAnswerTime(Integer studentId, Integer paperId,String answer) {
        Report report = reportDao.queryByStudentIdAndPaperId(studentId, paperId);
        long startTime = report.getStart();
        int thisTime = TimeUtil.milesecondToMintue(System.currentTimeMillis()-startTime);
        report.setAnswerTime(report.getAnswerTime()+thisTime);
        report.setAnswer(answer);
        reportDao.updateAnswerTime(report);
    }
}
