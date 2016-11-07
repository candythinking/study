package com.zkpk.main;
import org.apache.hadoop.conf.Configuration;  
import org.apache.hadoop.fs.Path;  
import org.apache.hadoop.io.IntWritable;  
import org.apache.hadoop.io.Text;  
import org.apache.hadoop.mapreduce.Job;  
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;  
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;  
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;  
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import com.google.gson.Gson;
import com.zkpk.mapper.IndexCountMap;
import com.zkpk.model.DWConf;
import com.zkpk.model.DWConfDAO;
import com.zkpk.reducer.IndexCountReduce;
  
public class IndexCount {  
    
    private static void printUsage() {
		System.out.println("Usage : <inputfilename> <outputfilename> <jobID>");
	}
  
    public static void main(String[] args) throws Exception {  
    	if (args.length != 3) {
			printUsage();
		}else {
			Configuration conf = new Configuration();  
			conf.set("inputfilename", args[0]);
			DWConf dwConf = DWConfDAO.modelQuery(Integer.parseInt(args[2]));
			Gson gson = new Gson();
			String sconf = gson.toJson(dwConf);
			conf.set("dwconf", sconf);
			Job job = Job.getInstance(conf);  
			job.setJarByClass(IndexCount.class);  
			job.setJobName("wordcount");  
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(Text.class);
			job.setOutputKeyClass(Text.class);  
			job.setOutputValueClass(IntWritable.class);  
			
			job.setMapperClass(IndexCountMap.class);  
			job.setReducerClass(IndexCountReduce.class);  
			
			job.setInputFormatClass(TextInputFormat.class);  
			job.setOutputFormatClass(TextOutputFormat.class);  
			
			FileInputFormat.addInputPath(job, new Path(args[0]));  
			FileOutputFormat.setOutputPath(job, new Path(args[1]));  
			
			job.waitForCompletion(true);  
		}
    }  
}