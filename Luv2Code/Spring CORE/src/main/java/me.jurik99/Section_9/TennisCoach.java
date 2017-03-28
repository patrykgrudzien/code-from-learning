package me.jurik99.Section_9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach
{
	private FortuneService fortuneService;

	public TennisCoach()
	{
		System.out.println(">> TennisCoach: inside default constructor");
	}

	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService") final FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}

	// --- @Autowired is now realized by field injection ---
	public void setFortuneService(final FortuneService fortuneService)
	{
		System.out.println(">> TennisCoach: inside setter");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout()
	{
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}

	// --- define my init method ---
	@PostConstruct
	public void init()
	{
		System.out.println(">> TennisCoach: inside of init() method");
	}

	// --- define my destroy method ---
	@PreDestroy
	public void destroy()
	{
		System.out.println(">> TennisCoach: inside of destroy() method");
	}
}
