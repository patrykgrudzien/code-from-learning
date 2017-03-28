package me.jurik99.Section_7;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach
{
	@Override
	public String getDailyWorkout()
	{
		return "Practice your backhand volley";
	}
}
