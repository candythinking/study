package com.zkpk.main;


import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.zkpk.model.DWConf;
import com.zkpk.model.DWConfDAO;

public class Test {

	public static void main(String[] args) {
		DWConf conf = DWConfDAO.modelQuery(2);
		Gson gson = new Gson();
		String sconf = gson.toJson(conf);
		System.out.println(sconf);
		DWConf nconf = gson.fromJson(sconf, DWConf.class);
		System.out.println(nconf);
		Map<String, String> map = new HashMap<>();
		map.put("a", "1");
		System.out.println(map.get("b"));

	}

}
