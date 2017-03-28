package me.jurik99.main.cascade_types;

import me.jurik99.dto.cascade_types.UserDetails;
import me.jurik99.dto.cascade_types.Vehicle;
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

		/**
		 *  What does "Cascade" mean?
		 *  Let's say that we have "User" and this "User" has "10 Vehicles"
		 *  We'll have to assign that 10 "Vehicles" objects to the "User"
		 *  Later if we'd like to e.g. "SAVE" this "User", we'll have to SAVE those 10 "Vehicle" objects as well
		 *  The same situation will be with "DELETE" users and so on...
		 */

		final UserDetails user = new UserDetails();
		user.setUserName("First User");

		final Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");

		final Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");

		user.getListOfVehicles().add(vehicle1);
		user.getListOfVehicles().add(vehicle2);

		final Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

//		session.save(user);

		// --- PERSIST instead of SAVE ---
		session.persist(user);

//		session.save(vehicle1);
//		session.save(vehicle2);

		session.getTransaction().commit();
		session.close();
	}
}
