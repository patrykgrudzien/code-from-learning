package ProgramowanieWielowatkowe.Zakleszczanie;

public class C implements Runnable
{
    A a = new A();
    B b = new B();

    C()
    {
        Thread.currentThread().setName("Wątek główny");
        Thread t = new Thread(this, "Wątek dodatkowy");
        t.start();

        a.jeden(b);
        System.out.println("Powrót do wątku głównego");
    }

    @Override
    public void run()
    {
        b.jeden(a);
        System.out.println("Powrót do wątku głównego");
    }

    public static void main(String[] args)
    {
        new C();
    }
}
