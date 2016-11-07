package com.zkpk.reducer;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import com.google.gson.Gson;
import com.zkpk.model.DWConf;

public class IndexCountReduce extends Reducer<Text, Text, Text, IntWritable> {

	private String regionName;
	private Text k = new Text();
	private DWConf dwConf;
	private String inputfilename;

	@Override
	protected void setup(Reducer<Text, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		super.setup(context);
		Configuration conf = context.getConfiguration();
		Gson gson = new Gson();
		dwConf = gson.fromJson(conf.get("dwconf"), DWConf.class);
		inputfilename = conf.get("inputfilename");
	}

	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		int sum = 0;
		for (Text val : values) {
			sum++;
			regionName = val.toString();
		}
		// key:regioncode+date
		// k:zsm,zbm,inputfilename,regionname,regioncode,date
		// v:count
		k.set(dwConf.getZsm() + "\t" + dwConf.getZbm() + "\t" + inputfilename + "\t" + regionName + "\t"
				+ key.toString());
		context.write(k, new IntWritable(sum));
	}
}