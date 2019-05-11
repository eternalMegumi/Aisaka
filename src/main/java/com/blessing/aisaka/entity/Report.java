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
    private String answer;
    private Integer answerTime;
    private Boolean complete;
    private Long start;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Integer answerTime) {
        this.answerTime = answerTime;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
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
                ", answer='" + answer + '\'' +
                ", answerTime=" + answerTime +
                ", complete=" + complete +
                ", start=" + start +
                '}';
    }
}
