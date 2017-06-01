package com.jurik99.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jurik99.dto.Address;
import com.jurik99.dto.UserDetails;

@SuppressWarnings("Duplicates")
public class HibernateTest
{
	public static void main(final String[] args)
	{
		UserDetails user1 = new UserDetails();
		user1.setUserName("First User");

		final Address address1 = new Address();
		address1.setStreet("First Street");
		address1.setCity("First City");
		address1.setState("First State");
		address1.setPincode("100001");

		final Address address2 = new Address();
		address2.setStreet("Second Street");
		address2.setCity("Second City");
		address2.setState("Second State");
		address2.setPincode("200002");

		user1.getListOfAddresses().add(address1);
		user1.getListOfAddresses().add(address2);

		// --- STEP 1: Create SessionFactory ---
		final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		// --- STEP 2: Create session (getCurrentSession) ---
		Session session = sessionFactory.getCurrentSession();

		// --- STEP 3: Begin transaction ---
		session.beginTransaction();

		// --- STEP 4: Do something ---
		session.save(user1);

		// --- STEP 5: Get transaction, Commit ---
		session.getTransaction().commit();

		// --- STEP 6: Close session ---
		session.close();

		/*
		 * Now we have all that things persisted in database and we want to RETRIEVE that.
		 */
		user1 = null;

		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		user1 = session.get(UserDetails.class, 1); // Hibernate is pulling PROXY object here

		/*
		 * Now, how could we get a list of addresses not using Hibernate?
		 * We would run the QUERY to fetch user data. The second QUERY would be to get ADDRESSES from user data
		 * (get all addresses where USER_ID = 1).
		 * If I wanted a particular set of addresses I could restrict in WHERE clause what exactly I need.
		 *
		 * Using Hibernate, when we're doing:
		 * session.get() -> what we're actually pulling up?
		 * We get the "user" object and that "user" has a list of addresses. The question is: does that whole list of
		 * addresses get pulled up ???
		 * If the answer is YES -> another question, let's say I have 100 of addresses in that particular user. What
		 * is the cost if I get pulled that user with such huge list of data? What is the performance impact? Why do
		 * I need whole list if I only need a user NAME?
		 * ------------------------------------------------------------------------------------------------------------
		 * To answer this question, we have to look at: WHAT IS "FETCH" STRATEGY. Hibernate provide such strategy to
		 * solve this problem.
		 *
		 * If we need only user name, we can ask Hibernate NOT to pull everything (in fact, that is the
		 * DEFAULT behavior).
		 * It's called:
		 * LAZY INITIALIZATION - it means that, we don't initialize the ENTIRE object, we initialize ONLY first level
		 * variables.
		 *
		 * When I decided that I need list of addresses, I write:
		 * final Collection<Address> listOfAddresses = user1.getListOfAddresses();
		 * the moment when I use this "getListOfAddresses()" method, Hibernate goes and runs another query to the
		 * database and fetches listOfAddresses. It's MUCH MORE EFFICIENT !!!
		 * ------------------------------------------------------------------------------------------------------------
		 * Opposite strategy to "lazy" is EAGER INITIALIZATION (Hibernate will fetch all possible data no matter what).
		 * It takes a lot of resources, a lot of time.
		 * ------------------------------------------------------------------------------------------------------------
		 * How can Hibernate get whole values when we call "getListOfAddresses()"?
		 * The way Hibernate does this is by using what's called:
		 * PROXY CLASS
		 * Hibernate instead of getting actual object that we're looking for, it gets the PROXY for the FIRST TIME.
		 * It's a DYNAMIC SUB-CLASS of our actual object !!! (look at the screenshot)
		 *
		 * When we need "listOfAddresses", our fully qualified sub-class (PROXY) makes a call to database JUST IN TIME,
		 * fetches needed data and then calls PARENT method (User Class -> getListOfAddresses()). It's happening
		 * before our GETTER runs behind the scenes thanks to Hibernate and we don't need to worry about "User Class"
		 * itself or "Proxy User Class".
		 *
		 * As a proof:
		 */
		System.out.println(user1.getListOfAddresses().size());
		/*
		 * We have already PROXY object of User.class (above) and when we here call "getListOfAddresses().size()" our
		 * PROXY object once again fetches the values from database, calls parent and print the size() = 2.
		 *
		 * ------------------------------------------------------------------------------------------------------------
		 *
		 * When we would close a session (session.close();) before:
		 * System.out.println(user1.getListOfAddresses().size());
		 * we get en "LazyInitializationException" because our PROXY object didn't manage to fetch data before
		 * closing a session because of LAZY FETCH STRATEGY which is a default one.
		 *
		 * This problem in that scenario can be solved by going to @ElementCollection annotation and adding:
		 * @ElementCollection(fetch = FetchType.EAGER)
		 */
	}
}
