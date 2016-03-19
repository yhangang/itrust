package com.itrust.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itrust.bean.User;
import com.itrust.service.UserService;
import com.itrust.util.AjaxUtil;
import com.itrust.util.Constant;
import com.itrust.util.MD5Util;
import com.itrust.util.SimpleMessage;
/**
 * 用户管理controller
 * @author yanghang
 *
 */
@Controller
public class UserController {
	UserService userService = new UserService();
	/**
	 * 登录功能
	 * @param resquest
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest resquest,
			HttpServletResponse response) {
		HttpSession session = resquest.getSession();
		String username = resquest.getParameter("username");
		String password = resquest.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		User loginUser = new User();
		loginUser.setUsername(username);
		//密码使用MD5加密
		loginUser.setPwd(MD5Util.MD5(password));
		User user = userService.login(loginUser);

		if (user != null) {
			session.setAttribute("user", user);
			AjaxUtil.transferJson(response, new SimpleMessage(Constant.SUCCESS,
					user).toString());
		} else {
			AjaxUtil.transferJson(response, new SimpleMessage(Constant.FAIL,
					null).toString());
		}
		return null;
	}

	/**
	 * 退出登录
	 * @param resquest
	 * @param response
	 * @return
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest resquest,
			HttpServletResponse response) {
		HttpSession session = resquest.getSession();
		session.invalidate();
		AjaxUtil.transferJson(response, new SimpleMessage(Constant.SUCCESS,
				null).toString());
		return null;
	}

	/**
	 * 获取当前登录的用户
	 * @param resquest
	 * @param response
	 * @return
	 */
	@RequestMapping("/getLoginUser")
	public ModelAndView getLoginUser(HttpServletRequest resquest,
			HttpServletResponse response) {
		HttpSession session = resquest.getSession();
		if (session.getAttribute("user") != null) {
			AjaxUtil.transferJson(response, new SimpleMessage(Constant.SUCCESS,
					session.getAttribute("user")).toString());
		} else {
			AjaxUtil.transferJson(response, new SimpleMessage(Constant.FAIL,
					null).toString());
		}
		return null;
	}

	/**
	 * 注册功能
	 * @param resquest
	 * @param response
	 * @return
	 */
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest resquest,
			HttpServletResponse response) {
		String username = resquest.getParameter("username");
		String password = resquest.getParameter("password");
		String realname = resquest.getParameter("realname");
		User user = new User();
		user.setUsername(username);
		user.setPwd(MD5Util.MD5(password));
		user.setRealname(realname);
		int result = userService.register(user);
		if(result>0){
			AjaxUtil.transferJson(response, new SimpleMessage(Constant.SUCCESS,
					null).toString());
		}else{
			AjaxUtil.transferJson(response, new SimpleMessage(Constant.FAIL,
					null).toString());
		}
		return null;
	}
	
	/**
	 * 判断用户名是否已存在
	 * @param resquest
	 * @param response
	 * @return
	 */
	@RequestMapping("/isVacantUsername")
	public ModelAndView isVacantUsername(HttpServletRequest resquest,
			HttpServletResponse response) {
		String username = resquest.getParameter("username");
		System.out.println(username);
		User regUser = new User();
		regUser.setUsername(username);
		User user = userService.findUserByUsername(regUser);
		//拼接bootstrapvalidator验证字段{"valid":true}
		if (user == null) {
			AjaxUtil.transferJson(response, "{\"valid\":true}");
		} else {
			AjaxUtil.transferJson(response, "{\"valid\":false}");
		}
		return null;
	}

}
