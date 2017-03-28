package Prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable
{
    /**
     * Prototype design pattern is used when the Object creation is a costly affair and requires a lot of time and resources and
     * you have a similar object already existing.
     * <p>
     * Prototype pattern provides a mechanism to copy the original object to a new object and then modify it according to our
     * needs. Prototype design pattern uses java cloning to copy the object.
     */
    private List<String> empList;

    public Employees()
    {
        empList = new ArrayList<>();
    }

    public Employees(final List<String> list)
    {
        this.empList = list;
    }

    public List<String> getEmpList()
    {
        return empList;
    }

    public void loadData()
    {
        empList.add("Pankaj");
        empList.add("Raj");
        empList.add("David");
        empList.add("Lisa");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        List<String> temp = new ArrayList<>();
        for (String s : this.getEmpList())
        {
            temp.add(s);
        }
        return new Employees(temp);
    }
}
