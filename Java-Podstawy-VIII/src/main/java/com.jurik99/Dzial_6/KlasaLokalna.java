package Dzial_6;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class KlasaLokalna
{
    public static void main(String[] args)
    {
        TalkingClock2 clock = new TalkingClock2();
        clock.start(1000, true);

        JOptionPane.showMessageDialog(null, "Zamknąć program?");
        System.exit(0);
    }
}

class TalkingClock2
{
    // --- Klasa nie musi zawierac PÓL interval i beep, poniewaz parametry metody START sa FINAL a wewnątrz jej jest klasa PrintWriter --- //

    public void start(int interval2, final boolean beep)
    {
        // --- Nie stosuje sie tutaj PUBLIC / PRIVATE --- //
        class TimePrinter implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                Date now = new Date();
                System.out.println("Kiedy usłyszysz dźwięk, będzie godzina: " +String.format("%tc", now));
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }

        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval2, listener);
        t.start();
    }

}
