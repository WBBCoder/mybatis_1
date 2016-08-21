package me.gacl.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import me.gacl.domain.User;
import me.gacl.domain.UserMapperI;
import me.gacl.util.MyBatisUtil;

public class TestCRUDAnnotationMapper {

	
	@Test
	public void testAdd(){
		SqlSession sqlSession = MyBatisUtil.getSession(true);
		UserMapperI userMapperI = sqlSession.getMapper(UserMapperI.class);
		User user = new User();
		user.setName("希特勒");
		user.setAge(20);
		int add = userMapperI.add(user);
		sqlSession.close();
		System.out.println(add);
	}
	
	@Test
	public void testUpdate(){
		SqlSession sqlSession = MyBatisUtil.getSession(true);
		UserMapperI userMapperI = sqlSession.getMapper(UserMapperI.class);
		User user = new User();
		user.setId(5);
		user.setName("希拉里");
		user.setAge(20);
		int update = userMapperI.update(user);
		sqlSession.close();
		System.out.println(update);
	}
	
	@Test
	public void testDelete(){
		SqlSession sqlSession = MyBatisUtil.getSession(true);
		UserMapperI userMapperI = sqlSession.getMapper(UserMapperI.class);
		int delete = userMapperI.deleteById(2);
		sqlSession.close();
		System.out.println(delete);
	}
	
	@Test
	public void testGet(){
		SqlSession sqlSession = MyBatisUtil.getSession(true);
		UserMapperI userMapperI = sqlSession.getMapper(UserMapperI.class);
		User get = userMapperI.getById(4);
		sqlSession.close();
		System.out.println(get);
	}
	
	@Test
	public void testGetAll(){
		SqlSession sqlSession = MyBatisUtil.getSession(true);
		UserMapperI userMapperI = sqlSession.getMapper(UserMapperI.class);
		List<User> users = userMapperI.getAll();
		sqlSession.close();
		System.out.println(users);
	}
}
