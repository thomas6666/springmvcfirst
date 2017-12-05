package com.wangwang.mybatisfirst;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.wangwang.springmvcfirst.domain.Dept;
public class TestDept {

	@Test
	public void testFindDeptByDeptNo() throws Exception {
		// 获得配置文件
		InputStream is = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");

		// 创建SqlSessionFactory
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);

		// 创建SqlSession
		SqlSession ss = sf.openSession();

		// 执行
		// statement=namespace.sql ID
		
		Dept dept = ss.selectOne("com.wangwang.mybatisfirst.findDeptByNo", 50);
		if (dept != null) {

			System.out.println("deptNO:" + dept.getDeptNo() + ";dName:" + dept.getdName() + ";LOC:" + dept.getLoc());
		}
		// 释放资源
		ss.close();
	}

	@Test
	public  void testFindName() throws Exception{
	  //1、根据SqlMapConfig创建SqlSessionFactory
	  InputStream cfgStream=Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
	  SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(cfgStream);
	  //2、根据sqlSessionFactory创建会话
	  SqlSession session=ssf.openSession();
	  String statement="com.wangwang.mybatisfirst.findDeptByName";
	  //3、根据会话查询
	  List<Dept> depts=session.selectList(statement,"G");
	  for (Dept dept : depts) {
		System.out.println(dept.toString());
	  }
	  //4、关闭会话
	  session.close();
	}
}
