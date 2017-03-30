package SmallerScale.Singleton.View;

/**
 * This is a "BEAN" class
 *
 * BEAN is something that STORES SOME DATA and has SETTERS & GETTERS for that DATA
 *
 * In this case we call "LoginFormEvent" class because we are gonna use this BEAN to
 * transmit information about an event
 */
public class LoginFormEvent
{
    private String name, password;

    LoginFormEvent(String name, String password)
    {
        this.name = name;
        this.password = password;
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
}
