package me.jurik99.Section_10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("me.jurik99.Section_10")
@PropertySource("classpath:sport.properties")
public class SportConfigProperties
{
	// --- add support to resolve ${...} properties ---
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}

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
