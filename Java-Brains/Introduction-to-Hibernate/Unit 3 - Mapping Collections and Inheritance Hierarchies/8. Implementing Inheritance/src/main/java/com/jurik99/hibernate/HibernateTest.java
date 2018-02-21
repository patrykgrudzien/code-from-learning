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
		/*
		 * Why do we need inheritance mapping?
		 *
		 * First approach to save sub entities (these one that extends Vehicle parent entity: "TwoWheeler" &
		 * "FourWheeler") is to save them separated as usual cause they are marked as @Entity.
		 *
		 * (LOOK AT PHOTO IN SCREENSHOOTS FOLDER)
		 * One of the coolest feature in Java is Polimorphism.
		 * Assume that we have "User" object and that user has reference to a "Vehicle" class. When we want to
		 * dynamically assign either "TwoWheeler" or "FourWheeler" it's not a problem cause compiler will choose
		 * right class at runtime -> THAT'S THE FIRST REASON.
		 *
		 * Without inheritance there is a problem while saving entities to the database cause what is the FOREIGN KEY
		 * to VEHICLE in USER table? It can be either "TwoWheeler" or "FourWheeler".
		 *
		 * SECOND REASON - e.g. later on we change Vehicle class (we add some additional field). What will happen
		 * thanks to Java inheritance? -> All sub-class will automatically get that NEWLY CREATED FIELD.
		 */
		// TODO: update with proper database name
		PostgreSqlSchemasInitializer.initSchemaInDatabase("", SchemaNames.Unit3.IMPLEMENTING_INHERITANCE_SCHEMA);

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

		/*
		 * Hibernate creates ONLY ONE table (even though we have 3 classes marked by @Entity) with columns:
		 * DTYPE, vahicleId, vehicleName, steeringHandle, steeringWheel
		 *
		 * Each row has all properties but in case of e.g. VEHICLE -> steeringHandle, steeringWheel columns are EMPTY.
		 *
		 * Hibernate by default implemented inheritance STRATEGY called "SINGLE TABLE" !!!
		 */
		session.save(vehicle);
		session.save(bike);
		session.save(car);

		// --- STEP 5: Get transaction, Commit ---
		session.getTransaction().commit();

		// --- STEP 6: Close session ---
		session.close();
	}
}
