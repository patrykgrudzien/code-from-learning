package com.jurik99.springtutorial.implementation;

import com.jurik99.springtutorial.api.Logger;
import com.jurik99.springtutorial.api.UsersRepository;
import com.jurik99.springtutorial.domain.User;

public class UsersRepositoryImpl implements UsersRepository {

	private Logger logger;
	
	public User createUser(String name) {
		logger.log("Tworzenie uzytkownika " + name);
		return new User(name);
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

}
