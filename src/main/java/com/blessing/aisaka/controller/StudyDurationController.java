package com.blessing.aisaka.controller;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.StudyDuration;
import com.blessing.aisaka.service.IStudyDurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhou.peng
 * date 2019/03/19
 */
@RestController
@RequestMapping("/duration")
public class StudyDurationController {

    @Autowired
    private IStudyDurationService studyDurationService;

    /**
     * 安排学生操作
     *
     * @param studyDuration
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JSONObject addStudyRelation(StudyDuration studyDuration) {
        return studyDurationService.addStudyRelation(studyDuration);
    }

    /**
     * 删除学习关系
     *
     * @param studyDuration
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public JSONObject deleteStudyRelation(StudyDuration studyDuration) {
        return studyDurationService.deleteStudyRelation(studyDuration);
    }
}
