package com.candy.main;

import java.io.IOException;
import java.sql.Timestamp;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;

import com.candy.model.Flower;
import com.candy.model.UseFlower;
import com.candy.utills.TimestampTool;

import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;

public class Main {

	public static void main(String[] args) {
		/*System.out.println(TimestampTool.crunttime());
		Timestamp t1 = TimestampTool.crunttime();
		for(int i =0 ;i<1000000;i++){
			
		}
		Timestamp t2 = TimestampTool.crunttime();
		long l = t2.getTime() - t1.getTime();
		System.out.println(l);*/
		test();
		
	}
	
	public static void test(){
		Timestamp t1 = TimestampTool.crunttime();
		Configuration conf;
		HTable table = null;
		Scan scan = new Scan();
		conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.property.clientPort", "2181");
		conf.set("hbase.zookeeper.quorum", "192.168.185.13");
		conf.set("hbase.zookeeper.quorum", "192.168.185.8");
		conf.set("hbase.zookeeper.quorum", "192.168.185.3");
		conf.set("hbase.master", "192.168.185.14:60000");
		String search = "鲜花";
		Filter filter = new RowFilter(CompareOp.EQUAL,new RegexStringComparator(".*"+search+".*")); 
		//scan.setFilter(filter); 
		ResultScanner scanner;
		
		long count = 0;
		try {
			table = new HTable(conf, "Agricultural");
			scanner = table.getScanner(scan);
			for(Result result : scanner){
				Flower flower = new UseFlower(result);
				count ++;
//				System.out.println(flower);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Timestamp t2 = TimestampTool.crunttime();
		long l = t2.getTime() - t1.getTime();
		System.out.println("执行总时间:"+l+"秒"+",一共查询的条数:"+count);
	}
}
