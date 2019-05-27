package com.jurik99.springtutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {

	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		SomeBean someBean2 = context.getBean("someBean2", SomeBean.class);
		System.out.println(someBean2.getStringValue());
	}

}
