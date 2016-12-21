package com.candy.model;

import java.util.List;

/**
 * Created by kuzon on 11/20/16.
 */
public class Series {
    private String name;
    private String type;
    private List<Double> data;

    public Series() {
    }

    public Series(String name, String type, List<Double> data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Series{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", data=" + data.toArray() +
                '}';
    }
}
