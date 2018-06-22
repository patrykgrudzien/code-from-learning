package SmallerScale.BeanDAOFactory.Controller;

import SmallerScale.BeanDAOFactory.Model.DAOFactory;
import SmallerScale.BeanDAOFactory.Model.Model;
import SmallerScale.BeanDAOFactory.Model.Person;
import SmallerScale.BeanDAOFactory.Model.PersonDAOInterface;
import SmallerScale.BeanDAOFactory.View.CreateUserEvent;
import SmallerScale.BeanDAOFactory.View.CreateUserListener;
import SmallerScale.BeanDAOFactory.View.View;

import java.sql.SQLException;

public class Controller implements CreateUserListener
{
    private Model model;
    private View view;

    public Controller(final Model model, final View view)
    {
        this.model = model;
        this.view = view;
    }

    @Override
    public void loginPerformed(final CreateUserEvent event)
    {
        System.out.println("Login event received. " + event.getName() + ": " + event.getPassword());

        final String name = event.getName();
        final String password = event.getPassword();

        final DAOFactory factory = DAOFactory.getFactory(DAOFactory.MYSQL);
        assert factory != null;
        final PersonDAOInterface mySQLPersonDAO = factory.getPersonDAO();

        if (name != null && password != null)
        {
            try
            {
                mySQLPersonDAO.addPerson(new Person(name, password));
            }
            catch (final SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
