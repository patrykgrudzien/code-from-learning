package com.jurik99;

import javax.mail.Session;

import java.util.Properties;

import static com.jurik99.EmailConstants.HOST_KEY;
import static com.jurik99.EmailConstants.HOST_VALUE;
import static com.jurik99.EmailConstants.PORT_KEY;
import static com.jurik99.EmailConstants.PORT_VALUE;
import static com.jurik99.EmailConstants.SMTP_START_TLS_FALSE;
import static com.jurik99.EmailConstants.SMTP_START_TLS_KEY;
import static com.jurik99.EmailConstants.WithoutAuthentication.SMTP_AUTH_FALSE;
import static com.jurik99.EmailConstants.WithoutAuthentication.SMTP_AUTH_KEY;

public class SimpleEmail
{
	private static final String FROM_EMAIL = "from.email@gmail.com";
	private static final String TO_EMAIL = "to.email@gmail.com";

	public static void main(final String[] args)
	{
		System.out.println("SimpleEmail Start");

		final Properties properties = System.getProperties();
		properties.put(HOST_KEY, HOST_VALUE);
		properties.put(SMTP_AUTH_KEY, SMTP_AUTH_FALSE);
		properties.put(SMTP_START_TLS_KEY, SMTP_START_TLS_FALSE);
		properties.put(PORT_KEY, PORT_VALUE);

		/*
		 * Notice that we are using "Session.getInstance()" to get the Session object by passing the Properties
		 * object. We need to set the "mail.host" property with the SMTP server host. If the SMTP server is not
		 * running on default port (25), then we will also need to set "mail.smtp.port" property. Just run this
		 * program with your no-authentication SMTP server and by setting recipient email as your own email and you
		 * will get the email in no time.
		 *
		 * The program is simple to understand and works well but in real life most of the SMTP servers use some sort
		 * of authentication such as TLS or SSL. So we will see how to create Session object for these
		 * authentication protocols.
		 */
		final Session session = Session.getInstance(properties, null);
		EmailUtil.sendEmail(session, FROM_EMAIL, TO_EMAIL, "SimpleEmail Testing Subject", "SimpleEmail Testing Body");

		/*
		 * We are getting:
		 * ( com.sun.mail.smtp.SMTPSendFailedException: 530-5.5.1 Authentication Required. )
		 * because of course it depends on server's configuration. Server needs to be configured to allow you to send
		 * mail without authenticating first.
		 */
	}
}
