package com.blessing.aisaka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.constant.JsonConstant;
import com.blessing.aisaka.dao.ICourseDao;
import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.service.ICourseService;
import com.blessing.aisaka.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhou.peng
 * @date 2019/03/15
 */
@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseDao courseDao;

    @Override
    public JSONObject addCourse(Course course) {
        if (course != null) {
            if (courseDao.insertCourse(course) == 1) {
                return JsonUtil.buildJson(JsonConstant.SUCCESS, "创建成功");
            }
        }
        return JsonUtil.buildJson(JsonConstant.FAIL, "操作失败");
    }

    @Override
    public List<Course> queryAllCourse() {
        return courseDao.queryAllCourse();
    }

    @Override
    public Course queryCourseById(Integer id) {
        return courseDao.queryCourseById(id);
    }

    @Override
    public JSONObject editCourse(Course course) {
        if (course != null) {
            Course temp = courseDao.queryCourseById(course.getId());
            if (temp != null) {
                if (courseDao.updateCourse(course) == 1) {
                    return JsonUtil.buildJson(JsonConstant.SUCCESS, "修改成功");
                }
            } else {
                return JsonUtil.buildJson(JsonConstant.FAIL, "不存在该课程");
            }
        }
        return JsonUtil.buildJson(JsonConstant.FAIL, "修改失败");
    }

    @Override
    public List<Course> queryCourseByStudent(Integer id) {
        return courseDao.queryCourseByStudent(id);
    }

    @Override
    public List<Course> queryOtherCourseByStudent(Integer id) {
        Set<Course> all = new HashSet<Course>(queryAllCourse());
        List<Course> in = queryCourseByStudent(id);
        for (Course course : in) {
            if (all.contains(course)) {
                all.remove(course);
            }
        }
        return new ArrayList<Course>(all);
    }
}
