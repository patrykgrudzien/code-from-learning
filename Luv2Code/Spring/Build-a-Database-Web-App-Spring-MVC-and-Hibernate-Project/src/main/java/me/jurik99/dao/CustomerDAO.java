package me.jurik99.dao;

import me.jurik99.entity.Customer;

import java.util.List;

public interface CustomerDAO
{
	public List<Customer> getCustomers();

	void saveCustomer(final Customer customer);

	Customer getCustomer(final int id);

	void updateCustomer(final Customer customer);

	void deleteCustomer(final int id);
}
