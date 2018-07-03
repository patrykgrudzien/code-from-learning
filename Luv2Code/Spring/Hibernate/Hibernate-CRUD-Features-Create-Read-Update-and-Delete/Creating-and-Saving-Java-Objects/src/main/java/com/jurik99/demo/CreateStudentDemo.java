package com.jurik99.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static com.jurik99.Constants.DatabaseNames.LUV2CODE_DATABASE;
import static com.jurik99.Constants.Schemas.CREATING_SAVING_JAVA_OBJECTS;

import com.jurik99.entity.Student;
import com.jurik99.init.PostgreSqlSchemasInitializer;

@SuppressWarnings("Duplicates")
public class CreateStudentDemo {

	public static void main(final String[] args) {

		PostgreSqlSchemasInitializer.initSchemaInDatabase(LUV2CODE_DATABASE, CREATING_SAVING_JAVA_OBJECTS);

		// --- create session factory ---
		final SessionFactory sessionFactory = new Configuration()
				                               .configure("hibernate.cfg.xml")
				                               .addAnnotatedClass(Student.class)
				                               .buildSessionFactory();
		// --- create session ---
		final Session session = sessionFactory.getCurrentSession();

		// --- create student object ---
		System.out.println("Creating new student object...");
		final Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");

		// --- start a transaction ---
		session.beginTransaction();

		// --- save the student object ---
		System.out.println("Saving the student...");
		session.save(tempStudent);

		// --- commit transaction ---
		session.getTransaction().commit();

		System.out.println("Done!");

		// --- close SessionFactory ---
		sessionFactory.close();
	}
}
