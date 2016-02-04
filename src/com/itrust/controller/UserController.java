package com.itrust.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itrust.service.UserService;

@Controller
public class UserController {
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest resquest, HttpServletResponse response) {
		UserService userService = new UserService();
		String username = resquest.getParameter("username");
		
		ModelAndView model = new ModelAndView("main");
		model.addObject("user", username);
		return model;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest resquest, HttpServletResponse response) {		
		ModelAndView model = new ModelAndView("main");
		HttpSession session = resquest.getSession();
		session.invalidate();
		return model;
	}

}
