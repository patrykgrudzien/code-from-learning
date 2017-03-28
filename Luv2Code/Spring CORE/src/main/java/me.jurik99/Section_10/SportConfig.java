package me.jurik99.Section_10;

import org.springframework.context.annotation.Bean;

//@Configuration
//@ComponentScan("me.jurik99.Spring_Core.Section_10")
public class SportConfig
{
	// --- define bean for our sad fortune service (method name should be the same as bean id) ---
	@Bean
	public FortuneService sadFortuneService()
	{
		return new SadFortuneService();
	}

	// --- define bean for our swim coach AND inject dependency ---
	@Bean
	public Coach swimCoach()
	{
		return new SwimCoach(sadFortuneService());
	}
}
