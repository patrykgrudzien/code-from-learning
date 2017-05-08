package SmallerScale.BeanDAOFactory.Model.Oracle;

import SmallerScale.BeanDAOFactory.Model.Log;
import SmallerScale.BeanDAOFactory.Model.LogDAOInterface;

import java.util.List;

public class OracleLogDAO implements LogDAOInterface
{
    @Override
    public void addEntry(final String message)
    {

    }

    @Override
    public List<Log> getEntries(final int number)
    {
        return null;
    }
}
