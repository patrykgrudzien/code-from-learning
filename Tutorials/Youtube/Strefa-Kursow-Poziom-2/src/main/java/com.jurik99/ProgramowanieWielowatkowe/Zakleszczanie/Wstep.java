package ProgramowanieWielowatkowe.Zakleszczanie;

public class Wstep
{
    /*
    W swiecie watkow wystepuje pewien szczegolny rodzaj bledu.
    ZAKLESZCZENIE = Blokada Wzajemna
    Owy blad wystepuje, gdy dwa dane watki sa zwiazane cykliczna zaleznoscia od pary
    synchronizowanych obiektow.

    Jeden z watkow wchodzi do monitora obiektu A a drugi watek wchodzi do monitora obiektu B.
    Jezeli w tej sytuacji watek znajdujacy sie w obiekcie A sprobuje wywolac jedna z
    synchronizowanych metod obiektu B to zostanie zablokowany a to dlatego, ze obiekt B jest
    przeciez zajety przez inny watek. Jezeli z kolei watek z obiektu B sprobuje wykonac ktoras z
    synchronizowanych metod obiektu A to bedzie musial czekac w nieskonczonosc, gdyz zeby dostac
    sie do obiektu A musialby sam wyjsc z monitora obiektu B.

    Program w ktorym wystapi zakleszczenie nigdy nie zakonczy swojego dzialania.
    */
}
