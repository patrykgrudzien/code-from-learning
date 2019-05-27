package info.grudzien.patryk.jpa;

import info.grudzien.patryk.jpa.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main
{
	// =================================================================================================================== //
	private static final String PERSISTENCE_UNIT_NAME = "myDatabase";
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
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
		
		
		Employee employee1 = new Employee();
		employee1.setFirstName("Violetta 2");
		employee1.setLastName("Grudzień 2");
		employee1.setSalary(6000);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee1);
		entityManager.getTransaction().commit();
//		
//		System.out.println("First name: " +employee1.getFirstName());
//		System.out.println("Last name: " +employee1.getLastName());
//		System.out.println("Salary: " +employee1.getSalary());
//		System.out.println("Tax: " +employee1.getTax());
//		
//		entityManager.refresh(employee1);
//		
//		System.out.println("First name: " +employee1.getFirstName());
//		System.out.println("Last name: " +employee1.getLastName());
//		System.out.println("Salary: " +employee1.getSalary());
//		System.out.println("Tax: " +employee1.getTax());
		
		entityManager.close();
		entityManagerFactory.close();
		
	}
	
}
