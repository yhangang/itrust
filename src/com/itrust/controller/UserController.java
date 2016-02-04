package com.itrust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@RequestMapping("/demo")
	public ModelAndView demo() {
		String str = "Hello,Spring MVC.";
		ModelAndView model = new ModelAndView("result");
		model.addObject("str", str);
		return model;
	}

}
