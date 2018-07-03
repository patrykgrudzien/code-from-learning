package com.jurik99;

import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class JmsTemplateTest {

	public static void main(final String[] args) {

		/*
		 * THIS XML CONFIGURATION DOES NOT WANT TO WORK BECEAUSE OF SOME ERRORS WITH:
		 * "org.apache.activemq.pool.PooledConnectionFactory"
		 */
		final ApplicationContext context = new ClassPathXmlApplicationContext("JmsTemplateTest-context.xml");
		final JmsTemplate template = (JmsTemplate) context.getBean("jmsTemplate");

		template.send(Constants.SPRING_QUEUE_NAME, new MessageCreator() {
			@Override
			public Message createMessage(final Session session) throws JMSException {
				return session.createTextMessage("This is a test message");
			}
		});
		System.out.println("Message sent.");

		System.exit(1);
	}
}
