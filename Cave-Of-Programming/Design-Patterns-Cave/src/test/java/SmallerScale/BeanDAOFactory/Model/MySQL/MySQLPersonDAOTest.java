package SmallerScale.BeanDAOFactory.Model.MySQL;

import static org.junit.Assert.assertEquals;

import SmallerScale.BeanDAOFactory.Model.DAOFactory;
import SmallerScale.BeanDAOFactory.Model.Database;
import SmallerScale.BeanDAOFactory.Model.Person;
import SmallerScale.BeanDAOFactory.Model.PersonDAOInterface;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

@Ignore
public class MySQLPersonDAOTest
{
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		Database.getInstance().connect();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		Database.getInstance().disconnect();
	}

	@Before
	public void setUp() throws Exception
	{
//        System.out.println("setUp");

		final DAOFactory factory = DAOFactory.getFactory(DAOFactory.MYSQL);
		final PersonDAOInterface mySQLPersonDAO = factory.getPersonDAO();

		mySQLPersonDAO.deleteAll();
	}

	@After
	public void tearDown() throws Exception
	{
//        System.out.println("tearDown");
	}

	// ============================================================================================================== //
	@Test
	public void testDemo()
	{
		int value = 7;
		value += 2;

		System.out.println("testDemo() passed.");

		assertEquals("Values are different!!!", 9, value);
	}

	@Test
	public void testCreate() throws SQLException
	{
		final DAOFactory factory = DAOFactory.getFactory(DAOFactory.MYSQL);
		final PersonDAOInterface mySQLPersonDAO = factory.getPersonDAO();

		final Person person1 = new Person("Bob", "password");
		final Person person2 = new Person("Sue", "hello");

		mySQLPersonDAO.addPerson(person1);
		mySQLPersonDAO.addPerson(person2);

		final List<Person> people = mySQLPersonDAO.getPeople();

		assertEquals("Should be two people in database.", 2, people.size());
		assertEquals("These 2 people should be the same.", person1, people.get(0));
		assertEquals("These 2 people should be the same.", person2, people.get(1));
	}
}