package com.candy.hive;

/**
 * Created by Administrator on 2016/11/21.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.candy.utils.JDBCTools;

public class QueryHiveUtils {
    private static Connection conn=JDBCToHiveUtils.getConnnection();
    private static PreparedStatement ps;
    private static ResultSet rs;
    public static void hiveToMysql()
    {
//    	String insertSQL = "insert into farm(province,market,type,name,standard,area,color,unit,minPrice,avgPrice,maxPrice,entertime,time)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    	String insertSQL = "insert into flowers(province,market,type,name,color,unit,minPrice,avgPrice,maxPrice,time)values(?,?,?,?,?,?,?,?,?,?);";
    	String hiveSQL = "select * from flowers where time >= \"" + getProviceDay(new Date(), -16) + "\" and time <= \"" + getProviceDay(new Date(), -1) + "\"";
    	String deleteSQL = "truncate table flowers";
    	Connection connection = JDBCTools.openDB();
    	//清空mysql表数据
    	try {
			PreparedStatement cleanPS = connection.prepareStatement(deleteSQL);
			cleanPS.executeUpdate();
			cleanPS.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        System.out.println(hiveSQL);
        try {
            ps=JDBCToHiveUtils.prepare(conn, hiveSQL);
            //hive查询
            rs=ps.executeQuery();
            int columns=rs.getMetaData().getColumnCount();
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            //将hive查询的结果插入mysql中
            while(rs.next())
            {
                for(int i=1;i<=columns;i++)
                {
                    System.out.print(rs.getString(i));
                    System.out.print("\t\t");
                    preparedStatement.setString(i,rs.getString(i));
                    
                }
                preparedStatement.executeUpdate();
                System.out.println();
            }
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

    }
    
    public static String getProviceDay(Date date,int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, num);
		date = calendar.getTime();
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
		String provicetime = dateFormater.format(date);
		return provicetime;
	}

}
