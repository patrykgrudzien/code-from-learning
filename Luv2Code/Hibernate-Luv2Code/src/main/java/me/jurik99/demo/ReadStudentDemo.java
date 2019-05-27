package me.jurik99.demo;

import me.jurik99.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;

public class ReadStudentDemo
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
			// --- create a student object ---
			System.out.println("Creating a new student object...");
			final Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

			// --- start a transaction ---
			session.beginTransaction();

			// --- save the student object ---
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// --- commit transaction ---
			session.getTransaction().commit();

			// --- MY NEW CODE ---

			// --- find out the student's id: primary key ---
			System.out.println("Saved student. Generated id: " + tempStudent.getId());

			// --- now get a new session and start transaction ---
			session = factory.getCurrentSession();
			session.beginTransaction();

			// --- retrieve student based on the id: primary key ---
			System.out.println("\nGetting student with id: " + tempStudent.getId());

			final Student myStudent = session.get(Student.class, tempStudent.getId());

			System.out.println("Get complete: " + myStudent);

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
