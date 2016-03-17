package com.itrust.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UrlController {
	
	@RequestMapping("/mainUrl")
	public ModelAndView mainUrl(HttpServletRequest resquest,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("main");
		return model;
	}

	@RequestMapping("/findTeacherUrl")
	public ModelAndView findTeacherUrl(HttpServletRequest resquest,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("findTeacher");
		return model;
	}
	
	@RequestMapping("/findStudentUrl")
	public ModelAndView findStudentUrl(HttpServletRequest resquest,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("findStudent");
		return model;
	}
	
	@RequestMapping("/aboutUrl")
	public ModelAndView aboutUrl(HttpServletRequest resquest,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("about");
		return model;
	}
	
	@RequestMapping("/loginUrl")
	public ModelAndView loginUrl(HttpServletRequest resquest,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	@RequestMapping("/registerUrl")
	public ModelAndView registerUrl(HttpServletRequest resquest,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("register");
		return model;
	}
}
