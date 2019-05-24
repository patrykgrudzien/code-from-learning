package com.jurik99;

public class Question2Main {

	public static void main(final String[] args) {

		final String specialChars = "诶豆贝尔维艾克斯 latin string 01234567890";

		// Regular Expression: [^a-zA-Z0-9]
		System.out.println(specialChars.replaceAll("[^a-zA-Z0-9]", ""));
	}
}
