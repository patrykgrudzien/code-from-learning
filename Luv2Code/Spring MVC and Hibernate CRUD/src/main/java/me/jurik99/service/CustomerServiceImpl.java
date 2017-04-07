package me.jurik99.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import me.jurik99.dao.CustomerDAO;
import me.jurik99.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService
{
	private CustomerDAO customerDAO;

	@Autowired
	public CustomerServiceImpl(final CustomerDAO customerDAO)
	{
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public List<Customer> getCustomers()
	{
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(final Customer customer)
	{
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public void update(final Customer customer)
	{
		customerDAO.updateCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(final int id)
	{
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(final int id)
	{
		customerDAO.deleteCustomer(id);
	}
}
