package info.grudzien.patryk.jpa;

import info.grudzien.patryk.jpa.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main
{
	// ===================================================================================================================
	// //
	private static final String PERSISTENCE_UNIT_NAME = "myDatabase";
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	// ===================================================================================================================
	// //
	public static void main(String[] args)
	{
		/**
		 * ZEBY ZAINICJOWAC "JPA", ZEBY GO URUCHOMIC POTRZEBUJEMY COS TAKIEGO
		 * JAK "EntityManagerFactory"
		 */
		entityManagerFactory = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

		/**
		 * Dalej chcemy uzyskac obiekt klasy "EntityManager"
		 * 
		 * Entitymanager to nasz "most" pomiędzy bazą danych a naszą aplikacją
		 * 
		 * EntityManager - wazny obiekt z uzyciem ktorego dane zapisujemy do
		 * bazy danych, wyszukujemy, wykonujemy jakies zapytania
		 */
		entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createQuery("select substring(e.firstName, 1, 3), trim(e.lastName), lower(e.firstName), upper(e.firstName), length(e.firstName) from Employee e where e.firstName = 'Jan'");
		Object[] result = (Object[]) query.getSingleResult();
		
		System.out.println("Pierwsze 3 litery imienia: " +result[0]);
		System.out.println("Nazwisko bez spacji: |" +result[1] + "|");
		System.out.println("Imię małymi literami: " +result[2]);
		System.out.println("Imię dużymi literami: " +result[3]);
		System.out.println("Długosc imienia: " +result[4]);
		
		entityManager.close();
		entityManagerFactory.close();

	}

	// ===================================================================================================================
	// //
	private static void addEmployee(String firstName, String lastName,
			double salary)
	{
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}

	// ===================================================================================================================
	// //
	private static void addEmployees()
	{
		addEmployee("Jan", "          Nowak", 2633);
		addEmployee("Tomasz", "Czop", 2345);
		addEmployee("Paweł", "Heda", 7346);
		addEmployee("Damian", "Grudzień", 6543);
		addEmployee("Patrycja", "Stawiarz", 9999);
		addEmployee("Violetta", "Grudzień", 5000);
		addEmployee("Piotr", "Zasadni", 7543);
		addEmployee("Zbigniew", "Pałka", 2355);
		addEmployee("Łukasz", "Piszczek", 8989);
	}

}
