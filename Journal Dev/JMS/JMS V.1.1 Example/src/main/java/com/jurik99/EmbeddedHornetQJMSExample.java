package com.jurik99;

import org.hornetq.jms.server.embedded.EmbeddedJMS;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

public class EmbeddedHornetQJMSExample {

	public static void main(final String[] args) {

		try {
			// --- This EmbeddedJMS class acts as a JMSServer for example: JBoss HornetQ Server ---
			final EmbeddedJMS jmsServer = new EmbeddedJMS();
			jmsServer.start();
			System.out.println("JD: Embedded JMS Server started.");

			final ConnectionFactory connectionFactory = (ConnectionFactory) jmsServer.lookup("JDConnectionFactory");
			final Queue queue = (Queue) jmsServer.lookup("/queue/JDQueue");
			Connection connection = null;

			try {
				connection = connectionFactory.createConnection();
				final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

				// --- 1. Producer Code Start ---
				final MessageProducer producer = session.createProducer(queue);
				final TextMessage sentMessage = session.createTextMessage("Hello, I'm Patrick.");
				System.out.println("Sending sentMessage: " + sentMessage.getText());
				producer.send(sentMessage);

				// --- 2. Consumer Code Start ---
				final MessageConsumer consumer = session.createConsumer(queue);
				connection.start();     // VERY IMPORTANT -> ONLY IN JMS API 1.1 !!!
				final TextMessage messageReceived = (TextMessage) consumer.receive(1000);
				System.out.println("Received message: " + messageReceived.getText());
			}
			finally {
				if (connection != null) {
					connection.close();
				}
				jmsServer.stop();
				System.out.println("JD: Embedded JMS Server stopped.");
			}
		}
		catch (final Exception exception) {
			exception.printStackTrace();
		}
	}

	/*
	 * I'M GETTING HERE SOME EXCEPTION AND DON'T KNOW WHY...
	 *
	 * WARN: HQ112054: AIO was not located on this platform, it will fall back to using pure Java NIO. If your platform is
	 * Linux, install LibAIO to enable the AIO journal
	 *
	 * Exception in thread "main" java.lang.IncompatibleClassChangeError: Implementing class
	 */
}
