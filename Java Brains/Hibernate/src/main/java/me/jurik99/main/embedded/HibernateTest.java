package me.jurik99.main.embedded;

import me.jurik99.dto.embedded.Address;
import me.jurik99.dto.embedded.UserDetails;
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

		final UserDetails user = new UserDetails();
		user.setUserName("First User");

		final Address address1 = new Address();
		address1.setStreet("First Home Street");
		address1.setCity("First Home City");
		address1.setState("First Home State");
		address1.setPincode("100001");

		final Address address2 = new Address();
		address2.setStreet("Second Office Street");
		address2.setCity("Second Office City");
		address2.setState("Second Office State");
		address2.setPincode("200002");

		user.setHomeAddress(address1);
		user.setOfficeAddress(address2);

		final Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();

		currentSession.save(user);

		currentSession.getTransaction().commit();
		currentSession.close();
	}
}
