package com.jurik99.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

import com.jurik99.dto.UserDetails;

@SuppressWarnings("Duplicates")
public class HibernateTest
{
	public static void main(final String[] args)
	{
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");
		user.setAddress("First User address");
		user.setJoinedDate(new Date());
		user.setDescription("Description of the user goes here");

		// --- STEP 1: Create SessionFactory ---
		final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		// --- STEP 2: Create session (getCurrentSession) ---
		Session session = sessionFactory.getCurrentSession();

		// --- STEP 3: Begin transaction ---
		session.beginTransaction();

		// --- STEP 4: Do something ---
		session.save(user);

		// --- STEP 5: Get transaction, Commit ---
		session.getTransaction().commit();

		// --- STEP 6: Close session ---
		session.close();

		/*
		 * We're gonna open new session and fetch an object that we have saved before.
		 * SESSION FACTORY IS CREATED ONLY ONCE PER APPLICATION !!!
		 */
		user = null;

		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		/*
		 *  Normally when we want to retrieve something from database we simply create SQL query and specify table name.
		 *  WE NEED PRIMARY KEY TO FETCH DATA !!!
		 */
		final int userId = 1;
		user = session.get(UserDetails.class, userId);

		System.out.println("User Name retrieved is " + user.getUserName());
	}
}
