package me.jurik99.demo;

import me.jurik99.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo
{
	@SuppressWarnings("Duplicates")
	public static void main(final String[] args)
	{
		// --- create session factory ---
		final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(
				Student.class).buildSessionFactory();

		// --- create a session ---
		final Session session = factory.getCurrentSession();

		try
		{
			// --- start a transaction ---
			session.beginTransaction();

			// --- query students ---
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			displayStudents(theStudents);

			// --- query students: lastName='Doe' ---
			theStudents = session.createQuery("from Student s where s.lastName='Kurek'").getResultList();
			System.out.println("\nStudents who have last name of Kurek");
			displayStudents(theStudents);

			// --- query students: lastName='Kurek' OR firstName='Daffy' ---
			theStudents = session.createQuery("from Student s where s.lastName='Kurek' OR s.firstName='Daffy'")
			                     .getResultList();
			System.out.println("\nStudents who have last name of Kurek OR first name Daffy");
			displayStudents(theStudents);

			// --- query students where email like '%luv2code.com' ---
			theStudents = session.createQuery("from Student s where s.email like '%luv2code.com'")
			                     .getResultList();
			System.out.println("\nStudents who have email ends with luv2code.com");
			displayStudents(theStudents);

			// --- commit transaction ---
			session.getTransaction().commit();

			System.out.println("Done!");
		}
		finally
		{
			factory.close();
		}
	}

	private static void displayStudents(final List<Student> theStudents)
	{
		// --- display students ---
		for (final Student tempStudent : theStudents)
		{
			System.out.println(tempStudent);
		}
	}
}
