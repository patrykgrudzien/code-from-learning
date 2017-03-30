package SmallerScale.BeanDAOFactory.Model.Oracle;

import SmallerScale.BeanDAOFactory.Model.Log;
import SmallerScale.BeanDAOFactory.Model.LogDAOInterface;

import java.util.List;

public class OracleLogDAO implements LogDAOInterface
{
    @Override
    public void addEntry(String message)
    {

    }

    @Override
    public List<Log> getEntries(int number)
    {
        return null;
    }
}
