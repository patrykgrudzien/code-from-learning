package com.jurik99.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jurik99.dto.Address;
import com.jurik99.dto.UserDetails;
import com.jurik99.dto.LoginName;

@SuppressWarnings("Duplicates")
public class HibernateTest
{
	public static void main(final String[] args)
	{
		final UserDetails user1 = new UserDetails();
		user1.setUserName("First User");

		final Address homeAddress = new Address();
		homeAddress.setStreet("Home street");
		homeAddress.setCity("Home city");
		homeAddress.setState("Home state");
		homeAddress.setPincode("Home pincode");
		user1.setHomeAddress(homeAddress);

		final Address officeAddress = new Address();
		officeAddress.setStreet("Office street");
		officeAddress.setCity("Office city");
		officeAddress.setState("Office state");
		officeAddress.setPincode("Office pincode");
		user1.setOfficeAddress(officeAddress);

		/*
		 * LoginName is primary key of combination of fields (firstName, lastName, loginId, socialSecurityNumber)
		 */
		final LoginName loginName = new LoginName();
		loginName.setFirstName("Login name");
		loginName.setLastName("Login last name");
		loginName.setLoginId(1);
		loginName.setSocialSecurityNumber(99);
		user1.setLoginName(loginName);

		// --- STEP 1: Create SessionFactory ---
		final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		// --- STEP 2: Create session (getCurrentSession) ---
		final Session session = sessionFactory.getCurrentSession();

		// --- STEP 3: Begin transaction ---
		session.beginTransaction();

		// --- STEP 4: Do something ---
		session.save(user1);

		// --- STEP 5: Get transaction, Commit ---
		session.getTransaction().commit();

		// --- STEP 6: Close session ---
		session.close();
	}
}
