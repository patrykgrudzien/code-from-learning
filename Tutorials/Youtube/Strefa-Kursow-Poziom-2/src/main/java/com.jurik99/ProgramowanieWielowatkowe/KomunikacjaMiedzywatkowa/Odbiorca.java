package ProgramowanieWielowatkowe.KomunikacjaMiedzywatkowa;

public class Odbiorca implements Runnable
{
    Sortownia s;

    Odbiorca(Sortownia s)
    {
        this.s = s;
        new Thread(this, "Odbiorca").start();
    }

    public void run()
    {
        while (true)
        {
            s.odbierz();
        }
    }
}
