package Adnotacje;


public class User
{
    @DatabaseField(columnName = "imie")
    private String name;
    @DatabaseField(columnName = "identyfikator")
    private long ID;

}
