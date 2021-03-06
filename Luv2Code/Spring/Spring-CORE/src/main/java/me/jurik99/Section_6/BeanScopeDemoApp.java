package me.jurik99.Section_6;

import static me.jurik99.Constants.BEAN_SCOPE_APPLICATION_CONTEXT;

import me.jurik99.Section_4_5.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp
{
	public static void main(final String[] args)
	{
		final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(BEAN_SCOPE_APPLICATION_CONTEXT);

		final Coach theCoach = context.getBean("myCoach", Coach.class);
		final Coach alphaCoach = context.getBean("myCoach", Coach.class);

		System.out.println(theCoach);
		System.out.println(alphaCoach);
		System.out.println("Tha same objects? = " + (theCoach == alphaCoach));

		context.close();
	}
}
