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
    List<Report> queryReportsByCourseId(Integer id);

    Report queryReportById(Integer id);
}
