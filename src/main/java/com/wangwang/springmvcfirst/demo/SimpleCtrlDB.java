package com.wangwang.springmvcfirst.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class SimpleCtrlDB {
  
	private Connection con=null;
	private PreparedStatement pps=null;
	private ResultSet rs=null;
	
	@Test
	public void insert(){
		try {
			con=JDBCUtils.getConnection();
			
			String sql="INSERT INTO DEPT(DEPTNO,DNAME,LOC) VALUES(?,?,?)";
			pps=con.prepareStatement(sql);
			//索引从1开始
			pps.setInt(1,50);
			pps.setString(2, "GRIS开发一部");
			pps.setString(3,"珠海");
			int rowCount=pps.executeUpdate();
			if(rowCount>0){
				System.out.println("新增成功!条数:"+rowCount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCUtils.destroy(con, pps, rs);
		}
	}
	
	@Test
	public void modify(){
		try {
			con=JDBCUtils.getConnection();
			
			String sql="UPDATE DEPT SET LOC=? WHERE DEPTNO=?";
			pps=con.prepareStatement(sql);
			//索引从1开始
			pps.setString(1,"北京");
			pps.setInt(2,50);
			int rowCount=pps.executeUpdate();
			if(rowCount>0){
				System.out.println("修改增成功!条数:"+rowCount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCUtils.destroy(con, pps, rs);
		}
	}
	@Test
	public void find(){
		try {
			con=JDBCUtils.getConnection();
			
			String sql="SELECT * FROM DEPT WHERE DEPTNO=?";
			pps=con.prepareStatement(sql);
			pps.setInt(1,50);
			rs=pps.executeQuery();
			int count = 1;
			while (rs.next()) {
				System.out.println("第" + count + "条数据");
				System.out.println("DEPTNO:" + rs.getString("DEPTNO"));
				System.out.println("DNAME:" + rs.getString("DNAME"));
				System.out.println("LOC:" + rs.getString("LOC"));
				System.out.println("======================");
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCUtils.destroy(con, pps, rs);
		}
	}
}

