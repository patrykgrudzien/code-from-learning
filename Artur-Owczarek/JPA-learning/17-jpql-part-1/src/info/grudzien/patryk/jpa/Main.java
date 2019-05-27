package info.grudzien.patryk.jpa;

import info.grudzien.patryk.jpa.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.Iterator;

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

		// addEmployees();

		Query query = entityManager.createQuery("select concat(e.firstName, ' ', e.lastName), e.salary * 0.2 from Employee e");
		Iterator<?> iterator = query.getResultList().iterator();
		
		while(iterator.hasNext())
		{
			Object[] items = (Object[]) iterator.next();
			String name = (String) items[0];
			double tax = (Double) items[1];
			System.out.println(name + " has to pay: " +tax);
			System.out.println();
		}

		// System.out.println(employee.getFirstName());
		// System.out.println(employee.getLastName());
		// System.out.println(employee.getSalary());

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
		addEmployee("Jan", "Nowak", 2633);
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
