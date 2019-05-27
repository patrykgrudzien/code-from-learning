package ProgramowanieWielowatkowe.Zakleszczanie;

public class B
{
    synchronized void jeden(A a)
    {
        String name = Thread.currentThread().getName();
        System.out.println(name + " wszedł do B.jeden");

        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Przerwano B");
        }
        System.out.println(name + " próbuje wywołać A.dwa()");
        a.dwa();
    }

    synchronized void dwa()
    {
        System.out.println("Wewnętrz B.dwa");
    }
}
