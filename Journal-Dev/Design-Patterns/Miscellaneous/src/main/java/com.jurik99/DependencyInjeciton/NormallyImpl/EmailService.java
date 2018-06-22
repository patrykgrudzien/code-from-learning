package com.jurik99.DependencyInjeciton.NormallyImpl;

public class EmailService {

	public void sendEmail(final String message, final String receiver) {
		// logic to send email
		System.out.println("Email sent to " + receiver + " with message: " + message);
	}
}
