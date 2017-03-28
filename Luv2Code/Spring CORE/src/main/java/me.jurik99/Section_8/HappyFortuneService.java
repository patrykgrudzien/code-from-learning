package me.jurik99.Section_8;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService
{
	@Override
	public String getFortune()
	{
		return "Today is your lucky day!";
	}
}
