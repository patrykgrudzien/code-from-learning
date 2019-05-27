package com.jurik99.springtutorial.api;

import com.jurik99.springtutorial.domain.User;

public interface UsersRepository {

	User createUser(final String name);
	void setLogger(final Logger logger);
	
}
