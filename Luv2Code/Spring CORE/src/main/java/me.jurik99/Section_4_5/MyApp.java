package me.jurik99.Section_4_5;

public class MyApp
{
	public static void main(String[] args)
	{
		Coach baseballCoach = new BaseballCoach();
		Coach trackCoach = new TrackCoach();

		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(trackCoach.getDailyWorkout());
	}
}
