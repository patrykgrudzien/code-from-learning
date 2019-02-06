package com.jurik99.DAO;

import java.util.Optional;

/**
 * The Data Access Object (DAO) pattern is a structural pattern that allows us to isolate the application/business layer from the persistence layer
 * (usually a relational database, but it could be any other persistence mechanism) using an abstract API.
 *
 * The functionality of this API is to hide from the application all the complexities involved in performing CRUD operations in the underlying storage mechanism.
 * This permits both layers to evolve separately without knowing anything about each other.
 *
 * In this tutorial, we’ll take a deep dive into the pattern’s implementation, and we’ll learn how to use it for abstracting calls to a JPA entity manager.
 *
 * -----------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * To understand how the DAO pattern works, let’s create a basic example.
 *
 * Let’s say that we want to develop an application that manages users. To keep the application’s domain model completely agnostic about the database,
 * we’ll create a simple DAO class that will take care of keeping these components neatly decoupled from each other.
 */
public class Main {

	private static Dao<User> userDao;

	public static void main(final String[] args) {

		userDao = new UserDao();

		final User user1 = getUser(0);
		System.out.println(user1);
		userDao.update(user1, new String[]{"Jake", "jake@domain.com"});

		final User user2 = getUser(1);
		userDao.delete(user2);
		userDao.save(new User("Julie", "julie@domain.com"));

		userDao.getAll()
		       .forEach(user -> System.out.println(user.getName()));
	}

	private static User getUser(final long id) {
		final Optional<User> user = userDao.get(id);
		return user.orElseGet(() -> new User("non-existing user", "no-email"));
	}

	/**
	 * The example is contrived, but it shows, in a nutshell, the motivations behind the DAO pattern. In this case, the main method just uses a UserDao instance to
	 * perform CRUD operations on a few User objects.
	 *
	 * The most relevant facet of this process is how UserDao hides from the application all the low-level details on how the objects are persisted, updated, and
	 * deleted.
	 */
}
