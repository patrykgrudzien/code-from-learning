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

		final Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");

		final Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");

		user.getVehicles().add(vehicle1);
		user.getVehicles().add(vehicle2);

		// --- STEP 1: Create SessionFactory ---
		final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		// --- STEP 2: Create session (getCurrentSession) ---
		final Session session = sessionFactory.getCurrentSession();

		// --- STEP 3: Begin transaction ---
		session.beginTransaction();

		/*
		 * We have to save EVERY ENTITY which is annotated by @Entity
		 */
		session.save(user);
		session.save(vehicle1);
		session.save(vehicle2);

		// --- STEP 5: Get transaction, Commit ---
		session.getTransaction().commit();

		// --- STEP 6: Close session ---
		session.close();
	}
}
