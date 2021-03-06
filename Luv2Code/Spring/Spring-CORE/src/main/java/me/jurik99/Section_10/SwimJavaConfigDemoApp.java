package me.jurik99.Section_10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp
{
	public static void main(final String[] args)
	{
		// --- read spring config file ---
		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfigProperties
				                                                                                    .class);

		final SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);

		System.out.println(swimCoach.getDailyWorkout());
		System.out.println(swimCoach.getDailyFortune());
		System.out.println(swimCoach.getEmail());
		System.out.println(swimCoach.getTeam());

		context.close();
	}
}
