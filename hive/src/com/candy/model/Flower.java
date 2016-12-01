package com.candy.model;

import java.sql.Date;

public class Flower {
	//列名：province,type,minPrice,avgPrice,maxPrice,color,unit
	//rowkey 哈希值_时间_市场_品名
	//	列族：Info
	//table name : Agricultural

	private String province;
	
	private String market;
	
	private String type;
	
	private String name;
	
	private String color;
	
	private String unit;
	
	private String minPrice;
	
	private String avgPrice;
	
	private String maxPrice;
	
	private Date time;

	public Flower() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public Flower(String province, String market, String type, String name, String color, String unit, String minPrice,
			String avgPrice, String maxPrice, Date time) {
		super();
		this.province = province;
		this.market = market;
		this.type = type;
		this.name = name;
		this.color = color;
		this.unit = unit;
		this.minPrice = minPrice;
		this.avgPrice = avgPrice;
		this.maxPrice = maxPrice;
		this.time = time;
	}





	@Override
	public String toString() {
		return "Flower [province=" + province + ", market=" + market + ", type=" + type + ", name=" + name + ", color="
				+ color + ", unit=" + unit + ", minPrice=" + minPrice + ", avgPrice=" + avgPrice + ", maxPrice="
				+ maxPrice + ", time=" + time + "]";
	}





	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(String avgPrice) {
		this.avgPrice = avgPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}


	
	

}
