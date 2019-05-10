package com.blessing.aisaka.dao;

import com.blessing.aisaka.entity.Report;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/18
 */
@Mapper
@Repository
public interface IReportDao {
    List<Report> queryReportsByCourseId(Integer courseId);

    Report queryReportById(Integer id);

    List<Report> queryReportByStudentId(Integer studentId);

    Report queryByStudentIdAndPaperId(Integer studentId, Integer paperId);

    int insertReport(Report report);

    int updateScore(Report report);
}
