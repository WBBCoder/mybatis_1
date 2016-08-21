package me.gacl.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import me.gacl.domain.User;
import me.gacl.util.MyBatisUtil;

public class TestOneLevelCache {

	@Test
	public void testCache1(){
		SqlSession session = MyBatisUtil.getSession(true);
		String statement = "me.gacl.mapping.userMapper.getUser";
		User user = session.selectOne(statement, 4);
		System.out.println(user);
		
		user = session.selectOne(statement, 4);
		System.out.println(user);
		session.close();
	}
	
}
