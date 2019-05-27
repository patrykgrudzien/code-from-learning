package info.grudzien.patryk.jpa;

import java.math.BigDecimal;

import info.grudzien.patryk.jpa.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main
{
	// =================================================================================================================== //
	private static final String PERSISTENCE_UNIT_NAME = "myDatabase";
	
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
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		/**
		 * Majac "EntityManager" mozemy wykonywac takie metody jak "persist()", która zapisuje cos do bazy danych
		 * createQuery()
		 * itd...
		 */
		
		// ---------- TWORZYMY PRACOWINKA, KTOREGO ZAPISZEMY W BAZIE DANYCH ---------- //
		Employee employee = new Employee();
//		employee.setId(1);
		employee.setFirstName("Jan");
		employee.setLastName("Kowalski");
		employee.setSalary(3333.33);
		employee.setSalary2(new BigDecimal(12345.3));
		
		Employee employee2 = new Employee();
		employee2.setFirstName("Kuba");
		employee2.setLastName("Nowak");
		employee2.setSalary(5555.55);
		
		
		// ---------- Do zapisywania obiektu w bazie danych wykorzystujemy metodę "persist()" z EntityManager ---------- //
		/**
		 * Wszystko byloby fajnie, gdyby nie to ze wszelkie operacje wstawiajace cos do bazy danych musza byc wykonywane w ramach
		 * TRANSAKCJI !!!
		 * Czyli przed samym zapisaniem goscia do bazy danych, musimy:
		 * 1) z EntityManager pobrac transakcje
		 * 2) Rozpocząć ją
		 * 3) A po zapisaniu zakończyć
		 */
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(employee2);
		entityManager.getTransaction().commit();
		
		
		/**
		 * ZEBY PROGRAM DOBRZE SIE ZAKONCZYL ZAWSZE MUSIMY PAMIETAC O WYWOLANIU METODY "close()"
		 */
		entityManager.close();
		entityManagerFactory.close();
	}

}
