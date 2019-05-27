package com.jurik99.springtutorial;

import java.util.logging.Logger;

public class UsersCreator {
	
	private Logger logger = Logger.getLogger(UsersCreator.class.getName());
	
	public User createUser(final String name)
	{
		logger.info("Tworzenie uzytkownika: " + name);
		User user = new User();
		user.setName(name);
		return user;
	}
}
