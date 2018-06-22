package SmallerScale.BeanDAOFactory.Model.MySQL;

import SmallerScale.BeanDAOFactory.Model.DAOFactory;
import SmallerScale.BeanDAOFactory.Model.LogDAOInterface;
import SmallerScale.BeanDAOFactory.Model.PersonDAOInterface;

public class MySQLDAOFactory extends DAOFactory
{
    @Override
    public PersonDAOInterface getPersonDAO()
    {
        return new MySQLPersonDAO();
    }

    @Override
    public LogDAOInterface getLogDAO()
    {
        return new MySQLLogDAO();
    }
}
