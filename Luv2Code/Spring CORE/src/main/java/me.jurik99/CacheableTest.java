package me.jurik99;

import org.springframework.cache.annotation.Cacheable;

public class CacheableTest
{
	public static void main(final String[] args)
	{

	}

	@Cacheable(value = "message", key = "#message")
	private static String getMessage(final String message)
	{
		return "Hello World with Cache";
	}
}
