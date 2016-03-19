package com.itrust.service;

import org.apache.log4j.Logger;

import com.itrust.bean.User;
import com.itrust.dao.UserDao;

public class UserService {
	Logger log = Logger.getLogger(UserService.class);
	UserDao dao = new UserDao();

	/**
	 * 注册用户
	 * 
	 * @param user
	 */
	public int register(User user) {
		return dao.save(user);
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public User login(User user) {
		User result = dao.find(user);
		// 用户名不存在
		if (result == null) {
			log.info("用户名不存在");
			return null;
		}
		// 登录密码错误
		if (!user.getPwd().equals(result.getPwd())) {
			log.info("登录密码错误");
			return null;
		}// 登录成功
		else {
			log.info("登录成功");
			return result;
		}

	}
	
	/**
	 * 按username查询用户
	 * 
	 * @param user
	 * @return
	 */
	public User findUserByUsername(User user) {
		return dao.find(user);
	}


}
