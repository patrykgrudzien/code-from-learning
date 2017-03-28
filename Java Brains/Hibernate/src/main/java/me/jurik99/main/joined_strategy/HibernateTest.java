package me.jurik99.main.joined_strategy;

import me.jurik99.dto.joined_strategy.FourWheeler;
import me.jurik99.dto.joined_strategy.TwoWheeler;
import me.jurik99.dto.joined_strategy.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest
{
	@SuppressWarnings("Duplicates")
	public static void main(final String[] args)
	{
		final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
		                                                         .addAnnotatedClass(Vehicle.class)
		                                                         .buildSessionFactory();

		final Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		final TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");

		final FourWheeler car = new FourWheeler();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porsche Streering Wheel");

		final Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.save(vehicle);
		session.save(bike);
		session.save(car);

		session.getTransaction().commit();
		session.close();
	}
}
