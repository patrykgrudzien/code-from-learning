package DependencyInjeciton.InjectionImpl;

public class MyMessageDITest {
	public static void main(final String[] args) {
		final String message = "Test message";
		final String email = "testUser@gmail.com";
		final String phone = "1235456758";

		MessageServiceInjector injector;
		Consumer app;

		// SEND EMAIL
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(message, email);

		// SEND SMS
		injector = new SMServiceInjector();
		app = injector.getConsumer();
		app.processMessages(message, phone);
	}
}
