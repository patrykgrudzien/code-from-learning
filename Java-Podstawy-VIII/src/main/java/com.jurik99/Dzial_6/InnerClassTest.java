package Dzial_6;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InnerClassTest
{
    public static void main(String[] args)
    {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Zamknąć program?");
        System.exit(0);
    }
}

//--------------------
class TalkingClock
{
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep)
    {
        this.interval = interval;
        this.beep = beep;
    }

    public void start()
    {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();

    }

    //--------------------
    private class TimePrinter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Date now = new Date();
            System.out.println("Kiedy usłyszysz dźwięk, będzie godzina: " +String.format("%tc", now));
            if (beep)   Toolkit.getDefaultToolkit().beep();
        }
    }

}
