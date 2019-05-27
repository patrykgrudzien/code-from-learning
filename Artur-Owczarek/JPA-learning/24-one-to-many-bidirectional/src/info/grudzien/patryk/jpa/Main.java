package info.grudzien.patryk.jpa;

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
		
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		
		/**
		 * ZEBY PROGRAM DOBRZE SIE ZAKONCZYL ZAWSZE MUSIMY PAMIETAC O WYWOLANIU METODY "close()"
		 */
		entityManager.close();
		entityManagerFactory.close();
	}

}
