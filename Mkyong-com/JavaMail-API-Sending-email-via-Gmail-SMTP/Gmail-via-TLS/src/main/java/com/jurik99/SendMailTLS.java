package com.jurik99;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

public class SendMailTLS
{
	private static final String USER_NAME = "PROVIDE_USER_NAME";
	private static final String PASSWORD = "PROVIDE_USER_PASSWORD";

	private static final String SMTP_AUTH_KEY = "mail.smtp.auth";
	private static final String SMTP_AUTH_VALUE = "true";

	private static final String SMTP_START_TLS_KEY = "mail.smtp.starttls.enable";
	private static final String SMTP_START_TLS_VALUE = "true";

	private static final String HOST_KEY = "mail.smtp.host";
	private static final String HOST_VALUE = "smtp.gmail.com";

	private static final String PORT_KEY = "mail.smtp.port";
	private static final String PORT_VALUE = "587";

	private static final String SENDER_ADDRESS = USER_NAME;
	private static final String RECIPIENT_ADDRESS = "RECIPIENT_EMAIL_ADDRESS";

	public static void main(final String[] args)
	{
		final Properties properties = new Properties();
		properties.put(SMTP_AUTH_KEY, SMTP_AUTH_VALUE);
		properties.put(SMTP_START_TLS_KEY, SMTP_START_TLS_VALUE);
		properties.put(HOST_KEY, HOST_VALUE);
		properties.put(PORT_KEY, PORT_VALUE);

		final Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(USER_NAME, PASSWORD);
			}
		});

		try
		{
			final Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(SENDER_ADDRESS));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(RECIPIENT_ADDRESS));
			message.setSubject("Testing Subject");
			message.setText("Test e-mail which has been sent via Java Code!");

			Transport.send(message);

			System.out.println("DONE !!!");
		}
		catch (final MessagingException exception)
		{
			throw new RuntimeException(exception.getMessage());
		}
	}
}
