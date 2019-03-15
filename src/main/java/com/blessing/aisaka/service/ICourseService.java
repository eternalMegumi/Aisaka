package com.blessing.aisaka.service;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.Course;

/**
 * @author zhou.peng
 * @date 2019/03/15
 */
public interface ICourseService {
    JSONObject addCourse(Course course);
}
