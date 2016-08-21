package me.gacl.domain;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapperI {

	@Insert("INSERT INTO users(name, age) VALUES(#{name}, #{age})")
	public int add(User user);
	
	@Delete("DELETE FROM users WHERE id=#{id}")
	public int deleteById(int id);
	
	@Update("UPDATE users SET name=#{name},age=#{age} WHERE id=#{id}")
	public int update(User user);
	
	@Select("SELECT * FROM users WHERE id=#{id}")
	public User getById(int id);
	
	@Select("SELECT * FROM users")
	public List<User> getAll();
	
}
