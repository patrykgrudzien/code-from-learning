package com.jurik99.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jurik99.dto.FourWheeler;
import com.jurik99.dto.TwoWheeler;
import com.jurik99.dto.Vehicle;
import com.jurik99.init.PostgreSqlSchemasInitializer;
import com.jurik99.schemas.SchemaNames;

@SuppressWarnings("Duplicates")
public class HibernateTest
{
	public static void main(final String[] args)
	{
		// TODO: update with proper database name
		PostgreSqlSchemasInitializer.initSchemaInDatabase("", SchemaNames.Unit3.TABLE_PER_CLASS_STRATEGY_SCHEMA);

		final Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		final TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");

		final FourWheeler car = new FourWheeler();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porsche Steering Wheel");

		// --- STEP 1: Create SessionFactory ---
		final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		// --- STEP 2: Create session (getCurrentSession) ---
		final Session session = sessionFactory.getCurrentSession();

		// --- STEP 3: Begin transaction ---
		session.beginTransaction();

		session.save(vehicle);
		session.save(bike);
		session.save(car);

		// --- STEP 5: Get transaction, Commit ---
		session.getTransaction().commit();

		// --- STEP 6: Close session ---
		session.close();
	}
}
