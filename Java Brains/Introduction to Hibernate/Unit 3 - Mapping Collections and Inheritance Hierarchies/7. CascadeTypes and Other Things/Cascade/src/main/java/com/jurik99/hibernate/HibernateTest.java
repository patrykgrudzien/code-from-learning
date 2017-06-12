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
		PostgreSqlSchemasInitializer.initSchemaInDatabase(SchemaNames.Unit3.CASCADE_SCHEMA);

		final UserDetails user1 = new UserDetails();
		user1.setUserName("First User");

		final Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");
		final Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");

		user1.getVehiclesList().add(vehicle1);
		user1.getVehiclesList().add(vehicle2);

		// --- STEP 1: Create SessionFactory ---
		final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		// --- STEP 2: Create session (getCurrentSession) ---
		final Session session = sessionFactory.getCurrentSession();

		// --- STEP 3: Begin transaction ---
		session.beginTransaction();

		/*
		 * If we remove those lines below, Hibernate will throw an EXCEPTION:
		 *
		 * org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient
		 * instance beforeQuery flushing: com.jurik99.dto.Vehicle
		 *
		 * because we assigned 2 vehicles above to user object but we are NOT saving them !!!
		 * session.save(vehicle1);
		 * session.save(vehicle2);
		 *
		 * Hibernate does NOT save vehicle objects automatically because they are ALSO ENTITY objects and we could
		 * want to save them differently than by using some default behavior.
		 *
		 * In case of VALUE TYPE for Vehicle, hibernate would save everything.
		 *
		 * USE "session.persist(...)" instead of "session.save(...)" to save all corresponding entities associated
		 * with USER object !!! IMPORTANT !!!
		 */
		session.persist(user1);

		// --- STEP 5: Get transaction, Commit ---
		session.getTransaction().commit();

		// --- STEP 6: Close session ---
		session.close();
	}
}
