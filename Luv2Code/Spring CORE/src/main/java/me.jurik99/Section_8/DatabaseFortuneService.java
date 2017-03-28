package me.jurik99.Section_8;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService
{
	@Override
	public String getFortune()
	{
		return "DatabaseFortuneService";
	}
}
