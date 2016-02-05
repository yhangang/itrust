package com.itrust.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itrust.bean.User;
import com.itrust.mapper.UserMapper;
import com.itrust.util.MybatisUtil;

public class UserDao {
	SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
	/**
	 * 新建用户
	 * @param user
	 */
	public void save(User user){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	/**
	 * 登录验证
	 * @param user
	 */
	public User find(User user){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User result = userMapper.findByUsername(user.getUsername());
		sqlSession.close();
		return result;
	}

}
