package com.jurik99;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

@Controller
public class SpringMVCController {

	@RequestMapping(value = "/helloWorld.web", method = RequestMethod.GET)
	public String printWelcome(final ModelMap modelMap, final HttpServletRequest request, final HttpServletResponse response) {

		modelMap.addAttribute("message", "Spring MVC jQuery Autocomplete");
		return "helloWorld";
	}

	@RequestMapping(value = "/getMatchedNames.web", method = RequestMethod.GET)
	public @ResponseBody List<String> getMatchedNames(@RequestParam("term") final String name) {

		return DataCache.getName(name);
	}
}
