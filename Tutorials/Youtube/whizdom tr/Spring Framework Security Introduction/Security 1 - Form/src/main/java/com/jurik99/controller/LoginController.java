package com.jurik99.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class LoginController
{
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model, final Principal principal)
	{
		System.out.println("********** LoginController Called **********");

		final String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security Custom Form example");
		return "hello";
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String home(final ModelMap model)
	{
		return "home";
	}
}
