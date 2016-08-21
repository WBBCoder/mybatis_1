package me.gacl.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import me.gacl.domain.User;
import me.gacl.util.MyBatisUtil;

public class TestCRUDXmlMapper {
	
	@Test
	public void testAdd(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		String statement = "me.gacl.mapping.userMapper.addUser";
		User user = new User();
		user.setName("牛崽子");
		user.setAge(19);
		int retResult = sqlSession.insert(statement, user);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(retResult);
	}
	
	@Test
	public void testDelete(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		String statement = "me.gacl.mapping.userMapper.deleteUser";
		int retResult = sqlSession.delete(statement, 2);
//		sqlSession.commit();
		sqlSession.close();
		System.out.println(retResult);
	}
	
	@Test
	public void testUpdate(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession(true);
		String statement = "me.gacl.mapping.userMapper.updateUser";
		User user = new User();
		user.setId(4);
		user.setName("猪崽子");
		user.setAge(25);
		int retResult = sqlSession.update(statement, user);
		sqlSession.close();
		System.out.println(retResult);
	}
	
	@Test
	public void testGet(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession(true);
		String statement = "me.gacl.mapping.userMapper.getUser";
		User user = sqlSession.selectOne(statement, 2);
		System.out.println(user.toString());
	}
	
	@Test
	public void testGetAll(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession(true);
		String statement = "me.gacl.mapping.userMapper.getAllUsers";
		List<User> users = (List) sqlSession.selectList(statement);
		sqlSession.close();
		System.out.println(users);
	}
	
}
