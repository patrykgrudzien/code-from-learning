package me.jurik99.main.not_found_hibernate_collections;

import me.jurik99.dto.not_found_hibernate_collections.UserDetails;
import me.jurik99.dto.not_found_hibernate_collections.Vehicle;
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

		final Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");

		final Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");

		user.getListOfVehicles().add(vehicle1);
		user.getListOfVehicles().add(vehicle2);
		vehicle1.setUser(user);
		vehicle2.setUser(user);

		final Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.save(user);
		session.save(vehicle1);
		session.save(vehicle2);

		session.getTransaction().commit();
		session.close();
	}
}