package me.jurik99.Section_4_5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import static me.jurik99.Constants.APPLICATION_CONTEXT_XML_CONFIG;

public class HelloSpringApp
{
	public static void main(String[] args)
	{
		// --- load the spring configuration file ---
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_CONFIG);

		System.out.println("--------------------------------------------");

		// --- retrieve bean from spring container ---
		Coach trackCoach = context.getBean("trackCoach", Coach.class);

		// --- call methods on the bean ---
		System.out.println(trackCoach.getDailyWorkout());
		System.out.println(trackCoach.getDailyFortune());

		System.out.println("--------------------------------------------");

		// --- get baseballCoach ---
		Coach baseballCoach = context.getBean("baseballCoach", Coach.class);

		// --- call baseballCoach methods ---
		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(baseballCoach.getDailyFortune());

		// --- close the context ---
		context.close();
	}
}
