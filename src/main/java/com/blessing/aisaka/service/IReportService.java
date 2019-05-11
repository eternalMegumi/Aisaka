package com.blessing.aisaka.service;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.Report;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/18
 */
public interface IReportService {

    List<Report> queryReportsByCourseId(Integer courseId);

    Report queryReportById(Integer id);

    List<Report> queryReportByStudentId(Integer studentId);

    Report queryReportByStudentAndPaper(Integer studentId, Integer paperId);

    JSONObject parseReport(Integer studentId, Integer paperId, String answer);

    JSONObject isComplete(Integer studentId, Integer courseId);

    void parseStartTime(Integer studentId, Integer paperId, long startTime);

    void parseAnswerTime(Integer studentId, Integer paperId, String answer);

}
