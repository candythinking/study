package com.zkpk.mapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import com.google.gson.Gson;
import com.zkpk.model.DWConf;
import com.zkpk.utills.CandyUtills;

public class IndexCountMap extends Mapper<LongWritable, Text, Text, Text> {

	private Text v = new Text();
	private Text k = new Text();
	private String[] fileds;
	private Map<String, String> regionMap;
	private String gregioncode = null;
	private String gregionname = null;
	private DWConf dwConf;

	@Override
	protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		super.setup(context);
		Configuration conf = context.getConfiguration();
		Gson gson = new Gson();
		dwConf = gson.fromJson(conf.get("dwconf"), DWConf.class);
		// System.out.println("dwconf:"+dwConf);
		regionMap = new HashMap<String, String>();
		try {
			File file = new File("resources/regioncode.txt");
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), "utf-8");
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				String[] regions = null;
				String regioncode = null;
				String regionname = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					regions = lineTxt.split("\t");
					regioncode = regions[regions.length - 1];
					regionname = String.join("", regions).substring(0,
							String.join("", regions).length() - regioncode.length());
					regionMap.put(regioncode, regionname);
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		// for(Map.Entry<String, String> entry : regionMap.entrySet()){
		// System.out.println(entry.getKey()+"\t"+entry.getValue());
		// }
	}

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		fileds = value.toString().split(",");
		// System.out.println("fields.length:" + fileds.length);
		if (fileds.length == dwConf.getFieldsNum()
				&& (fileds[dwConf.getRegionCode() - 1].trim() != "" | fileds[dwConf.getRegionName() - 1].trim() != "")
				&& (fileds[dwConf.getPostTime() - 1].trim() != "" | fileds[dwConf.getUpdateTime() - 1].trim() != ""
						| fileds[dwConf.getAddTime() - 1].trim() != "")) {
			String date = CandyUtills.time(fileds[dwConf.getPostTime() - 1]);
			// System.out.println("date:" + date);
			if (date.length() != 7) {
				date = CandyUtills.time(fileds[dwConf.getUpdateTime() - 1]);
			}
			if (date.length() != 7) {
				date = CandyUtills.time(fileds[dwConf.getAddTime() - 1]);
			}
			if (date.length() != 7) {
				System.out.println("date不合格的数据:" + value.toString());
				return;
			}
			gregioncode = fileds[dwConf.getRegionCode() - 1].trim();
			gregionname = fileds[dwConf.getRegionName() - 1].trim();

			if (gregionname.equalsIgnoreCase("")) {
				gregionname = regionMap.get(gregioncode);
				for (Map.Entry<String, String> entry : regionMap.entrySet()) {
					if (entry.getKey().contains(gregioncode)) {
						gregionname = entry.getValue();
					}
				}
				if (gregionname.equalsIgnoreCase("")) {
					System.out.println("没有regionname的数据:" + value.toString());
					return;
				}
			}

			if (gregioncode.equalsIgnoreCase("")) {
				for (Map.Entry<String, String> entry : regionMap.entrySet()) {
					if (entry.getValue().contains(gregionname)) {
						gregioncode = entry.getKey();
					}
				}
				if (gregioncode.equalsIgnoreCase("")) {
					System.out.println("没有regioncode的数据:" + value.toString());
					return;
				}
			}
			gregioncode = gregioncode.substring(1, gregioncode.length() - 1);
			k.set(gregioncode + "\t" + date);
			v.set(gregionname.substring(1, gregionname.length() - 1));
			context.write(k, v);
		} else {
			System.out.println("不合格的数据:" + value.toString());
		}

	}
}
