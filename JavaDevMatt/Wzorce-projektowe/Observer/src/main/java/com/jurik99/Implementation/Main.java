package com.jurik99.Implementation;

public class Main
{
	public static void main(final String[] args)
	{
		final YTChannel ytChannel = new YTChannel();
		final YTUser ytUser = new YTUser("JuRik99");

		ytChannel.register(ytUser);

		ytChannel.publishNewVideo();
		System.out.println("--------------------------------------------");

		// --- Kanał YouTube powiadamia użytkowników, sami użytkownicy nie muszą wykonywać metody update(); ---

		final YTUser ytUser1 = new YTUser("John");
		ytChannel.register(ytUser1);
		ytChannel.publishNewVideo();
		System.out.println("--------------------------------------------");

		ytChannel.unregister(ytUser);
		ytChannel.publishNewVideo();
	}
}
