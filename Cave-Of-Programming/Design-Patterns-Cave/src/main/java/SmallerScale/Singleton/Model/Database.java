package SmallerScale.Singleton.Model;

public class Database {

	private static final Database instance = new Database();

	private Database() {}

	public static Database getInstance() {
		return instance;
	}

	public void connect() {
		System.out.println("Connected to database.");
	}

	public void disconnect() {
		System.out.println("Disconnected.");
	}
}