package com.wangwang.springmvcfirst.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTestConnection {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
		String user = "SCOTT";
		String password = "Orcl1234";
		// 1、加载驱动 这种方式不好，会导致驱动加载两次，并且耦合度太高
		// DriverManager.registerDriver(new OracleDriver());
		// 通过类加载驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2、获取与数据库的连接
		Connection con = DriverManager.getConnection(url, user, password);
		// 3、获取用于发送sql数据库statement对象

		Statement st = con.createStatement();
		String sql = "select * from dept";
		// 4、向数据库发送sql
		ResultSet rs = st.executeQuery(sql);
		int count = 1;
		while (rs.next()) {
			System.out.println("第" + count + "条数据");
			System.out.println("DEPTNO:" + rs.getString("DEPTNO"));
			System.out.println("DNAME:" + rs.getString("DNAME"));
			System.out.println("LOC:" + rs.getString("LOC"));
			System.out.println("======================");
			count++;
		}

		st.close();
		rs.close();
		con.close();
	}

}
