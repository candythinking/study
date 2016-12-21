package com.candy.model;

/**
 * Created by Administrator on 2016/12/16.
 */

public class tb_dataComplete {

    private Long id;

    private String regionCode;

    private String city;

    private String dataSum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String defaultValue;

    public tb_dataComplete(String regionCode, String city, String dataSum, String defaultValue) {
        this.regionCode = regionCode;
        this.city = city;
        this.dataSum = dataSum;
        this.defaultValue = defaultValue;
    }

    public tb_dataComplete() {
    }

    @Override
    public String toString() {
        return "tb_dataComplete{" +
                "id=" + id +
                ", regionCode='" + regionCode + '\'' +
                ", city='" + city + '\'' +
                ", dataSum='" + dataSum + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                '}';
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDataSum() {
        return dataSum;
    }

    public void setDataSum(String dataSum) {
        this.dataSum = dataSum;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
