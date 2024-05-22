

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.wangwang.springmvcfirst.domain.Tb_User;

public class TestUser {

	/**
	 * mapper的包名,和mapper.xml的nampespace相同
	 */
	private static String mapperNamespace="com.wangwang.mybatisfirst.";
	private final static Logger LOG = Logger.getLogger(TestUser.class);

	/**
	 * 获得会话 sqlSession 对象
	 * @return
	 * @throws IOException
	 */
	private static SqlSession getSqlSession() throws IOException {
		// 根据配置文件获取到SqlSessionFactory
		InputStream cfgStream = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(cfgStream);
		// 根据sqlSessionFactory创建Session
		return ssf.openSession();
	}

	@Test
	public void testAddUser() throws Exception {
		
		// 初始化一个用户
		Tb_User user = new Tb_User();

		user.setUserName("wangwu");
		user.setPassword("123456");
		user.setEmail("wangwu@126.com");
		user.setDescription("测试用户");
        SqlSession session=getSqlSession();
		Integer count = session.insert(mapperNamespace+"addUser", user);
		// 显式提交数据 事务
		session.commit();
		LOG.info("添加用户成功,影响条数:" + count);
		// session.commit();
		// 关闭会话
		session.close();
	}

	@Test
	public void testUpdateUser() throws IOException
	{	
		 SqlSession session=getSqlSession();
		 
		 Tb_User user=session.selectOne(mapperNamespace+"selectUserById", 3);
		 
		 if(user!=null)
		 {
		   user.setDescription("正在审核的用户!!");
		   Integer count=session.update(mapperNamespace+"updateUser", user);
		   
		   //提交事务
		   session.commit();
		   LOG.info("更新用户信息成功！影响:"+count+"条!");
		 }
		 else
		 {
			 LOG.warn("没有此用户的信息");
		 }
		 //关闭会话
		 session.close();
	}
	
	@Test
	public void testSelectAllUser() throws IOException
	{
		SqlSession session=getSqlSession();
		List<Tb_User> users=session.selectList(mapperNamespace+"selectAllUser");
		 for (Tb_User tb_User : users) {
			LOG.info(tb_User.toString()+"\n");
		}
	}
	
	@Test
	public void testDeleteUser() throws IOException
	{
		SqlSession session=getSqlSession();
		session.delete(mapperNamespace+"deleteUser", 3);
		session.commit();
		session.close();
		LOG.info("删除成功!!");
	}
	
}
