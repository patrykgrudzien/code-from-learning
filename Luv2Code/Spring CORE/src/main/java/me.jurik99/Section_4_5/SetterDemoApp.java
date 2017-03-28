package me.jurik99.Section_4_5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import static me.jurik99.Constants.APPLICATION_CONTEXT_XML_CONFIG;

public class SetterDemoApp
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_CONFIG);

		System.out.println("--------------------------------------------");

		CricketCoach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);

		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
		System.out.println("e-mail: " + cricketCoach.getEmailAddress());
		System.out.println("team: " + cricketCoach.getTeam());

		context.close();
	}
}
