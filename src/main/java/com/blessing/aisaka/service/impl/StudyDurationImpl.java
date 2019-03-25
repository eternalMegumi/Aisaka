package com.blessing.aisaka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.constant.JsonConstant;
import com.blessing.aisaka.dao.IStudyDurationDao;
import com.blessing.aisaka.entity.StudyDuration;
import com.blessing.aisaka.service.IStudyDurationService;
import com.blessing.aisaka.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhou.peng
 * @date 2019/03/19
 */
@Service
public class StudyDurationImpl implements IStudyDurationService {

    @Autowired
    IStudyDurationDao studyDurationDao;

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
}
