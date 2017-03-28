package me.jurik99.Section_4_5;

public class CricketCoach implements Coach
{
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;

	public CricketCoach(final FortuneService fortuneService)
	{
		System.out.println("public CricketCoach(final FortuneService fortuneService)");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout()
	{
		return "Cricket playing for 60minutes";
	}

	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}

	public String getEmailAddress()
	{
		return emailAddress;
	}

	public void setEmailAddress(final String emailAddress)
	{
		System.out.println("public void setEmailAddress(final String emailAddress)");
		this.emailAddress = emailAddress;
	}

	public String getTeam()
	{
		return team;
	}

	public void setTeam(final String team)
	{
		System.out.println("public void setTeam(final String team)");
		this.team = team;
	}
}
