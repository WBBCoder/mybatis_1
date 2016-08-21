package me.gacl.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	public static SqlSessionFactory getSqlSessionFactory(){
		String resource="conf.xml";
		InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory =new  SqlSessionFactoryBuilder().build(is);
		return sessionFactory;
	}
	
	public static SqlSession getSession(){
		return getSqlSessionFactory().openSession();
	}
	
	public static SqlSession getSession(boolean isAutoCommit){
		return getSqlSessionFactory().openSession(isAutoCommit);
	}
	
}
