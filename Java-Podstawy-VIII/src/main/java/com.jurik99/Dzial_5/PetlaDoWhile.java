package Dzial_5;

import java.util.Scanner;

public class PetlaDoWhile
{
    @SuppressWarnings("resource")
    public static void main(String[] args)
    {
		/* goal - (cel) ilosc pieniedzy, ktore bedziemy potrzebowac aby przejsc na emeryture
		 * payment - (wplata, wyplata) ilosc pieniedzy, ktore rocznie bedziemy wplacac
		 * interestRate - (stopa procentowa)
		 * balance - (bilans)
		 * years - lata
		 * interest - (odsetki)
		 */
        Scanner input = new Scanner(System.in);

        System.out.println("Ile pieniedzy bedziesz rocznie wplacal? ");
        double payment = input.nextDouble();

        System.out.println("Stopa procentowa w %: ");
        double interesRate = input.nextDouble();

        // Definicja licznikow
        double balance = 0;
        int year = 0;
        // Wprowadzamy takze zmienna String
        String in;

        // Petle ta stosujemy kiedy chcemy miec pewnosc, ze instrukcje zostana wykonane co najmniej raz
        do
        {
            balance += payment;
            double interest = balance * interesRate / 100;
            balance += interest;
            year++;

            // Drukowanie aktualnego stanu konta
            System.out.printf("Po uplywie %d lat/roku stan Twojego konta wyniesie %,.2f", year, balance);

            // Zapytanie o gotowosc przejscia na emeryture i pobranie danych
            System.out.print("\nCzy chcesz przejsc na emeryture? (T/N) ");
            in = input.next();	// (next) a nie (nextLine)
        }
        while(in.equals("N")); 	// jezeli z klawiatury wprowadzimy "T" to petla sie zakonczy. Jezeli wprowadzimy "N" to petla bedzie dzialac dalej.
    }
}