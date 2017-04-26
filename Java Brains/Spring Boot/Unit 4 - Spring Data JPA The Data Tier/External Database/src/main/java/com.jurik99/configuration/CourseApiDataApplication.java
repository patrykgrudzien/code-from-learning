package com.jurik99.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jurik99")
public class CourseApiDataApplication
{
	/*
	 * --- STARTING SPRING BOOT ---
	 * 1) Sets up default configuration
	 * 2) Starts Spring application context
	 * 3) Performs class path scan
	 * 4) Starts Tomcat server
	 */

	public static void main(String[] args)
	{
		// --- WE DON'T NEED TO CREATE SPRING SERVLET CONTAINER ---
		SpringApplication.run(CourseApiDataApplication.class, args);
	}
}
