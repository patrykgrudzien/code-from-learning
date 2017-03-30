package SmallerScale.BeanDAOFactory.Model.MySQL;

import SmallerScale.BeanDAOFactory.Model.Log;
import SmallerScale.BeanDAOFactory.Model.LogDAOInterface;

import java.util.List;

public class MySQLLogDAO implements LogDAOInterface
{
    @Override
    public void addEntry(String message)
    {
        /**
         * Get current time and log message to database
         */
    }

    @Override
    public List<Log> getEntries(int number)
    {
        /**
         * Get latest "number" log messages
         */
        return null;
    }
}
