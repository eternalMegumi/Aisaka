package com.blessing.aisaka.domain;

import java.io.Serializable;

public class Material implements Serializable {
    private String id;
    private String courseId;

    //TODO PDF
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}