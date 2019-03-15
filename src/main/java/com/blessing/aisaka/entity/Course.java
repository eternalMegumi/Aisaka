package com.blessing.aisaka.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhou.peng
 * @date 2019/03/08
 */
public class Course implements Serializable {
    private String id;
    private String name;
    private Long min;
    private Date deadline;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        this.deadline = deadline;
    }

    public Course(String name, Long min, Date deadline) {
        this.name = name;
        this.min = min;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", min=" + min +
                ", deadline=" + deadline +
                '}';
    }
}
