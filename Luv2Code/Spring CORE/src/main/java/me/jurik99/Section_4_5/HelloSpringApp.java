package me.jurik99.Section_4_5;

import static me.jurik99.Constants.APPLICATION_CONTEXT_XML_CONFIG;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp
{
	public static void main(final String[] args)
	{
		// --- load the spring configuration file ---
		final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_CONFIG);

		System.out.println("--------------------------------------------");

		// --- retrieve bean from spring container ---
		final Coach trackCoach = context.getBean("trackCoach", Coach.class);

		// --- call methods on the bean ---
		System.out.println(trackCoach.getDailyWorkout());
		System.out.println(trackCoach.getDailyFortune());

		System.out.println("--------------------------------------------");

		// --- get baseballCoach ---
		final Coach baseballCoach = context.getBean("baseballCoach", Coach.class);

		// --- call baseballCoach methods ---
		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(baseballCoach.getDailyFortune());

		// --- close the context ---
		context.close();
	}
}
