package com.jurik99.DAO;

/**
 * The User class is just a plain container for user data, so it doesn’t implement any other behavior worth stressing.
 *
 * Of course, the most relevant design choice that we need to make here is how to keep the application that uses this class isolated from any persistence mechanism
 * that could be implemented at some point.
 *
 * Well, that’s exactly the issue that the DAO pattern attempts to address.
 */
public class User {

	private String name;
	private String email;

	public User(final String name, final String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}
}
