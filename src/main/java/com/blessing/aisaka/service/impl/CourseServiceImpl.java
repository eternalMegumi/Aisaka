package com.blessing.aisaka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.constant.JsonStatus;
import com.blessing.aisaka.dao.ICourseDao;
import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.service.ICourseService;
import com.blessing.aisaka.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/15
 */
@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    ICourseDao courseDao;

    @Override
    public JSONObject addCourse(Course course) {
        if (course != null) {
            int status = courseDao.insertCourse(course);
            if (status == 1) {
                return JsonUtil.buildJson(JsonStatus.SUCCESS, "创建成功");
            }
        }
        return JsonUtil.buildJson(JsonStatus.FAIL, "操作失败");
    }

    @Override
    public List<Course> queryAllCourse() {
        return courseDao.queryAllCourse();
    }

    @Override
    public Course queryCourseById(Integer id) {
        return courseDao.queryCourseById(id);
    }
}
