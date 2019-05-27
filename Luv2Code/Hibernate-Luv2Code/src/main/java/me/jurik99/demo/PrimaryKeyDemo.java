package me.jurik99.demo;

import me.jurik99.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo
{
	public static void main(final String[] args)
	{
		// --- create session factory ---
		final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
		                                                  .addAnnotatedClass(Student.class)
		                                                  .buildSessionFactory();

		// --- create a session ---
		final Session session = factory.getCurrentSession();

		try
		{
			// --- create 3 student objects ---
			System.out.println("Creating 3 student objects...");
			final Student tempStudent1 = new Student("Paul", "Wal", "paul@luv2code.com");
			final Student tempStudent2 = new Student("Tomek", "Nowak", "tomek@luv2code.com");
			final Student tempStudent3 = new Student("Jerzy", "Kurek", "jerzy@luv2code.com");

			// --- start a transaction ---
			session.beginTransaction();

			// --- save the student object ---
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// --- commit transaction ---
			session.getTransaction().commit();

			System.out.println("Done!");
		}
		finally
		{
			factory.close();
		}

	}
}
