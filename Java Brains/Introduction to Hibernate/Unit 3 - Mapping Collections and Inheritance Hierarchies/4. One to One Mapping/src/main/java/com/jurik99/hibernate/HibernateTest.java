package com.jurik99.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jurik99.dto.UserDetails;
import com.jurik99.dto.Vehicle;

@SuppressWarnings("Duplicates")
public class HibernateTest
{
	public static void main(final String[] args)
	{
		final UserDetails user = new UserDetails();
		user.setUserName("First User");

		final Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		user.setVehicle(vehicle);

		// --- STEP 1: Create SessionFactory ---
		final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		// --- STEP 2: Create session (getCurrentSession) ---
		final Session session = sessionFactory.getCurrentSession();

		// --- STEP 3: Begin transaction ---
		session.beginTransaction();

		// --- STEP 4: Do something ---
		session.save(user);
		session.save(vehicle);

		// --- STEP 5: Get transaction, Commit ---
		session.getTransaction().commit();

		// --- STEP 6: Close session ---
		session.close();
	}
}
