package me.jurik99.Section_10;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach
{
	private FortuneService fortuneService;

	@Value("${foo.email.section.10}")
	private String email;

	@Value("${foo.team.section.10}")
	private String team;

	public SwimCoach(final FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout()
	{
		return "Swim 1000 meters as a warm up.";
	}

	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}

	public String getEmail()
	{
		return email;
	}

	public String getTeam()
	{
		return team;
	}
}
