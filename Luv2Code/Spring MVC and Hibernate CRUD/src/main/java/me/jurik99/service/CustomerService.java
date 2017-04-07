package me.jurik99.service;

import java.util.List;

import me.jurik99.entity.Customer;

public interface CustomerService
{
	Customer getCustomer(final int id);

	List<Customer> getCustomers();

	void saveCustomer(final Customer customer);

	void update(final Customer customer);

	void deleteCustomer(final int id);
}
