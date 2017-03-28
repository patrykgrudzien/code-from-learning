package me.jurik99.main.one_to_one;

import me.jurik99.dto.one_to_one.UserDetails;
import me.jurik99.dto.one_to_one.Vehicle;
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

		final Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		user.setVehicle(vehicle);

		final Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.save(user);
		session.save(vehicle);

		session.getTransaction().commit();
		session.close();
	}
}
