package me.jurik99.Section_8;

import static me.jurik99.Constants.DEPENDENCY_INJECTION_APPLICATION_CONTEXT;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
				                                         (DEPENDENCY_INJECTION_APPLICATION_CONTEXT);

		Coach tennisCoach = context.getBean("tennisCoach", Coach.class);

		System.out.println(tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());

		context.close();
	}
}
