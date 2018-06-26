package SmallerScale.BeanDAOFactory.View;

/**
 * This is a "BEAN" class
 * <p>
 * BEAN is something that STORES SOME DATA and has SETTERS & GETTERS for that DATA
 * <p>
 * In this case we call "CreateUserEvent" class because we are gonna use this BEAN to transmit information about an event
 */
public class CreateUserEvent {

	private String name, password;

	CreateUserEvent(final String name, final String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}
}
