package com.blessing.aisaka.service;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.Course;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/15
 */
public interface ICourseService {

    JSONObject addCourse(Course course);

    List<Course> queryAllCourse();

    Course queryCourseById(Integer id);

    JSONObject editCourse(Course course);

    /**
     * 查找某学生参加的课程
     *
     * @param id 学生id
     * @return 该学生参加的课程
     */
    List<Course> queryCourseByStudent(Integer id);

    /**
     * 查找某学生没参加的课程
     *
     * @param id 学生id
     * @return 该学生没参加的课程
     */
    List<Course> queryOtherCourseByStudent(Integer id);
}
