package com.blessing.aisaka.entity;

import java.io.Serializable;
/**
 * @author zhou.peng
 * @date 2019.03.08
 */
public class Sheet implements Serializable {
    private String id;
    private String paperId;
    private String studentId;
    //TODO answer类型

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
