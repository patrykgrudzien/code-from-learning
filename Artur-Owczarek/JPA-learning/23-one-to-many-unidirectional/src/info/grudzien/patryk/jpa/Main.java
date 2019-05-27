package info.grudzien.patryk.jpa;

import info.grudzien.patryk.jpa.domain.Employee;
import info.grudzien.patryk.jpa.domain.Phone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

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
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();
		
		employee.setFirstName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(1234.123);
		
		phone1.setType("Mobile");
		phone1.setNumer("21353465536");
		
		phone2.setType("Home");
		phone2.setNumer("778654325");
		
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(phone1);
		phones.add(phone2);
		
		employee.setPhones(phones);
		
		/**
		 * Majac "EntityManager" mozemy wykonywac takie metody jak "persist()", która zapisuje cos do bazy danych
		 * createQuery()
		 * itd...
		 */
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(phone1);
		entityManager.persist(phone2);
		entityManager.getTransaction().commit();
		
		/**
		 * ZEBY PROGRAM DOBRZE SIE ZAKONCZYL ZAWSZE MUSIMY PAMIETAC O WYWOLANIU METODY "close()"
		 */
		entityManager.close();
		entityManagerFactory.close();
	}

}
