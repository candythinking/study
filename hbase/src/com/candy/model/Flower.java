package com.candy.model;

public class Flower {
	//列名：province,type,minPrice,avgPrice,maxPrice,color,unit
//rowkey 哈希值_时间_市场_品名
//	列族：Info
	//table name : Agricultural

	private String province;
	
	private String type;
	
	private String minPrice;
	
	private String avgPrice;
	
	private String maxPrice;
	
	private String color;
	
	private String unit;

	public Flower() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flower(String province, String type, String minPrice, String avgPrice, String maxPrice, String color,
			String unit) {
		super();
		this.province = province;
		this.type = type;
		this.minPrice = minPrice;
		this.avgPrice = avgPrice;
		this.maxPrice = maxPrice;
		this.color = color;
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Flower [province=" + province + ", type=" + type + ", minPrice=" + minPrice + ", avgPrice=" + avgPrice
				+ ", maxPrice=" + maxPrice + ", color=" + color + ", unit=" + unit + "]";
	}
	
	

}
