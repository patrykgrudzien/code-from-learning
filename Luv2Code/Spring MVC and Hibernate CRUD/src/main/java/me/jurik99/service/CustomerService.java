package me.jurik99.service;

import me.jurik99.entity.Customer;

import java.util.List;

public interface CustomerService
{
	Customer getCustomer(final int id);

	List<Customer> getCustomers();

	void saveCustomer(final Customer customer);

	void update(final Customer customer);

	void deleteCustomer(final int id);
}
