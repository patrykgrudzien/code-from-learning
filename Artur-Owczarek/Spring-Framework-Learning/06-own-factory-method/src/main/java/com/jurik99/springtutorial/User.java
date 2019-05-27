package com.jurik99.springtutorial;

public class User {
	private String name;
	private int age;

	private User() {
	}

	public static User getInstance(final String name, final int age) {
		User user = new User();
		user.name = name;
		user.age = age;
		return user;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
}
