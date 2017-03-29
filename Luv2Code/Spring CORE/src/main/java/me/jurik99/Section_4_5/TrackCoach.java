package me.jurik99.Section_4_5;

public class TrackCoach implements Coach
{
	private FortuneService fortuneService;

	public TrackCoach()
	{
		System.out.println("public TrackCoach()");
	}

	public TrackCoach(final FortuneService fortuneService)
	{
		System.out.println("public TrackCoach(final FortuneService fortuneService)");
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout()
	{
		return "Hard 5k";
	}

	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}
}
