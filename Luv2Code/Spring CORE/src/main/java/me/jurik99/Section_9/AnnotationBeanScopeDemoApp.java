package me.jurik99.Section_9;

import static me.jurik99.Constants.SECTION_9_APPLICATION_CONTEXT;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(SECTION_9_APPLICATION_CONTEXT);

		Coach tennisCoach = context.getBean("tennisCoach", Coach.class);
		Coach tennisCoach1 = context.getBean("tennisCoach", Coach.class);

		System.out.println(tennisCoach == tennisCoach1);

		context.close();
	}
}
