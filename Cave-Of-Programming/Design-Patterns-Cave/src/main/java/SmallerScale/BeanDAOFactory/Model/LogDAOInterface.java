package SmallerScale.BeanDAOFactory.Model;

import java.util.List;

public interface LogDAOInterface
{
    void addEntry(String message);
    List<Log> getEntries(int number);
}
