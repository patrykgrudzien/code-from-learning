package SmallerScale.BeanDAOFactory.Model.Oracle;

import SmallerScale.BeanDAOFactory.Model.DAOFactory;
import SmallerScale.BeanDAOFactory.Model.LogDAOInterface;
import SmallerScale.BeanDAOFactory.Model.PersonDAOInterface;

public class OracleDAOFactory extends DAOFactory
{
    @Override
    public PersonDAOInterface getPersonDAO()
    {
        return new OraclePersonDAO();
    }

    @Override
    public LogDAOInterface getLogDAO()
    {
        return new OracleLogDAO();
    }
}
