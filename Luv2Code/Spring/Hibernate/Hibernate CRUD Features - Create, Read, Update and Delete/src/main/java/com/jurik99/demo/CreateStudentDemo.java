package com.jurik99.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jurik99.entity.Student;

public class CreateStudentDemo {

	public static void main(final String[] args) {

		// --- create session factory ---
		final SessionFactory sessionFactory = new Configuration()
				                               .configure("hibernate.cfg.xml")
				                               .addAnnotatedClass(Student.class)
				                               .buildSessionFactory();
		// --- create session ---
		final Session session = sessionFactory.getCurrentSession();

		System.out.println("Creating new student object...");
		final Student tempStudent = new Student(1, "Paul", "Wall", "paul@luv2code.com");

		session.beginTransaction();

		System.out.println("Saving the student...");

	}
}
