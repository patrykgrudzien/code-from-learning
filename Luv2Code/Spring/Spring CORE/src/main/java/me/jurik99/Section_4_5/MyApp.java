package me.jurik99.Section_4_5;

public class MyApp
{
	public static void main(final String[] args)
	{
		final Coach baseballCoach = new BaseballCoach();
		final Coach trackCoach = new TrackCoach();

		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(trackCoach.getDailyWorkout());
	}
}
