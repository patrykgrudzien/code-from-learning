package com.jurik99.springtutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {

	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		User user = context.getBean("user", User.class);
		System.out.println(user);
	}

}
