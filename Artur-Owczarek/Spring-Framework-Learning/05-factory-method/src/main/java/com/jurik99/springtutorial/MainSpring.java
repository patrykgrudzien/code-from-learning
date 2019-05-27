package com.jurik99.springtutorial;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {

	public static void main(String[] args) {
		
//		Locale locale = Locale.getDefault();
//		Calendar calendar = GregorianCalendar.getInstance(locale);
//		DateFormat formatter = SimpleDateFormat.getInstance();
//		
//		System.out.println(formatter.format(calendar.getTime()));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		GregorianCalendar calendar = context.getBean("calendar", GregorianCalendar.class);
		SimpleDateFormat formatter = context.getBean("formatter", SimpleDateFormat.class);
		System.out.println(formatter.format(calendar.getTime()));
	}

}
