package com.wangwang.springmvcfirst.demo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * jdbc工具类.
 * 
 * @author Administrator
 *
 */
public class JDBCUtils {
	private static String dbUserName;
	private static String dbPassword;
	private static String dbUrl;
	/**
	 * 静态代码块，类加载时只执行一次
	 */
	static {
		// 1、加载配置文件
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("base/jdbc.properties");
		Properties pts = new Properties();
		try {
			pts.load(is);
			// 2、加载数据库驱动
			Class.forName(pts.getProperty("jdbc.driverClassName"));
		    //加载配置信息到变量
			dbUserName=pts.getProperty("jdbc.username");
			dbPassword=pts.getProperty("jdbc.password");
			dbUrl=pts.getProperty("jdbc.url");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 获取数据库的链接
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
	}
	/**
	 * 释放资源
	 * @param con 数据库链接.
	 * @param pps 预处理块.
	 * @param rs 结果集对象.
	 */
	public  static void destroy(Connection con,PreparedStatement pps,ResultSet rs){
		
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pps!=null){
			try {
				pps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
