package com.candy.dao;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HConnection;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import com.candy.model.Flower;
import com.candy.model.UseFlower;

public class FlowerDao {
	
	public static final byte[] TABLE_NAME = Bytes.toBytes("Agricultural");
	public static final byte[] INFO_FAM = Bytes.toBytes("Info");
	public static final byte[] province_COL = Bytes.toBytes("province");
	public static final byte[] type_COL = Bytes.toBytes("type");
	public static final byte[] minPrice_COL = Bytes.toBytes("minPrice");
	public static final byte[] avgPrice_COL = Bytes.toBytes("avgPrice");
	public static final byte[] maxPrice_COL = Bytes.toBytes("maxPrice");
	public static final byte[] color_COL = Bytes.toBytes("color");
	public static final byte[] unit_COL = Bytes.toBytes("unit");
	
	private HConnection hConnection;
	public  FlowerDao(HConnection hConnection) {
		this.hConnection = hConnection;
	}
	
	private static Get mkGet(String rowkey) {
		Get g = new Get(Bytes.toBytes(rowkey));
		g.addFamily(INFO_FAM);
		return g;

	}



	public Flower getFlower(String rowkey) throws IOException {
		HTableInterface flowers = hConnection.getTable(TABLE_NAME);
		Result result = flowers.get(mkGet(rowkey));
		Flower flower = new UseFlower(result);
		flowers.close();
		return flower;
	}



}
