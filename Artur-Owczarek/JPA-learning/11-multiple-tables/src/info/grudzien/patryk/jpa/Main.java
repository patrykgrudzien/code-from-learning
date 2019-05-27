package info.grudzien.patryk.jpa;

import info.grudzien.patryk.jpa.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main
{
	// =================================================================================================================== //
	private static final String PERSISTENCE_UNIT_NAME = "myDatabase";
	private static EntityManager entityManager;
	
	// =================================================================================================================== //
	public static void main(String[] args)
	{
		/**
		 * ZEBY ZAINICJOWAC "JPA", ZEBY GO URUCHOMIC POTRZEBUJEMY COS TAKIEGO JAK "EntityManagerFactory"
		 */
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		
		/**
		 * Dalej chcemy uzyskac obiekt klasy "EntityManager"
		 * 
		 * Entitymanager to nasz "most" pomiędzy bazą danych a naszą aplikacją
		 * 
		 * EntityManager - wazny obiekt z uzyciem ktorego dane zapisujemy do bazy danych, 
		 * wyszukujemy, wykonujemy jakies zapytania
		 */
		entityManager = entityManagerFactory.createEntityManager();
		
		
		/**
		 * Majac "EntityManager" mozemy wykonywac takie metody jak "persist()", która zapisuje cos do bazy danych
		 * createQuery()
		 * itd...
		 */
		
		Employee employee = new Employee();
		employee.setFirstName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(1111.11);
		employee.setLocality("Warszawa");
		employee.setZipCode("11-111");
		employee.setStreet("Koszykowa");
		employee.setStreetNumber(111);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		/**
		 * ZEBY PROGRAM DOBRZE SIE ZAKONCZYL ZAWSZE MUSIMY PAMIETAC O WYWOLANIU METODY "close()"
		 */
		entityManager.close();
		entityManagerFactory.close();
	}
	
	private static void addEmployeeToDatabase(String firstName, String lastName, 
			double salary, String locality, String zipCode, String steet, int streetNumber)
	{
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);
		employee.setLocality(locality);
		employee.setZipCode(zipCode);
		employee.setStreet(steet);
		employee.setStreetNumber(streetNumber);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}

}
