package PrzydatneKlasy;
import GrafikaAWT_Swing.Colorable;

public class PlytkieGlebokieKopiowanie implements Colorable
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
//        Punkt punkt1 = new Punkt(10, 10);
//        Punkt punkt2 = punkt1;
//        Punkt punkt3 = new Punkt(10, 10);
//
//        boolean porownanie1 = punkt1 == punkt2;
//        boolean porownanie2 = punkt1 == punkt3;
//
//        System.out.println("Porównanie 1: " + porownanie1);
//        System.out.println("Porównanie 2: " + porownanie2);
//        System.out.println();
//        wyswietl(punkt1, punkt2, punkt3);
//
//        punkt2.setX(11);    // zmieniła się również współrzędna X punktu 1
//        punkt3.setX(12);
//        wyswietl(punkt1, punkt2, punkt3);
//
//        /**
//         * !!! --- NA ZMIENNYCH TYPÓW PROSTYCH NIE OBOWIĄZUJE PRAWO KOPIOWANIA REFERENCJI --- !!!
//         */
//        int zmienna1 = 10;
//        int zmienna2 = zmienna1;
//        System.out.println("\nZmienna 1: " +zmienna1);
//        System.out.println("Zmienna 2: " +zmienna2);
//        zmienna1 = 30;
//        System.out.println("\nZmienna 1: " +zmienna1);
//        System.out.println("Zmienna 2: " +zmienna2);


        // Do KOPIOWANIA PŁYTKIEGO (shallow copy) obiektów wykorzystuje się metodę --> clone()
//        Punkt1 punkt1 = new Punkt1(10, 10);
//        Punkt1 punkt2 = (Punkt1) punkt1.clone();
//        Punkt1 punkt3 = new Punkt1(10, 10);
//
//        boolean porownanie1 = punkt1 == punkt2;
//        boolean porownanie2 = punkt1 == punkt3;
//
//        System.out.println("Porównanie 1: " + porownanie1);
//        System.out.println("Porównanie 2: " + porownanie2);
//        System.out.println();
//        wyswietl2(punkt1, punkt2, punkt3);
//
//        punkt2.setX(11);
//        punkt3.setX(12);
//        wyswietl2(punkt1, punkt2, punkt3);

        // PROBLEMY ZWIĄZANE Z KOPIOWANIEM PŁYTKIM OBIEKTÓW
//        System.out.println(RED + "PROBLEMY ZWIĄZANIE Z KOPIOWANIEM PŁYTKIM OBIEKTÓW:" + RESET);
//
//        Punkt1 p1 = new Punkt1(0, 0);
//        Punkt1 p2 = new Punkt1(10, 10);
//
//        Odcinek1 odcinek1 = new Odcinek1(p1, p2);
//        Odcinek1 odcinek2 = (Odcinek1) odcinek1.clone();
//
//        boolean porownanie = odcinek1 == odcinek2;
//        System.out.println("Porównanie: " + porownanie);
//
//        System.out.println("Odcinek1 xStart: " +odcinek1.getStart().getX());
//        System.out.println("Odcinek2 xStart: " +odcinek2.getStart().getX());
//
//        odcinek2.getStart().setX(20);
//        System.out.println("Odcinek1 xStart: " +odcinek1.getStart().getX());
//        System.out.println("Odcinek2 xStart: " +odcinek2.getStart().getX());

        // GŁĘBOKIE KOPIOWANIE OBIEKTÓW
        Punkt1 p1 = new Punkt1(0, 0);
        Punkt1 p2 = new Punkt1(10, 10);

        Odcinek2 odcinek1 = new Odcinek2(p1, p2);
        Odcinek2 odcinek2 = (Odcinek2) odcinek1.clone();

        boolean porownanie = odcinek1 == odcinek2;
        System.out.println("Porównanie: " + porownanie);

        System.out.println("Odcinek1 xStart: " +odcinek1.getStart().getX());
        System.out.println("Odcinek2 xStart: " +odcinek2.getStart().getX());

        odcinek2.getStart().setX(20);
        System.out.println("Odcinek1 xStart: " +odcinek1.getStart().getX());
        System.out.println("Odcinek2 xStart: " +odcinek2.getStart().getX());
    }



    public static void wyswietl(Punkt... punkty)
    {
        int size = punkty.length;
        for (int i = 0; i < size; i++)
        {
            System.out.println("Punkt " + i + " x:" + punkty[i].getX() + " ; y:" + punkty[i].getY());
        }
        System.out.println();
    }

    public static void wyswietl2(Punkt1... punkty)
    {
        int size = punkty.length;
        for (int i = 0; i < size; i++)
        {
            System.out.println("Punkt " + i + " x:" + punkty[i].getX() + " ; y:" + punkty[i].getY());
        }
        System.out.println();
    }
}

