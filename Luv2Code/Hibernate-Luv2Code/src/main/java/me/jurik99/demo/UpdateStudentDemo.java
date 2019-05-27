package me.jurik99.demo;

import me.jurik99.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo
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
		Session session = factory.getCurrentSession();

		try
		{
			final long studentId = 1L;

			// --- now get a new session and start transaction ---
			session = factory.getCurrentSession();
			session.beginTransaction();

			// --- retrieve student based on the id: primary key ---
			System.out.println("\nGetting student with id: " + studentId);

			final Student myStudent = session.get(Student.class, studentId);

			System.out.println("Updating student...");

			myStudent.setFirstName("Scooby");

			// --- commit transaction ---
			session.getTransaction().commit();

			// --- NEW CODE ---
			session = factory.getCurrentSession();
			session.beginTransaction();

			// --- update email for all students ---
			System.out.println("Update email for all students");

			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

			// --- commit the transaction ---
			session.getTransaction().commit();

			System.out.println("Done!");
		}
		finally
		{
			factory.close();
		}
	}
}
