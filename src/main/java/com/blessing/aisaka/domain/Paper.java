package com.blessing.aisaka.domain;

import java.io.Serializable;

public class Paper implements Serializable {
    private String id;
    private String name;
    private Double score;
    //TODO PDF,answer

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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
