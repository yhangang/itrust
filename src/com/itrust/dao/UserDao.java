package com.itrust.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itrust.bean.User;
import com.itrust.mapper.UserMapper;
import com.itrust.util.MybatisUtil;

public class UserDao {
	/**
	 * 新建用户
	 * @param user
	 */
	public void save(User user){
		SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
	}

}
