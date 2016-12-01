package com.candy.model;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class UseFlower extends Flower {

	public static final byte[] TABLE_NAME = Bytes.toBytes("Agricultural");
	public static final byte[] INFO_FAM = Bytes.toBytes("Info");
	public static final byte[] province_COL = Bytes.toBytes("province");
	public static final byte[] type_COL = Bytes.toBytes("type");
	public static final byte[] minPrice_COL = Bytes.toBytes("minPrice");
	public static final byte[] avgPrice_COL = Bytes.toBytes("avgPrice");
	public static final byte[] maxPrice_COL = Bytes.toBytes("maxPrice");
	public static final byte[] color_COL = Bytes.toBytes("color");
	public static final byte[] unit_COL = Bytes.toBytes("unit");
	
	/**
	 * 为了查找的对象
	 * @param result
	 */
	public UseFlower(Result result) {
		this(result.getValue(INFO_FAM, province_COL), result.getValue(INFO_FAM,
				type_COL), result.getValue(INFO_FAM, minPrice_COL), result
				.getValue(INFO_FAM, avgPrice_COL), result
				.getValue(INFO_FAM, maxPrice_COL), result
				.getValue(INFO_FAM, color_COL), result
				.getValue(INFO_FAM, unit_COL));
	}
	
	/**
	 * 查找之后返回了byte数组的对象
	 */
	public UseFlower(byte[] province, byte[] type, byte[] minPrice, byte[] avgPrice, byte[] maxPrice, byte[] color, byte[] unit) {
		super(Bytes.toString(province), Bytes.toString(type), Bytes
				.toString(minPrice), Bytes.toString(avgPrice), Bytes.toString(maxPrice), Bytes
				.toString(color), Bytes.toString(unit));
	}
}
