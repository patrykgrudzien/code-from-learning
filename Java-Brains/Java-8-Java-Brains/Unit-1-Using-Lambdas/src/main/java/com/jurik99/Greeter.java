package com.jurik99;

public class Greeter
{
	private void greet(final Greeting greeting)
	{
		greeting.perform();
	}

	public static void main(final String[] args)
	{
		final Greeter greeter = new Greeter();
//		final HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
//		greeter.greet(helloWorldGreeting);

		final Greeting myLambdaFunction = () -> System.out.println("Hello World!");
		greeter.greet(myLambdaFunction);

		greeter.greet(() -> System.out.println("Hello World Inline!"));
	}
}