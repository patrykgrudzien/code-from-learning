package com.jurik99.springtutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jurik99.springtutorial.api.UsersRepository;
import com.jurik99.springtutorial.domain.User;
import com.jurik99.springtutorial.implementation.SomeBean;

public class MainSpring {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("konfiguracja.xml");

		SomeBean bean = context.getBean("someBean", SomeBean.class);
	}

}
