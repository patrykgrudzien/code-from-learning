package DependencyInjeciton.InjectionImpl;

public class MyMessageDITest {
	public static void main(String[] args) {
		String message = "Test message";
		String email = "testUser@gmail.com";
		String phone = "1235456758";

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
