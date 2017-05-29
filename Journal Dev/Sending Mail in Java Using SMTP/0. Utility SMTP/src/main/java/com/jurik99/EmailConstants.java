package com.jurik99;

public interface EmailConstants
{
	String PORT_KEY = "mail.smtp.port";
	String PORT_VALUE = "587";

	String SMTP_START_TLS_KEY = "mail.smtp.starttls.enable";
	String SMTP_START_TLS_TRUE = "true";
	String SMTP_START_TLS_FALSE = "false";

	String HOST_KEY = "mail.smtp.host";
	String HOST_VALUE = "smtp.gmail.com";

	interface WithoutAuthentication
	{
		String SMTP_AUTH_KEY = "mail.smtp.auth";
		String SMTP_AUTH_FALSE = "false";
	}
}
