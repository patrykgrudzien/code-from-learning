package Dzial_10;

/**
 * Niniejszy kod HTML jest potrzebny do wyświetlenia tego apletu w oknie przeglądarki:
 * <aplet code="NotHelloWorldApplet.class" width="300" height="300">
 * </aplet>
 */

import javax.swing.*;
import java.awt.*;

public class NotHelloWorldApplet extends JApplet
{
    @Override
    public void init()
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JLabel label = new JLabel("To nie jest aplet Witaj Świecie", SwingConstants.CENTER);
                add(label);
            }
        });
    }
}
