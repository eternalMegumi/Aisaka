package com.blessing.aisaka.dao;

import com.blessing.aisaka.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/15
 */
@Mapper
@Repository
public interface ICourseDao {
    int insertCourse(Course course);

    List<Course> queryAllCourse();

    Course queryCourseById(Integer id);

    int updateCourse(Course course);

    List<Course> queryCourseByStudent(Integer id);
}
