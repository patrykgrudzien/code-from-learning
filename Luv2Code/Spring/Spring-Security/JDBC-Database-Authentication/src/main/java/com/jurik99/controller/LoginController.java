package com.jurik99.controller;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j
@Controller
public class LoginController {

	@GetMapping("/")
	public String showHome() {
		log.info(">>>> showHome()");

		return "home";
	}

	@GetMapping("/showMyLoginPage")
	public String showLoginPage() {
		log.info(">>>> showLoginPage()");

		return "fancy-login";
	}

	@PostMapping(value = "/authenticateTheUser")
	public String authenticateTheUser() {
		log.info(">>>> authenticateTheUser()");

		return showHome();
	}

	// --- add request mapping for MANAGER role ---
	@GetMapping("/leaders")
	public String showLeaders() {
		log.info(">>>> showLeaders()");

		return "leaders";
	}

	// --- add request mapping for ADMIN role ---
	@GetMapping("/systems")
	public String showSystems() {
		log.info(">>>> showSystems()");

		return "systems";
	}

	// --- add request mapping for /access-denied ---
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		log.info(">>>> showAccessDenied()");

		return "access-denied";
	}
}
