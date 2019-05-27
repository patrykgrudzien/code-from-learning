package ProgramowanieWielowatkowe.KomunikacjaMiedzywatkowa;

public class Demo
{
    public static void main(String[] args)
    {
        Sortownia s = new Sortownia();
        new Nadawca(s);
        new Odbiorca(s);
    }
}
