package me.jurik99.main.proxy_eager_lazy_fetch;

import me.jurik99.dto.proxy_eager_lazy_fetch.Address;
import me.jurik99.dto.proxy_eager_lazy_fetch.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest
{
	@SuppressWarnings("Duplicates")
	public static void main(final String[] args)
	{
		final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
		                                                         .addAnnotatedClass(UserDetails.class)
		                                                         .buildSessionFactory();

		UserDetails user = new UserDetails();
		user.setUserName("First User");

		final Address address1 = new Address();
		address1.setStreet("First Street");
		address1.setCity("First City");
		address1.setState("First State");
		address1.setPincode("100001");

		final Address address2 = new Address();
		address2.setStreet("Second Street");
		address2.setCity("Second City");
		address2.setState("Second State");
		address2.setPincode("200002");

		user.getListOfAddresses().add(address1);
		user.getListOfAddresses().add(address2);

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();

		// --- open new session ---
		session = null;

		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		user = session.get(UserDetails.class, 1);

		session.getTransaction().commit();
		session.close();

		System.out.println(user.getListOfAddresses().size());
	}
}
