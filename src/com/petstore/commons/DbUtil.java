package com.petstore.commons;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class DbUtil {
	private static DbUtil dbUtil;
	private static String userName,passWord,url;
	static {
		Properties properties=new Properties();
		try {
			properties.load(DbUtil.class.getClassLoader().getResourceAsStream("dbase.properties"));
		   Class.forName(properties.getProperty("driver"));
		   userName=properties.getProperty("username");
		   passWord=properties.getProperty("password");
		   url=properties.getProperty("url");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private DbUtil(){}
	
	public static DbUtil newInstance()
	{
		if(dbUtil==null)
		{ 
			dbUtil=new DbUtil();
		}
		return dbUtil;
	}
	
	public static Connection getConnection() throws SQLException
	{
		
		return DriverManager.getConnection(url, userName, passWord);
	}
	
	

}
