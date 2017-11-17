package com.jurik99;

import lombok.Getter;
import lombok.Setter;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Getter
@Setter
public class BasicJMSChat implements MessageListener {

	private JmsTemplate chatJmsTemplate;
	private Topic chatTopic;
	private static String userId;

	public static void main(final String[] args) throws JMSException, IOException {

		if (args.length != 1) {
			System.out.println("User name is required...");
		}
		else {
			userId = args[0];
			final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

			final BasicJMSChat basicJMSChat = (BasicJMSChat) context.getBean("basicJMSChat");
			final TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory) basicJMSChat.getChatJmsTemplate().getConnectionFactory();
			final TopicConnection topicConnection = topicConnectionFactory.createTopicConnection();

			basicJMSChat.publish(topicConnection, basicJMSChat.getChatTopic(), userId);
			basicJMSChat.subscribe(topicConnection, basicJMSChat.getChatTopic(), basicJMSChat);
		}
	}

	/**
	 * @param topicConnection topicConnection
	 * @param chatTopic chatTopic
	 * @param userId userId
	 */
	private void publish(final TopicConnection topicConnection, final Topic chatTopic, final String userId)
			throws JMSException, IOException {
		final TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		final TopicPublisher topicPublisher = topicSession.createPublisher(chatTopic);
		topicConnection.start();

		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			final String messageToSend = reader.readLine();
			if (messageToSend.equalsIgnoreCase("exit")) {
				topicConnection.close();
				System.exit(0);
			}
			else {
				final TextMessage textMessage = topicSession.createTextMessage();
				textMessage.setText("\n[" + userId + " : " + messageToSend + "]");
				topicPublisher.send(textMessage);
			}
		}
	}

	/**
	 * @param topicConnection topicConnection
	 * @param chatTopic chatTopic
	 * @param commandLineChar commandLineChar
	 * @throws JMSException exception
	 */
	private void subscribe(final TopicConnection topicConnection, final Topic chatTopic, final BasicJMSChat commandLineChar)
			throws JMSException {
		final TopicSession topicSession = (TopicSession) topicConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		final TopicSubscriber topicSubscriber = topicSession.createSubscriber(chatTopic);
		topicSubscriber.setMessageListener(commandLineChar);
	}

	@Override
	public void onMessage(final Message message) {

		// --- The message must be of type TextMessage ---
		if (message instanceof TextMessage) {
			try {
				final String messageText = ((TextMessage) message).getText();

				// --- Avoid echo ---
				if (!messageText.startsWith("[" + userId)) {
					System.out.println(messageText);
				}
			}
			catch (final JMSException exception) {
				System.err.println("An error occured extracting message.");
				exception.printStackTrace();
			}
		}
		else {
			final String errorMessage = "Message is not of expected type TextMessage.";
			System.err.println(errorMessage);
			throw new RuntimeException(errorMessage);
		}
	}
}
