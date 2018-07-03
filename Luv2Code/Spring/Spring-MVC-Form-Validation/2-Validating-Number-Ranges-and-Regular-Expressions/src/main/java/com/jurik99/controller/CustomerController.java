package com.jurik99.controller;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import com.jurik99.model.Customer;

@SuppressWarnings("Duplicates")
@Controller
@RequestMapping("/customer")
@Log4j
public class CustomerController {

	@InitBinder
	public void initBinder(final WebDataBinder webDataBinder) {

		final StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showForm")
	public String showForm(final Model model) {

		model.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") final Customer customer,
	                          final BindingResult bindingResult) {

		log.info("Last name: |" + customer.getLastName() + "|");

		// --- Printing informations provided by "BindingResult" object ---
		System.out.println("\n");
		System.out.println("Binding result: " + bindingResult);
		/*
		 * Field error in object 'customer' on field 'freePasses':
		 * rejected value [fadasdasd];
		 * codes [typeMismatch.customer.freePasses, typeMismatch.freePasses, typeMismatch.java.lang.Integer, typeMismatch];
		 *
		 * typeMismatch.customer.freePasses - SPECIFIC ERROR listed on the left hand side
		 * typeMismatch - GENERIC ERROR listed at the end of "CODES" list
		 */
		System.out.println("\n");

		if (bindingResult.hasErrors()) {
			log.error("Customer object is not valid. Please specify required input fields.");
			return "customer-form";
		}
		else {
			log.info("Processed successfully.");
			return "customer-confirmation";
		}
	}
}
