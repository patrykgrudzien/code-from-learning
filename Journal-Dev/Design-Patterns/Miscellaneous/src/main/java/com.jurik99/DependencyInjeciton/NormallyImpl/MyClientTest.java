package com.jurik99.DependencyInjeciton.NormallyImpl;

public class MyClientTest {

	public static void main(final String[] args) {
		/**
		 * MyApplication class is responsible to initialize the email serviceImpl and then use it. This leads to hard-coded
		 * dependency. If we want to switch to some other advanced email serviceImpl in future, it will require code changes in
		 * MyApplication class. This makes our application hard to extend and if email serviceImpl is used in multiple classes then
		 * that would be even more harder.
		 *
		 * If we want to extend our application to provide additional messaging feature, such as SMS or Facebook message then we
		 * would need to write another application for that. This will involve code changes in application classes and in client
		 * classes too.
		 *
		 * Testing the application will be very difficult since our application is directly creating the email serviceImpl instance.
		 * There is no way we can mock these objects in our test classes.
		 */
		final MyApplication app = new MyApplication();
		app.processMessages("Test message", "testUser@gmail.com");
	}
}