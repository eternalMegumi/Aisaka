package com.blessing.aisaka.service;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.StudyDuration;

/**
 * @author zhou.peng
 * @date 2019/03/19
 */
public interface IStudyDurationService {

    JSONObject addStudyRelation(StudyDuration studyDuration);

    JSONObject deleteStudyRelation(StudyDuration studyDuration);
}
