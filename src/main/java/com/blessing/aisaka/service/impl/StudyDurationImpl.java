package com.blessing.aisaka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.constant.JsonConstant;
import com.blessing.aisaka.dao.IStudyDurationDao;
import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.entity.StudyDuration;
import com.blessing.aisaka.entity.StudyDurationDto;
import com.blessing.aisaka.entity.User;
import com.blessing.aisaka.service.ICourseService;
import com.blessing.aisaka.service.IStudyDurationService;
import com.blessing.aisaka.utils.JsonUtil;
import com.blessing.aisaka.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhou.peng
 * @date 2019/03/19
 */
@Service
public class StudyDurationImpl implements IStudyDurationService {

    @Autowired
    private IStudyDurationDao studyDurationDao;
    @Autowired
    private ICourseService courseService;

    @Override
    public JSONObject addStudyRelation(StudyDuration studyDuration) {
        studyDuration.setDuration(0);
        if (studyDurationDao.queryByStudentAndCourse(studyDuration.getStudentId(), studyDuration.getCourseId()) != null) {
            return JsonUtil.buildJson(JsonConstant.FAIL, "关系已存在");
        }
        if (studyDurationDao.insertStudyRelation(studyDuration) == 1) {
            return JsonUtil.buildJson(JsonConstant.SUCCESS, "添加成功");
        }
        return JsonUtil.buildJson(JsonConstant.FAIL, "操作失败");
    }

    @Override
    public JSONObject deleteStudyRelation(StudyDuration studyDuration) {
        studyDuration = studyDurationDao.queryByStudentAndCourse(studyDuration.getStudentId(), studyDuration.getCourseId());
        if (studyDuration == null) {
            return JsonUtil.buildJson(JsonConstant.FAIL, "关系不存在");
        }
        if (studyDurationDao.deleteRelationById(studyDuration.getId()) == 1) {
            return JsonUtil.buildJson(JsonConstant.SUCCESS, "删除成功");
        }
        return JsonUtil.buildJson(JsonConstant.FAIL, "操作失败");
    }

    @Override
    public List<StudyDurationDto> queryStudyRelationInfo(User student) {

        List<StudyDurationDto> studyDurationDtos = new ArrayList<StudyDurationDto>();

        List<Course> myCourses = courseService.queryCourseByStudent(student.getId());
        List<StudyDuration> studyDurations = studyDurationDao.queryByStudent(student.getId());
        if (myCourses == null || myCourses.size() == 0 || studyDurations == null || studyDurations.size() == 0) {
            return studyDurationDtos;
        }

        //转为map减少时间复杂度
        Map<Integer, StudyDuration> durationMap = new HashMap<Integer, StudyDuration>();
        for (StudyDuration studyDuration : studyDurations) {
            durationMap.put(studyDuration.getCourseId(), studyDuration);
        }

        //组装信息
        for (Course course : myCourses) {
            StudyDuration studyDuration = durationMap.get(course.getId());
            StudyDurationDto studyDurationDto = transferDuration(course, studyDuration);
            studyDurationDtos.add(studyDurationDto);
        }

        return studyDurationDtos;
    }

    private StudyDurationDto transferDuration(Course course, StudyDuration studyDuration) {
        StudyDurationDto studyDurationDto = new StudyDurationDto();
        studyDurationDto.setId(studyDuration.getId());
        studyDurationDto.setStudentId(studyDuration.getStudentId());
        studyDurationDto.setCourseId(studyDuration.getCourseId());
        studyDurationDto.setDuration(studyDuration.getDuration());
        studyDurationDto.setCourseName(course.getName());
        studyDurationDto.setMin(course.getMin());
        studyDurationDto.setDeadline(course.getDeadline());
        studyDurationDto.setDeadlineStr(course.getDeadlineStr());
        return studyDurationDto;
    }

    @Override
    public void parseStartTime(Integer studentId, Integer courseId, long startTime) {
        StudyDuration studyDuration = studyDurationDao.queryByStudentAndCourse(studentId, courseId);
        studyDurationDao.parseStartTime(studyDuration.getId(), startTime);
    }

    @Override
    public void parseDuration(Integer studentId, Integer courseId) {
        StudyDuration studyDuration = studyDurationDao.queryStartTime(studentId, courseId);
        long startTime = studyDuration.getStart();
        int duration = TimeUtil.milesecondToMintue(System.currentTimeMillis() - startTime);
        studyDuration.setDuration(studyDuration.getDuration() + duration);
        studyDurationDao.updateDuration(studyDuration);
    }
}
