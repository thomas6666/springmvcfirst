package com.wangwang.springmvcfirst.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wangwang.springmvcfirst.demo.JDBCUtils;
import com.wangwang.springmvcfirst.domain.Dept;

@Repository
public class DeptDao implements IDeptDao {

	private Connection con;
	private PreparedStatement pps;
	private ResultSet rs;
	
	@Override
	public List<Dept> findAll() {
		String sql="SELECT DEPTNO,DNAME,LOC FROM DEPT";
		List<Dept> list=null;
		try {
			con=JDBCUtils.getConnection();
			pps=con.prepareStatement(sql);
			rs=pps.executeQuery();
			list=transfer(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtils.destroy(con, pps, rs);
		}
		return list;
	}
	/**
	 * 将ResultSet结果集转换为实体的集合 。
	 * 
	 * @param rs
	 * @return
	 */
	public static List<Dept> transfer(ResultSet rs) {
		if (rs == null) {
			return new ArrayList<Dept>();
		}
		List<Dept> list = new ArrayList<Dept>();
		try {
			if (!rs.isClosed()) {
				while (rs.next()) {
					Dept dept = new Dept();
					dept.setDeptNo(rs.getString("deptno"));
					dept.setdName(rs.getString("dname"));
					dept.setLoc(rs.getString("loc"));
					list.add(dept);
				}
			}
			else
			{
				System.out.println("结果集已经关闭!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
