package com.jurik99.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static com.jurik99.Constants.DatabaseNames.LUV2CODE_DATABASE;
import static com.jurik99.Constants.Schemas.READING_OBJECTS;

import com.jurik99.entity.Student;
import com.jurik99.init.PostgreSqlSchemasInitializer;

@SuppressWarnings("Duplicates")
public class ReadStudentDemo {

	public static void main(final String[] args) {

		PostgreSqlSchemasInitializer.initSchemaInDatabase(LUV2CODE_DATABASE, READING_OBJECTS);

		// --- create session factory ---
		final SessionFactory sessionFactory = new Configuration()
				                               .configure("hibernate.cfg.xml")
				                               .addAnnotatedClass(Student.class)
				                               .buildSessionFactory();
		// --- create session ---
		Session session = sessionFactory.getCurrentSession();

		// --- create 3 student objects ---
		final Student newStudent = new Student("Tom", "Jerry", "tom.jerry@luv2code.com");

		// --- start a transaction ---
		session.beginTransaction();
		session.save(newStudent);
		session.getTransaction().commit();

		// --- RETRIEVING ---
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		System.out.println("Student's ID that we're getting from DB: " + newStudent.getId());
		final Student retrievedStudent = session.get(Student.class, newStudent.getId());
		System.out.println("Get complete: " + retrievedStudent);

		// --- commit transaction ---
		session.getTransaction().commit();

		// --- close SessionFactory ---
		sessionFactory.close();
	}
}
