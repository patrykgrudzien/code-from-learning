package me.jurik99.Section_7;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import static me.jurik99.Constants.ANNOTATION_APPLICATION_CONTEXT;

public class AnnotationDemoApp
{
	public static void main(String[] args)
	{
		// --- read spring config file ---
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
				                                         (ANNOTATION_APPLICATION_CONTEXT);

		// --- get the bean from spring container ---
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		// --- call a method ---
		System.out.println(theCoach.getDailyWorkout());

		// --- close context ---
		context.close();
	}
}
