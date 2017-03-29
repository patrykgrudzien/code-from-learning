package me.jurik99.dao;

import me.jurik99.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{
	// --- need to inject the session factory ---
	private SessionFactory sessionFactory;

	@Autowired
	public CustomerDAOImpl(final SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Customer> getCustomers()
	{
		// --- get the current hibernate session ---
		final Session currentSession = sessionFactory.getCurrentSession();

		// --- create a query ---
		final Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName asc",
		                                                            Customer.class);

		// --- execute query and get result list ---
		final List<Customer> customerList = theQuery.getResultList();

		// --- return the result ---
		return customerList;
	}

	@Override
	public void saveCustomer(final Customer customer)
	{
		// --- get the current hibernate session ---
		final Session currentSession = sessionFactory.getCurrentSession();

		// --- save a customer in database ---
		currentSession.save(customer);
	}

	@Override
	public Customer getCustomer(final int id)
	{
		// --- get the current hibernate session ---
		final Session currentSession = sessionFactory.getCurrentSession();

		// --- now retrieve/read from database using primary key ---
		final Customer customer = currentSession.get(Customer.class, id);

		return customer;
	}

	@Override
	public void updateCustomer(final Customer customer)
	{
		// --- get the current hibernate session ---
		final Session currentSession = sessionFactory.getCurrentSession();

		// --- save(...): INSERT new record ---
		// --- update(...): UPDATE existing record ---
		// --- if(primaryKey/Id) empty then INSERT new customer, otherwise UPDATE existing customer ---
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public void deleteCustomer(final int id)
	{
		// --- get the current hibernate session ---
		final Session currentSession = sessionFactory.getCurrentSession();

		// --- delete object with primary key ---
		final Query query = currentSession.createQuery("delete from Customer where id=:customerId");

		query.setParameter("customerId", id);

		query.executeUpdate();
	}
}
