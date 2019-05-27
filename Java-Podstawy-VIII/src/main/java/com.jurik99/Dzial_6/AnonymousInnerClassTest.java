package Dzial_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AnonymousInnerClassTest
{
    public static void main(String[] args)
    {
        TalkingClock3 clock3 = new TalkingClock3();
        clock3.start(1000, true);

        JOptionPane.showMessageDialog(null, "Zamknąć program?");
        System.exit(0);
    }
}

// -----------------------------------------
class TalkingClock3
{
    public void start(int interval, final boolean beep)
    {
        // --- Nie musimy nazywac LOKALNEJ KLASY WEWNETRZNEJ --- //
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Date now = new Date();
                System.out.println("Kiedy usłyszysz dźwięk, będziee godzina: " +String.format("%tc", now));
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(interval,listener);
        t.start();
    }
}
