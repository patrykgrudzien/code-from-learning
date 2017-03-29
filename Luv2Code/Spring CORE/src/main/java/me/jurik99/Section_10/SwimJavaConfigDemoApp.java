package me.jurik99.Section_10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp
{
	public static void main(String[] args)
	{
		// --- read spring config file ---
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfigProperties
				                                                                                    .class);

		SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);

		System.out.println(swimCoach.getDailyWorkout());
		System.out.println(swimCoach.getDailyFortune());
		System.out.println(swimCoach.getEmail());
		System.out.println(swimCoach.getTeam());

		context.close();
	}
}
