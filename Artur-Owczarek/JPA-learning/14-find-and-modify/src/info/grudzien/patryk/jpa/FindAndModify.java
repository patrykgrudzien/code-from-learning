package info.grudzien.patryk.jpa;

import info.grudzien.patryk.jpa.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindAndModify
{
	// =================================================================================================================== //
	private static final String PERSISTENCE_UNIT_NAME = "myDatabase";

	public static void main(String[] args)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Employee employee = entityManager.find(Employee.class, 1L);
		System.out.println("First name: " +employee.getFirstName());
		System.out.println("Last name: " +employee.getLastName());
		System.out.println("Salary: " +employee.getSalary());
		
		employee.setSalary(50000);
		
		entityManager.getTransaction().commit();
		
		System.out.println("First name: " +employee.getFirstName());
		System.out.println("Last name: " +employee.getLastName());
		System.out.println("Salary: " +employee.getSalary());
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
