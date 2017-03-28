package me.jurik99.Section_6;

import me.jurik99.Section_4_5.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static me.jurik99.Constants.BEAN_LIFECYCLE_APPLICATION_CONTEXT;

public class BeanLifeCycleDemoApp
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
				                                         (BEAN_LIFECYCLE_APPLICATION_CONTEXT);

		Coach theCoach = context.getBean("myCoach", Coach.class);

		context.close();
	}
}
