package SmallerScale.BeanDAOFactory.Model;

/**
 * Class which creates TRANSFER OBJECT.
 *
 * This "TRANSFER OBJECT" contains data which we wanna deal with this particular TABLE.
 *
 * And this is a "BEAN". It has NON ARGUMENT CONSTRUCTOR.
 *
 * It is used for TRANSFERING data from one place to another
 */
public class Person
{
    private int id;
    private String name, password;

    public Person()
    {

    }

    public Person(String name, String password)
    {
        setName(name);
        setPassword(password);
    }

    public Person(int id, String name, String password)
    {
        setId(id);
        setName(name);
        setPassword(password);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return password != null ? password.equals(person.password) : person.password == null;

    }

    @Override
    public int hashCode()
    {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
