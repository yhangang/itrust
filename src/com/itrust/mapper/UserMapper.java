package com.itrust.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itrust.bean.User;

public interface UserMapper {
	@Insert("insert into t_user(username,pwd,realname) values(#{username},#{pwd},#{realname})")
	public void insertUser(User user);

	@Update("update t_user set username=#{username},pwd=#{pwd},realname=#{realname} where id = #{id}")
	public void updateUser(User user);
	
	@Select("select * from t_user where id = #{id}")
	public User findById(int id);
	
	@Select("select * from t_user where username = #{username}")
	public User findByUsername(String username);
	
	@Delete("delete from t_user where id = #{id}")
	public void deleteUser(int id);
}
