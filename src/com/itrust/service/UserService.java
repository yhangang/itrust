package com.itrust.service;

import org.apache.log4j.Logger;

import com.itrust.bean.User;
import com.itrust.dao.UserDao;

public class UserService {
	Logger log = Logger.getLogger(UserService.class);
	UserDao dao = new UserDao();

	/**
	 * ע���û�
	 * 
	 * @param user
	 */
	public int register(User user) {
		return dao.save(user);
	}

	/**
	 * �û���¼
	 * 
	 * @param user
	 * @return
	 */
	public User login(User user) {
		User result = dao.find(user);
		// �û���������
		if (result == null) {
			log.info("�û���������");
			return null;
		}
		// ��¼�������
		if (!user.getPwd().equals(result.getPwd())) {
			log.info("��¼�������");
			return null;
		}// ��¼�ɹ�
		else {
			log.info("��¼�ɹ�");
			return result;
		}

	}
	
	/**
	 * ��username��ѯ�û�
	 * 
	 * @param user
	 * @return
	 */
	public User findUserByUsername(User user) {
		return dao.find(user);
	}


}
