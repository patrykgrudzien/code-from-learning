package me.jurik99.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController
{
	// --- need a controller method to show the initial HTML form ---
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}

	// --- need a controller method to process the HTML form ---
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}

	// --- new controller method to read form data and add data to the model ---
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(final HttpServletRequest request, final Model model)
	{
		// --- read the request parameter from the HTML form ---
		String theName = request.getParameter("studentName");

		// --- convert the data to all caps ---
		theName = theName.toUpperCase();

		// --- create a message ---
		final String result = "Yo! " + theName;

		// --- add message to the model ---
		model.addAttribute("message", result);

		return "helloworld";
	}

	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, final Model model)
	{
		// --- convert the data to all caps ---
		theName = theName.toUpperCase();

		// --- create a message ---
		final String result = "Hey My Friend from v3! " + theName;

		// --- add message to the model ---
		model.addAttribute("message", result);

		return "helloworld";
	}
}