// Klasa bez metody --> clone()
class Punkt
{
    private int x, y;

    public Punkt(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }
}

// Klasa bez metody --> clone()
class Odcinek
{
    private Punkt start;
    private Punkt koniec;

    public Odcinek(Punkt start, Punkt koniec)
    {
        this.start = start;
        this.koniec = koniec;
    }

    public Punkt getStart()
    {
        return start;
    }

    public void setStart(Punkt start)
    {
        this.start = start;
    }

    public Punkt getKoniec()
    {
        return koniec;
    }

    public void setKoniec(Punkt koniec)
    {
        this.koniec = koniec;
    }
}

// Klonowanie PŁYTKIE
class Punkt1 implements Cloneable
{
    private int x, y;

    public Punkt1(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    /**
     * Problemem metody clone() jest fakt, że domyślnie ma ona zasięg
     * pakietowy (protected), co w niektórych sytuacjach czyni ją bezużyteczną.
     * Warto przesłonić ją więc jako metodę publiczną i dać do niej
     * dostęp z każdego miejsca aplikacji
     */
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}

// Klonowanie PŁYTKIE
class Odcinek1 implements Cloneable
{
    private Punkt1 start;
    private Punkt1 koniec;

    public Odcinek1(Punkt1 start, Punkt1 koniec)
    {
        this.start = start;
        this.koniec = koniec;
    }

    public Punkt1 getStart()
    {
        return start;
    }

    public void setStart(Punkt1 start)
    {
        this.start = start;
    }

    public Punkt1 getKoniec()
    {
        return koniec;
    }

    public void setKoniec(Punkt1 koniec)
    {
        this.koniec = koniec;
    }

    /**
     * Problemem metody clone() jest fakt, że domyślnie ma ona zasięg
     * pakietowy (protected), co w niektórych sytuacjach czyni ją bezużyteczną.
     * Warto przesłonić ją więc jako metodę publiczną i dać do niej
     * dostęp z każdego miejsca aplikacji
     */
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}

// Klonowanie GŁĘBOKIE
class Odcinek2 implements Cloneable
{
    private Punkt1 start;
    private Punkt1 koniec;

    public Odcinek2()
    {
        this(new Punkt1(0, 0), new Punkt1(0, 0));
    }

    public Odcinek2(Punkt1 start, Punkt1 koniec)
    {
        this.start = start;
        this.koniec = koniec;
    }

    public Punkt1 getStart()
    {
        return start;
    }

    public void setStart(Punkt1 start)
    {
        this.start = start;
    }

    public Punkt1 getKoniec()
    {
        return koniec;
    }

    public void setKoniec(Punkt1 koniec)
    {
        this.koniec = koniec;
    }

    /**
     * Problemem metody clone() jest fakt, że domyślnie ma ona zasięg
     * pakietowy (protected), co w niektórych sytuacjach czyni ją bezużyteczną.
     * Warto przesłonić ją więc jako metodę publiczną i dać do niej
     * dostęp z każdego miejsca aplikacji
     */
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        Odcinek2 odcinek2 = new Odcinek2();
        Punkt1 pStart = (Punkt1) this.getStart().clone();
        Punkt1 pKoniec = (Punkt1) this.getKoniec().clone();
        odcinek2.setStart(pStart);
        odcinek2.setKoniec(pKoniec);

        return odcinek2;
    }
}