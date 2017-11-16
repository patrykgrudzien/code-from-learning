package com.jurik99;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

public class HelloWorldConsumer {

	public static void main(final String[] args) {

		try {
			// --- Create a ConnectionFactory ---
			final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(Constants.BROKER_URL);

			// --- Create a Connection ---
			final Connection connection = connectionFactory.createConnection();
			connection.start();

			// --- Create a Session ---
			final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// --- Create a Destination ---
			final Queue queue = session.createQueue(Constants.QUEUE_NAME);

			// --- Create a MessageConsumer from the Session to the Topic or Queue ---
			final MessageConsumer consumer = session.createConsumer(queue);

			// --- Wait for a message ---
			final Message message = consumer.receive(Constants.RECEIVE_TIMEOUT);

			if (message instanceof TextMessage) {
				final TextMessage textMessage = (TextMessage) message;
				final String text = textMessage.getText();
				System.out.println("Received: " + text);
			}
			else {
				System.out.println("Received: " + message);
			}

			// --- Clean up ---
			consumer.close();
			session.close();
			connection.close();
		}
		catch (final JMSException exception) {
			exception.printStackTrace();
		}
	}
}
