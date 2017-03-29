package me.jurik99.controller;

import me.jurik99.entity.Customer;
import me.jurik99.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
	// --- need to inject the customer DAO ---
	private final CustomerService customerService;

	@Autowired
	public CustomerController(final CustomerService customerService)
	{
		this.customerService = customerService;
	}

	@GetMapping("/list")
	public String listCustomers(final Model model)
	{
		// --- get customers from the DAO ---
		final List<Customer> customers = customerService.getCustomers();

		// --- add the customers to the model ---
		model.addAttribute("customers", customers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(final Model model)
	{
		// --- create model attribute to bind form data ---
		final Customer theCustomer = new Customer();

		model.addAttribute("customer", theCustomer);

		return "customer-save-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") final Customer theCustomer)
	{
		// --- save the customer using our service ---
		customerService.saveCustomer(theCustomer);

		return "redirect:/customer/list";
	}

	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("customer") final Customer theCustomer)
	{
		// --- update the customer using our service ---
		customerService.update(theCustomer);

		return "redirect:/customer/list";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") final int id)
	{
		// --- delete the customer ---
		customerService.deleteCustomer(id);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") final int id, final Model model)
	{
		// --- get the customer from the database ---
		final Customer customer = customerService.getCustomer(id);

		// --- set customer as a model attribute to pre-populate the form ---
		model.addAttribute("customer", customer);

		// --- send over to our form ---
		return "customer-update-form";
	}
}
