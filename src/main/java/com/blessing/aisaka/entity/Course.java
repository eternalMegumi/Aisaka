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
    private Integer min;
    private Date deadline;
    private String deadlineStr;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Course(String name, Integer min, Date deadline) {
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

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        if (getId() != null ? !getId().equals(course.getId()) : course.getId() != null) return false;
        if (getName() != null ? !getName().equals(course.getName()) : course.getName() != null) return false;
        if (getMin() != null ? !getMin().equals(course.getMin()) : course.getMin() != null) return false;
        if (getDeadline() != null ? !getDeadline().equals(course.getDeadline()) : course.getDeadline() != null)
            return false;
        return getDeadlineStr() != null ? getDeadlineStr().equals(course.getDeadlineStr()) : course.getDeadlineStr() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getMin() != null ? getMin().hashCode() : 0);
        result = 31 * result + (getDeadline() != null ? getDeadline().hashCode() : 0);
        result = 31 * result + (getDeadlineStr() != null ? getDeadlineStr().hashCode() : 0);
        return result;
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
