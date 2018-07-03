package com.jurik99.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static com.jurik99.Constants.DatabaseNames.LUV2CODE_DATABASE;
import static com.jurik99.Constants.Schemas.PRIMARY_KEYS;

import com.jurik99.entity.Student;
import com.jurik99.init.PostgreSqlSchemasInitializer;

@SuppressWarnings("Duplicates")
public class PrimaryKeyDemo {

	public static void main(final String[] args) {

		PostgreSqlSchemasInitializer.initSchemaInDatabase(LUV2CODE_DATABASE, PRIMARY_KEYS);

		// --- create session factory ---
		final SessionFactory sessionFactory = new Configuration()
				                               .configure("hibernate.cfg.xml")
				                               .addAnnotatedClass(Student.class)
				                               .buildSessionFactory();
		// --- create session ---
		final Session session = sessionFactory.getCurrentSession();

		// --- create 3 student objects ---
		final Student tempStudent1 = new Student("Paul", "Wall", "paul@luv2code.com");
		final Student tempStudent2 = new Student("Joe", "Doe", "joe.doe@luv2code.com");
		final Student tempStudent3 = new Student("Patrick", "Newman", "patrick.newman@luv2code.com");

		// --- start a transaction ---
		session.beginTransaction();

		// --- save the student object ---
		System.out.println("Saving the student...");
		session.save(tempStudent1);
		session.save(tempStudent2);
		session.save(tempStudent3);

		// --- commit transaction ---
		session.getTransaction().commit();

		System.out.println("Done!");

		// --- close SessionFactory ---
		sessionFactory.close();
	}
}
