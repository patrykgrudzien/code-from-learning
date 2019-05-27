package PrzydatneKlasy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KlasyOsłonowe
{
    public static void main(String[] args) throws IOException, NumberFormatException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//        System.out.println("Podaj imię:");
//        String imie = bufferedReader.readLine();
//        System.out.println("Cześć " + imie);
//
//        System.out.println("Podaj wiek:");
//        int wiek = Integer.parseInt(bufferedReader.readLine());
//        System.out.println("Masz " + wiek + " lata");

        System.out.println("Podaj cyfrę od 0 do 9:");
        String str = bufferedReader.readLine();

        int liczba = 0;
        if (str.length() == 1 && Character.isDigit(str.charAt(0)))
        {
            System.out.println("Hurra! Podałeś liczbę!");
            liczba = Integer.parseInt(str);
            System.out.print("Liczba: " + liczba);
        }
        else
        {
            System.out.println("Niestety ale nie podałeś liczby.");
        }
    }
}
