package com.candy.utils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * 
 * @author Every
 * 数据库测打开关闭以及操作语句
 *
 */
public class JDBCTools
{
	//驱动、连接、数据库的用户名、密码
	private static String driver;
	private static String url;
	private static String name;
	private static String password;
	public static Connection conn ;


	static
	{
		Properties properties = new Properties();      //建立属性对象
		InputStream inputStream;
		try
		{
			inputStream = Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("config_ubuntu.propreties");
			
			properties.load(inputStream);                           //加载到属性中
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		driver = properties.getProperty("driver");            //这里的几个字段要用引号，这是配置文件中的字段
		url = properties.getProperty("url");
		name = properties.getProperty("name");
		password = properties.getProperty("password");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, name, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/*
	 * 加载数据库驱动，获取数据库连接
	 */
	public static Connection openDB()
	{
		try
		{
			if (conn == null | conn.isClosed()){
				Class.forName(driver);
				conn = DriverManager.getConnection(url, name, password);
			}
			return conn;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
    /*
     * 关闭对应连接的数据库
     */
	public static void closeDB(Connection connection)
	{
		if (connection != null)
		{
			try
			{
				connection.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> List<T> modelQuery(Class<T> cl) {

        Connection conn = JDBCTools.openDB();
        List list = new ArrayList();
        try
        {
            PreparedStatement ptStatement = null;
            ResultSet resultSet = null;
            String sql = "";
            sql = "select * from " + cl.getSimpleName().toLowerCase();
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
            return list;
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
