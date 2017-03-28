package me.jurik99.main.transient_persistent_detached;

import me.jurik99.dto.transient_persistent_detached.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest
{
	@SuppressWarnings("Duplicates")
	public static void main(final String[] args)
	{
		final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// --- 1 STEP. Initialization of "UserDetails" object ---
		/**
		 * - If we don't pass "UserDetails" object to the "session.save();"
		 * this object is called as "TRANSIENT OBJECT".
		 * - It means that it's not persistent and not saved to the database.
		 * - Hibernate doesn't know that this objects has to be saved.
		 */
		final UserDetails firstUser = new UserDetails();
		firstUser.setUserName("Test User");

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		final UserDetails user = session.get(UserDetails.class, 1);

		session.getTransaction().commit();
		session.close();

		// --- 2 STEP. Pass this object to "session.save(user);" ---
		/**
		 * - If I do "session.save();"
		 * that "user" object becomes "PERSISTANT OBJECT"
		 * - When the object is PERSISTANT, Hibernate tracks this object and saves it to the database.
		 */
		// session.save(user);
		// user.setUserName("Updated User");

		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		// --- we didn't do any changes to that user above ---
		session.update(user);

		session.getTransaction().commit();
		// --- 3 STEP. Once I do "session.close()", "user" object becomes DETACHED OBJECT ---
		session.close();
	}
}
