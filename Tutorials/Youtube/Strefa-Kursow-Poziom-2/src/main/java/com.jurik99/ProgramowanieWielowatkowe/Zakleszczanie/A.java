package ProgramowanieWielowatkowe.Zakleszczanie;

public class A
{
    synchronized void jeden(B b)
    {
        String name = Thread.currentThread().getName();
        System.out.println(name + " wszedł do A.jeden");

        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Przerwano A");
        }
        System.out.println(name + " próbuje wywołać B.dwa()");
        b.dwa();
    }

    synchronized void dwa()
    {
        System.out.println("Wewnętrz A.dwa");
    }
}
