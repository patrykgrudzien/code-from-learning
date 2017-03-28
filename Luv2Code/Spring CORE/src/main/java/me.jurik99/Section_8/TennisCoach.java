package me.jurik99.Section_8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class TennisCoach implements Coach
{
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	public TennisCoach()
	{
		System.out.println(">> TennisCoach: inside default constructor");
	}

	// --- @Autowired deleted because FortuneService is injected below via setter ---
	public TennisCoach(final FortuneService fortuneService)
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
}
