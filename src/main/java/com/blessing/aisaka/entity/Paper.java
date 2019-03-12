package com.blessing.aisaka.entity;

import java.io.Serializable;
/**
 * @author zhou.peng
 * @date 2019.03.08
 */
public class Paper implements Serializable {
    private String id;
    private String name;
    private Double value;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
