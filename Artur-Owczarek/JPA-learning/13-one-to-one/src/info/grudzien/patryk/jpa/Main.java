package info.grudzien.patryk.jpa;

import info.grudzien.patryk.jpa.domain.Address;
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
		
		Employee employee = new Employee();
		Address address = new Address();
		employee.setFirstName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(1111.11);
		employee.setAddress(address);
		address.setLocality("Warszawa");
		address.setStreetName("Fabryczna");
		address.setZipCode("27-420");
		address.setStreetNumber(123);
		
		/**
		 * Majac "EntityManager" mozemy wykonywac takie metody jak "persist()", która zapisuje cos do bazy danych
		 * createQuery()
		 * itd...
		 */
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(address);
		entityManager.getTransaction().commit();
		
		/**
		 * ZEBY PROGRAM DOBRZE SIE ZAKONCZYL ZAWSZE MUSIMY PAMIETAC O WYWOLANIU METODY "close()"
		 */
		entityManager.close();
		entityManagerFactory.close();
	}

}
