package me.jurik99.Section_6;

import me.jurik99.Section_4_5.Coach;
import me.jurik99.Section_4_5.FortuneService;

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

	// --- add an init method ---
	public void doMyStartStuff()
	{
		System.out.println("TrackCoach: inside method doMyStartStuff()");
	}

	// --- add a destroy method ---
	public void doMyCleanupStuff()
	{
		System.out.println("TrackCoach: inside method doMyCleanupStuff()");
	}
}
