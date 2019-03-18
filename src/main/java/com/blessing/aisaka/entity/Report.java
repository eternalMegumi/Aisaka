package com.blessing.aisaka.entity;

import java.io.Serializable;

/**
 * @author zhou.peng
 * @date 2019/03/08
 */
public class Report implements Serializable {
    private Integer id;
    private Integer paperId;
    private Integer courseId;
    private String courseName;
    private Integer studentId;
    private String studentName;
    private Double score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSheetId() {
        return paperId;
    }

    public void setSheetId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", paperId=" + paperId +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", score=" + score +
                '}';
    }
}
