package SmallerScale.BeanDAOFactory.Model;

import java.sql.SQLException;
import java.util.List;

public interface PersonDAOInterface {

	int addPerson(Person person) throws SQLException;

	Person getPerson(int id) throws SQLException;

	List<Person> getPeople() throws SQLException;

	int updatePerson(Person person) throws SQLException;

	int deletePerson(int id) throws SQLException;

	int deleteAll() throws SQLException;
}
