package com.blessing.aisaka.dao;

import com.blessing.aisaka.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhou.peng
 * @date 2019/03/15
 */
@Mapper
@Repository
public interface ICourseDao {
    int insertCourse(Course course);
}
