package me.jurik99.main.criteria_API;

import me.jurik99.dto.criteria_API.UserDetails;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

public class HibernateTest
{
	@SuppressWarnings("Duplicates")
	public static void main(final String[] args)
	{
		final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		final Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		// --- instead of creating "QUERY" object, we'll create "CRITERIA" object ---
		/**
		 * it's DEPRECATED
		 */
		final Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("userName", "User number 10"));

		final List<UserDetails> users = criteria.list();

		session.getTransaction().commit();
		session.close();

		for (final UserDetails user : users)
		{
			System.out.println(user.getUserName());
		}


		// --- SINCE HIBERNATE 5.2 IT SHOULD LOOK LIKE THIS: ---
		final Session session1 = sessionFactory.getCurrentSession();

		// Get Criteria Builder
		final CriteriaBuilder builder = session1.getCriteriaBuilder();

		// Create Criteria
		final CriteriaQuery<UserDetails> criteria1 = builder.createQuery(UserDetails.class);
		final Root<UserDetails> from = criteria1.from(UserDetails.class);
		criteria1.select(from);

		// Use criteria to query with session to fetch all data
		session1.createQuery(criteria1).getResultList();

		// Close session
		session1.getTransaction().commit();
		session1.close();
	}
}
