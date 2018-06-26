package SmallerScale.BeanDAOFactory.Model;

/**
 * Class which creates TRANSFER OBJECT.
 * <p>
 * This "TRANSFER OBJECT" contains data which we wanna deal with this particular TABLE.
 * <p>
 * And this is a "BEAN". It has NON ARGUMENT CONSTRUCTOR.
 * <p>
 * It is used for TRANSFERING data from one place to another
 */
public class Person {

	private int id;
	private String name, password;

	public Person() {

	}

	public Person(final String name, final String password) {
		setName(name);
		setPassword(password);
	}

	public Person(final int id, final String name, final String password) {
		setId(id);
		setName(name);
		setPassword(password);
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
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

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Person))
			return false;

		final Person person = (Person) o;

		if (name != null ? !name.equals(person.name) : person.name != null)
			return false;
		return password != null ? password.equals(person.password) : person.password == null;

	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (password != null ? password.hashCode() : 0);
		return result;
	}
}
