package ProgramowanieWielowatkowe.KomunikacjaMiedzywatkowa;

public class Nadawca implements Runnable
{
    Sortownia s;

    Nadawca(Sortownia s)
    {
        this.s = s;
        new Thread(this, "Nadawca").start();
    }

    public void run()
    {
        int i = 0;
        while (true)
        {
            s.nadaj(i++);
        }
    }
}
