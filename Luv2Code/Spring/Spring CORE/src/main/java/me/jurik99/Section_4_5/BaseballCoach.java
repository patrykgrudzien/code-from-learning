package me.jurik99.Section_4_5;

public class BaseballCoach implements Coach
{
	private FortuneService fortuneService;

	public BaseballCoach()
	{
		System.out.println("public BaseballCoach()");
	}

	public String getDailyWorkout()
	{
		return "Worked for 30 minutes today";
	}

	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}

	public void setFortuneService(final FortuneService fortuneService)
	{
		System.out.println("public void setFortuneService(final FortuneService fortuneService)");
		this.fortuneService = fortuneService;
	}
}
