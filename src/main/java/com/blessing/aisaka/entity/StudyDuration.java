package com.blessing.aisaka.entity;

import java.io.Serializable;

/**
 * @author zhou.peng
 * @date 2019/03/08
 */
public class StudyDuration implements Serializable {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private Integer duration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
