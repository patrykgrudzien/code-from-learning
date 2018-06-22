package com.jurik99.DependencyInjeciton.NormallyImpl;

public class MyApplication {

	private EmailService email = new EmailService();

	public void processMessages(final String msg, final String rec) {
		email.sendEmail(msg, rec);
	}
}
