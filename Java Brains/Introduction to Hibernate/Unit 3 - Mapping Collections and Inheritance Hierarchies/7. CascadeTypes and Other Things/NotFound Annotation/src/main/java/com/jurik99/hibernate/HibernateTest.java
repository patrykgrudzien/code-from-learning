package com.jurik99.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jurik99.dto.UserDetails;
import com.jurik99.dto.Vehicle;
import com.jurik99.init.PostgreSqlSchemasInitializer;
import com.jurik99.schemas.SchemaNames;

@SuppressWarnings("Duplicates")
public class HibernateTest
{
	public static void main(final String[] args)
	{
		PostgreSqlSchemasInitializer.initSchemaInDatabase(SchemaNames.Unit3.NOT_FOUND_ANNOTATION_SCHEMA);

		final UserDetails user1 = new UserDetails();
		user1.setUserName("First User");

		final Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");
		final Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");

		user1.getVehiclesList().add(vehicle1);
		user1.getVehiclesList().add(vehicle2);
		vehicle1.getUsersList().add(user1);
		vehicle2.getUsersList().add(user1);

		// --- STEP 1: Create SessionFactory ---
		final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		// --- STEP 2: Create session (getCurrentSession) ---
		final Session session = sessionFactory.getCurrentSession();

		// --- STEP 3: Begin transaction ---
		session.beginTransaction();

		/*
		 * We have to save EVERY ENTITY which is annotated by @Entity
		 */
		session.save(user1);
		session.save(vehicle1);
		session.save(vehicle2);

		// --- STEP 5: Get transaction, Commit ---
		session.getTransaction().commit();

		// --- STEP 6: Close session ---
		session.close();
	}
}
