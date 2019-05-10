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

    JSONObject parseReport(Integer studentId, Integer paperId, String answer);
}
