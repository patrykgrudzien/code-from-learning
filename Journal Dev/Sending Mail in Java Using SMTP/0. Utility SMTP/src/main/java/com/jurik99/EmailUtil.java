package com.jurik99;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public abstract class EmailUtil
{
	private static final String UTF_8 = "UTF-8";
	/*
	 * Our EmailUtil class that has a single method to send email looks like below. It requires (javax.mail.Session)
	 * and some other required fields as arguments. To keep it simple, some of the arguments are hard coded but you
	 * can extend this method to pass them or read it from some config files.
	 */

	/**
	 * Utility method to send simple HTML email
	 * @param session session
	 * @param toEmail recipient email address
	 * @param subject subject of the email
	 * @param body message in the email
	 */
	public static void sendEmail(final Session session, final String fromEmail, final String toEmail,
	                             final String subject, final String body)
	{
		final MimeMessage message = new MimeMessage(session);

		try
		{
			// --- set message headers ---
			message.addHeader("Content-type", "text/HTML; charset=UTF-8");
			message.addHeader("format", "flowed");
			message.addHeader("Content-Transfer-Encoding", "8bit");

			message.setFrom(new InternetAddress(fromEmail, "NoReply-JD"));
			message.setReplyTo(InternetAddress.parse(fromEmail, false));
			message.setSubject(subject, UTF_8);
			message.setText(body, UTF_8);
			message.setSentDate(new Date());
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(message);

			/*
			 * Notice that we are setting header properties in the MimeMessage, they are used by the email client to
			 * properly render and display the email message. Rest of the program is simple and self understood.
			 */
		}
		catch (final MessagingException | UnsupportedEncodingException exception)
		{
			System.out.println("Cannot send e-mail...");
			exception.printStackTrace();
		}
	}
}
