package com.itrust.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.itrust.bean.User;
import com.itrust.mapper.UserMapper;
import com.itrust.util.MybatisUtil;

public class MybatisTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findById(1);
		System.out.println(user.getUsername());
		sqlSession.close();
	}

}
