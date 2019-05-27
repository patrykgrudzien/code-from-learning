package com.jurik99.springtutorial;

import com.jurik99.springtutorial.api.Logger;
import com.jurik99.springtutorial.api.UsersRepository;
import com.jurik99.springtutorial.domain.User;
import com.jurik99.springtutorial.implementation.LoggerImpl;
import com.jurik99.springtutorial.implementation.UsersRepositoryImpl;

public class Main {

	public static void main(String[] args) {
		
		Logger logger = new LoggerImpl();
		UsersRepository repository = new UsersRepositoryImpl();
		
		repository.setLogger(logger);
		
		User user = repository.createUser("Patryk");
	}

}
