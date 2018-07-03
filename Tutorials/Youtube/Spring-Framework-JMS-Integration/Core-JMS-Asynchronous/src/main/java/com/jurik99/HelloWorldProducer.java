package com.jurik99;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

public class HelloWorldProducer {

	public static void main(final String[] args) {

		try {
			// --- Create a ConnectionFactory ---
			final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(Constants.BROKER_URL);

			// --- Create a Connection ---
			final Connection connection = connectionFactory.createConnection();
			connection.start();

			// --- Create a Session ---
			final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// --- Create the Destination (Topic or Queue) ---
			final Queue queue = session.createQueue(Constants.QUEUE_NAME);

			// --- Create a MessageProducer from the Session to the Topic or Queue ---
			final MessageProducer producer = session.createProducer(queue);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			// --- Create a Message ---
			final String text = "Hello world! From : " + Thread.currentThread().getName();
			final TextMessage textMessage = session.createTextMessage(text);

			// --- Tell the producer to send the message ---
			System.out.println("Sent message: " + textMessage.hashCode() + " : " + Thread.currentThread().getName());
			producer.send(textMessage);

			// --- Clean up ---
			session.close();
			connection.close();
		}
		catch (final JMSException exception) {
			exception.printStackTrace();
		}
	}
}