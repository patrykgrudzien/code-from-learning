package me.jurik99.demo;

import me.jurik99.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo
{
	@SuppressWarnings("Duplicates")
	public static void main(final String[] args)
	{
		// --- create session factory ---
		final SessionFactory factory = new Configuration()
				                               .configure("hibernate.cfg.xml")
				                               .addAnnotatedClass(Student.class)
				                               .buildSessionFactory();
		// --- create a session ---
		final Session session = factory.getCurrentSession();

		try
		{
			// --- create a student object ---
			System.out.println("Creating a new student object...");
			final Student tempStudent = new Student("Paul", "Wal", "paul@luv2code.com");

			// --- start a transaction ---
			session.beginTransaction();

			// --- save the student object ---
			System.out.println("Saving the student...");
			session.save(tempStudent);

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
