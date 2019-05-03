package com.blessing.aisaka.service;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.StudyDuration;
import com.blessing.aisaka.entity.StudyDurationDto;
import com.blessing.aisaka.entity.User;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/19
 */
public interface IStudyDurationService {

    JSONObject addStudyRelation(StudyDuration studyDuration);

    JSONObject deleteStudyRelation(StudyDuration studyDuration);

    List<StudyDurationDto> queryStudyRelationInfo(User student);
}
