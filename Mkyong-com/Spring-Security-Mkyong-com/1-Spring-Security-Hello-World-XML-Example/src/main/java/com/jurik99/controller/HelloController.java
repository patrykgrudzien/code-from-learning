package com.jurik99.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController
{
	@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	public ModelAndView welcomePage()
	{
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Spring Security Hello World");
		modelAndView.addObject("message", "This is welcome page!");
		modelAndView.setViewName("hello");
		return modelAndView;
	}

	@RequestMapping(value = "/admin*", method = RequestMethod.GET)
	public ModelAndView adminPage()
	{
		final ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
		return model;
	}
}
