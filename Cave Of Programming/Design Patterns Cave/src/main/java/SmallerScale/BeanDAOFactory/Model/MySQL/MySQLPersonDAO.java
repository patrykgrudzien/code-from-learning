package SmallerScale.BeanDAOFactory.Model.MySQL;

import SmallerScale.BeanDAOFactory.Model.Database;
import SmallerScale.BeanDAOFactory.Model.Person;
import SmallerScale.BeanDAOFactory.Model.PersonDAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * One DAO class PER TABLE OR VIEW
 * <p>
 * One Entity - One DAO object (which deals with database)
 * <p>
 * CRUD - Create, Retrieve, Update, Delete
 * <p>
 * PersonDAO deals with PEOPLE table
 */
public class MySQLPersonDAO implements PersonDAOInterface
{
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String PASSWORD_COLUMN = "password";
    private Connection connection = Database.getInstance().getConnection();

    // ========================================================================================== //
    @Override
    public int addPerson(final Person person) throws SQLException
    {
        connection = Database.getInstance().getConnection();
        final PreparedStatement addStatement = connection.prepareStatement("insert into people (name, password) values (?,?)");
        addStatement.setString(1, person.getName());
        addStatement.setString(2, person.getPassword());

        final int updated = addStatement.executeUpdate();
        addStatement.close();

        return updated;
    }

    // ========================================================================================== //
    @Override
    public Person getPerson(final int id) throws SQLException
    {
        final String sql = "select id, name, password from people where id=? order by id";
        final PreparedStatement getPersonStatement = connection.prepareStatement(sql);

        getPersonStatement.setInt(1, id);
        final ResultSet results = getPersonStatement.executeQuery();

        Person person = null;

        while (results.next())
        {
            final String name = results.getString(NAME_COLUMN);
            final String password = results.getString(PASSWORD_COLUMN);

            person = new Person(id, name, password);
        }

        results.close();
        getPersonStatement.close();

        return person;
    }

    // ========================================================================================== //
    @Override
    public List<Person> getPeople() throws SQLException
    {
        final List<Person> people = new ArrayList<>();

        final String sql = "select id, name, password from people order by id";
        final Statement getPeopleStatement = connection.createStatement();
        final ResultSet results = getPeopleStatement.executeQuery(sql);

        while (results.next())
        {
            final int id = results.getInt(ID_COLUMN);
            final String name = results.getString(NAME_COLUMN);
            final String password = results.getString(PASSWORD_COLUMN);

            final Person person = new Person(id, name, password);
            people.add(person);
        }

        results.close();
        getPeopleStatement.close();

        return people;
    }

    // ========================================================================================== //
    @Override
    public int updatePerson(final Person person) throws SQLException
    {
        final PreparedStatement updateStatement = connection.prepareStatement("update people set name=?, password=? where id=?");

        updateStatement.setString(1, person.getName());
        updateStatement.setString(2, person.getPassword());
        updateStatement.setInt(3, person.getId());

        final int updated = updateStatement.executeUpdate();
        updateStatement.close();

        return updated;
    }

    // ========================================================================================== //
    @Override
    public int deletePerson(final int id) throws SQLException
    {
        final PreparedStatement deleteStatement = connection.prepareStatement("delete from people where id=?");
        deleteStatement.setInt(1, id);

        final int deleted = deleteStatement.executeUpdate();
        deleteStatement.close();

        return deleted;
    }

    // ========================================================================================== //
    @Override
    public int deleteAll() throws SQLException
    {
        final PreparedStatement deleteAllStatement = connection.prepareStatement("delete from people");

        final int deletedAll = deleteAllStatement.executeUpdate();
        deleteAllStatement.close();

        return deletedAll;
    }
}
