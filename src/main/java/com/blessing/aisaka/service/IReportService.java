package com.blessing.aisaka.service;

import com.blessing.aisaka.entity.Report;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/18
 */
public interface IReportService {

    List<Report> queryReportsByCourseId(Integer id);
}
