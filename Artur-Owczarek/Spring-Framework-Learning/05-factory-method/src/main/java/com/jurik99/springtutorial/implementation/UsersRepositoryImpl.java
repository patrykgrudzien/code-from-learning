package com.jurik99.springtutorial.implementation;

import com.jurik99.springtutorial.api.Logger;
import com.jurik99.springtutorial.api.UsersRepository;
import com.jurik99.springtutorial.domain.User;

public class UsersRepositoryImpl implements UsersRepository {

	private Logger logger;

	public UsersRepositoryImpl(Logger logger, String localisation, String dbName) {
		this.logger = logger;
		logger.log("Lokalizacja repozytorium: " + localisation + "/" + dbName);
	}

	public User createUser(String name) {
		logger.log("Tworzenie uzytkownika " + name);
		return new User(name);
	}
}
