package com.blessing.aisaka.entity;

import java.io.Serializable;

/**
 * @author zhou.peng
 * @date 2019/03/08
 */
public class Paper implements Serializable {
    private Integer id;
    private Integer courseId;
    private String name;
    private Double value;
    private String answer;
    private Integer time;
    private String url;
    private Boolean prepared;

    public Paper() {
        this.name = "无";
    }

    public Paper(Integer courseId, String name, String url) {
        this.courseId = courseId;
        this.name = name;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getPrepared() {
        return prepared;
    }

    public void setPrepared(Boolean prepared) {
        this.prepared = prepared;
    }
}
