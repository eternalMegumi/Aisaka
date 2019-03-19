package com.blessing.aisaka.service.impl;

import com.blessing.aisaka.dao.IReportDao;
import com.blessing.aisaka.entity.Report;
import com.blessing.aisaka.service.IReportService;
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

    @Override
    public List<Report> queryReportsByCourseId(Integer id) {
        return reportDao.queryReportsByCourseId(id);
    }

    @Override
    public Report queryReportById(Integer id) {
        return reportDao.queryReportById(id);
    }
}
