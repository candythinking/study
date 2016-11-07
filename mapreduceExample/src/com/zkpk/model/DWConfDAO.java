package com.zkpk.model;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zkpk.utills.JDBCTools;

public class DWConfDAO {
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static DWConf modelQuery(int jobID) {
    	
    	Class cl = DWConf.class;
    	Connection conn = JDBCTools.openDB();
    	List list = new ArrayList();
    	try
    	{
    		PreparedStatement ptStatement = null;
    		ResultSet resultSet = null;
    		String sql = "";
    		sql = "select * from " + cl.getSimpleName().toLowerCase() + " where jobID="+jobID;
    		//System.out.println(sql);
    		Field[] fi = cl.getDeclaredFields();
    		
    		ptStatement = conn.prepareStatement(sql);
    		resultSet = ptStatement.executeQuery();
    		while(resultSet.next()){
    			Object ob = cl.newInstance();
    			for (Field field : fi) {
    				field.setAccessible(true);
    				field.set(ob, resultSet.getObject(field.getName()));
    			}
    			list.add(ob);
    		}
    		if (list.size()>0) {
    			return (DWConf)list.get(0);
			}else {
				return null;
			}
    		
    	}
    	catch (SQLException e)
    	{
    		e.printStackTrace();
    	} catch (InstantiationException e) {
    		e.printStackTrace();
    	} catch (IllegalAccessException e) {
    		e.printStackTrace();
    	} finally
    	{
    		JDBCTools.closeDB(conn);
    	}
    	return null;
    }

}
