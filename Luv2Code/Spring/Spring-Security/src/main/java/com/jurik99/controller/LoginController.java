package com.jurik99.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/showMyLoginPage")
	public String showLoginPage() {
		return "fancy-login";
	}

	@PostMapping(value = "/authenticateTheUser")
	public String authenticateTheUser() {
		return showHome();
	}

	// --- add request mapping for MANAGER role ---
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}

	// --- add request mapping for ADMIN role ---
	@GetMapping("/systems")
	public String showSystems() {
		return "systems";
	}

	// --- add request mapping for /access-denied ---
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
}
