package com.jurik99.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
 *  @EnableWebMvc:
 *  1) Provides similar support to <mvc:annotation-driven /> in XML
 *  2) Adds conversion, formatting and validation support
 *  3) Processing of @Controller classes and @RequestMapping etc... methods
 *
 *  "WebMvcConfigurerAdapter" abstract class has been DEPRECATED cause now in "WebMvcConfigurer" interface we have a lot of
 *  default methods which can be simply OVERRIDDEN :)
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jurik99")
public class SpringServletAndWebXmlConfiguration implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		final InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/view/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

	@Override
	public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
