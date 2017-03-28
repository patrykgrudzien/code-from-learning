package me.jurik99.main.named_queries;

import me.jurik99.dto.named_queries.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

import java.util.List;

public class HibernateTest
{
	@SuppressWarnings("Duplicates")
	public static void main(final String[] args)
	{
		final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		final Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

//		final Query query = session.getNamedQuery("UserDetails.byId");
		final Query query = session.getNamedNativeQuery("UserDetails.byName");
		query.setParameter(0, "User number 10");
		final List<UserDetails> users = query.getResultList();

		session.getTransaction().commit();
		session.close();

		for (final UserDetails user : users)
		{
			System.out.println(user.getUserName());
		}
	}
}
