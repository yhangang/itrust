package com.itrust.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itrust.bean.User;
import com.itrust.service.UserService;
import com.itrust.util.JsonUtil;

@Controller
public class UserController {
	UserService userService = new UserService();
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest resquest,
			HttpServletResponse response) {
		HttpSession session = resquest.getSession();
		String username = resquest.getParameter("username");
		String password = resquest.getParameter("password");
		User loginUser = new User();
		loginUser.setUsername(username);
		loginUser.setPwd(password);
		User user = userService.login(loginUser);

		ModelAndView model = new ModelAndView("main");
		if (user != null) {
			session.setAttribute("user", user.getUsername());
		}else{
			model.addObject("logerror", "logerror");
		}
		return model;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest resquest,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("main");
		HttpSession session = resquest.getSession();
		session.invalidate();
		return model;
	}
	
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest resquest,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("main");
		String username = resquest.getParameter("username");
		String password = resquest.getParameter("password");
		String realname = resquest.getParameter("realname");
		User user = new User();
		user.setUsername(username);
		user.setPwd(password);
		user.setRealname(realname);
		userService.register(user);
		model.addObject("register", "register");
		return model;
	}

}
