package com.candy.model;

import java.util.List;

/**
 * Created by kuzon on 11/20/16.
 */
public class Bar {
    private String title;
    private List<String> legend;
    private List<String> xAxis;
    private Series series;

    public Bar() {
    }

    public Bar(String title, List<String> legend, List<String> xAxis, Series series) {
        this.title = title;
        this.legend = legend;
        this.xAxis = xAxis;
        this.series = series;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLegend() {
        return legend;
    }

    public void setLegend(List<String> legend) {
        this.legend = legend;
    }

    public List<String> getxAxis() {
        return xAxis;
    }

    public void setxAxis(List<String> xAxis) {
        this.xAxis = xAxis;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "title='" + title + '\'' +
                ", legend=" + legend +
                ", xAxis=" + xAxis +
                ", series=" + series +
                '}';
    }
}
