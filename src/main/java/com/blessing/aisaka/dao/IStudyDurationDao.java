package com.blessing.aisaka.dao;

import com.blessing.aisaka.entity.StudyDuration;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/19
 */
@Mapper
@Repository
public interface IStudyDurationDao {

    StudyDuration queryByStudentAndCourse(Integer studentId, Integer courseId);

    int insertStudyRelation(StudyDuration studyDuration);

    int deleteRelationById(Integer id);

    List<StudyDuration> queryByStudent(Integer studentId);

    int parseStartTime(Integer id, Long startTime);

    StudyDuration queryStartTime(Integer studentId, Integer courseId);

    int updateDuration(StudyDuration studyDuration);
}
