package info.grudzien.patryk.jpa;

import info.grudzien.patryk.jpa.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;

public class Main
{
	// =================================================================================================================== //
	private static final String PERSISTENCE_UNIT_NAME = "myDatabase";
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static ArrayList<Employee> employeesList = new ArrayList<Employee>();
	
	// =================================================================================================================== //
	public static void main(String[] args)
	{
		/**
		 * ZEBY ZAINICJOWAC "JPA", ZEBY GO URUCHOMIC POTRZEBUJEMY COS TAKIEGO JAK "EntityManagerFactory"
		 */
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		
		/**
		 * Dalej chcemy uzyskac obiekt klasy "EntityManager"
		 * 
		 * Entitymanager to nasz "most" pomiędzy bazą danych a naszą aplikacją
		 * 
		 * EntityManager - wazny obiekt z uzyciem ktorego dane zapisujemy do bazy danych, 
		 * wyszukujemy, wykonujemy jakies zapytania
		 */
		entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee1 = addEmployee("Patryk", "Grudzien", 3000.567);
		Employee employee2 = addEmployee("Damian", "Grudzien", 3500.123);
		
		employeesList.add(employee1);
		employeesList.add(employee2);
		
		makeTransaction();
	}
	
	private static Employee addEmployee(String firstName, String lastName, double salary)
	{
		Employee employee = new Employee();
		
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);
		
		return employee;
	}
	
	private static void makeTransaction()
	{
		entityManager.getTransaction().begin();
		
		for (int i = 0; i < employeesList.size(); i++)
		{
			entityManager.persist(employeesList.get(i));
		}
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
