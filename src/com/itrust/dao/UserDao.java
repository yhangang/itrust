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
	public int save(User user){
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		try{
			result=userMapper.insertUser(user);
		}catch(Exception e){
			System.out.println("插入用户记录失败！");
		}
		sqlSession.commit();
		sqlSession.close();
		return result;
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
