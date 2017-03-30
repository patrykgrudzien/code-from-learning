package SmallerScale.BeanDAOFactory.Model.Oracle;

import SmallerScale.BeanDAOFactory.Model.Person;
import SmallerScale.BeanDAOFactory.Model.PersonDAOInterface;

import java.sql.SQLException;
import java.util.List;

public class OraclePersonDAO implements PersonDAOInterface
{
    @Override
    public int addPerson(Person person) throws SQLException
    {
        return 0;
    }

    @Override
    public Person getPerson(int id) throws SQLException
    {
        return null;
    }

    @Override
    public List<Person> getPeople() throws SQLException
    {
        return null;
    }

    @Override
    public int updatePerson(Person person) throws SQLException
    {
        return 0;
    }

    @Override
    public int deletePerson(int id) throws SQLException
    {
        return 0;
    }

    @Override
    public int deleteAll() throws SQLException
    {
        return 0;
    }
}
