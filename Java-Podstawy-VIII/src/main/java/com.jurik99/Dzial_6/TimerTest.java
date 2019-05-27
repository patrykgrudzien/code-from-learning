package Dzial_6;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerTest
{
    public static void main(String[] args)
    {
        ActionListener object = new TimePrinter();

        // Konstruktcja zegara wywolujaca obiekt nasluchujacy co 2 sekundy
        Timer t = new Timer(1000, object);
        t.start();

        JOptionPane.showMessageDialog(null, "Zamknąć program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        Date now = new Date();
        System.out.println("Kiedy uslyszysz dzwiek, bedzie godzina: " +String.format("%tc", now));
        Toolkit.getDefaultToolkit().beep();
    }
}
