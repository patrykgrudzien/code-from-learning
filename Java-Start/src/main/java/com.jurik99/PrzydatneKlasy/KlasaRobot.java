package PrzydatneKlasy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class KlasaRobot
{
    private Robot robot;

    public KlasaRobot()
    {
        try
        {
            robot = new Robot();
        }
        catch (AWTException e)
        {
            System.err.println("Co ten robot wyprawia?!");
            e.printStackTrace();
        }
    }

    /**
     * Metoda drukuje tekst "Hello World"
     */
    public void printText()
    {
        int[] text = {KeyEvent.VK_H, KeyEvent.VK_E, KeyEvent.VK_L, KeyEvent.VK_L, KeyEvent.VK_O, KeyEvent.VK_SPACE,
                KeyEvent.VK_W, KeyEvent.VK_O, KeyEvent.VK_R, KeyEvent.VK_L, KeyEvent.VK_D};

        // Pętla - wciśnięcie przycisku i przerwa na 200ms
        for (int i = 0; i < text.length; i++)
        {
            robot.keyPress(text[i]);
            robot.delay(100);
        }
    }

    /**
     * Metoda robi screenshot ekranu i zapisuje go na dysku
     */
    public void screenCapture()
    {
        // Pobieramy rozmiar ekranu i tworzymy Rectangle
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(dimension);

        // Robimy screenshot z utworzonego obszaru
        BufferedImage screen = robot.createScreenCapture(rectangle);

        try
        {
            ImageIO.write(screen, "png", new File("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\" +
                    "JavaStart.pl\\src\\PrzydatneKlasy\\screenshot.png"));
        }
        catch (IOException e)
        {
            System.err.println("Błąd zapisu obrazu");
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        /**
         * Najciekawsze metody, które znajdziemy w klasie Robot to:
         *
         * 1. keyPress(int keycode), keyRelease(int keycode) - wciśnięcie/zwolnienie
         * klawisza na klawiaturze. Niestety minus jest taki, że keycode nie
         * odpowiada wartości ASCII danego znaku trzeba się posługiwać wartościami
         * stałych zdefiniowanych w klasie KeyEvent
         *
         * 2. mousePress(int buttons), mouseRelease(int buttons) - wciśnięcie/zwolnienie
         * przycisków myszy - jako argumenty podajemy stałe zdefiniowane w
         * klasie InputEvent (BUTTON1_MASK, BUTTON2_MASK, BUTTON3_MASK)
         *
         * 3. mouseMove(int x, int y) - przesunięcie kursora we wskazany punkt ekranu
         *
         * 4. createScreenCapture(Rectangle screenRect) - zrobienie screenshota ekranu w wybranym obszarze
         *
         * 5. delay(int time) - wstrzymanie wykonywanego wątku na czas podany jako argument (w milisekundach)
         */

        KlasaRobot test = new KlasaRobot();
        test.robot.delay(5000);
        test.printText();
        test.screenCapture();

    }
}
