package com.zkpk.utills;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CandyUtills {
	
	//抽取年月字段并返回	example：2016-01-1  返回	2016-01
	public static String time(String str){
        Pattern p = Pattern.compile("([0-9]{4})([年|\\-|/|.])([0-9]{1,2})");
        Matcher m = p.matcher(str);
        String date="";
        while (m.find()) {
            if (!"".equals(m.group())) {
                date = m.group();
                date = date.replaceAll("年", "-");
                date = date.replaceAll("月", "-");
                date = date.replaceAll("/", "-");
                date = date.replaceAll("\\.", "-");
                if (date.split("-")[1].length()==1) {
					date = date.replaceAll(date.split("-")[1], "0"+date.split("-")[1]);
				}
            }
        }
        return date;
    }
}
