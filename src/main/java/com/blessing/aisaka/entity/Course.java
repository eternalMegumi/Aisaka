package com.blessing.aisaka.entity;

import com.blessing.aisaka.utils.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhou.peng
 * @date 2019/03/08
 */
public class Course implements Serializable {
    private Integer id;
    private String name;
    private Long min;
    private Date deadline;
    private String deadlineStr;

    public Course() {
    }

    public Course(String name, Long min, Date deadline) {
        this.name = name;
        this.min = min;
        this.deadline = deadline;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMin() {
        return min;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadlineStr = DateUtil.dayToString(deadline);
        this.deadline = deadline;
    }

    public String getDeadlineStr() {
        return deadlineStr;
    }

    public void setDeadlineStr(String deadlineStr) {
        this.deadline = DateUtil.stringToDay(deadlineStr);
        this.deadlineStr = deadlineStr;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", min=" + min +
                ", deadline=" + deadline +
                ", deadlineStr='" + deadlineStr + '\'' +
                '}';
    }
}
