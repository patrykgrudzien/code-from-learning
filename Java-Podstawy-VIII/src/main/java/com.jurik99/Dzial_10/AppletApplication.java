package Dzial_10;

import javax.swing.*;
import java.awt.*;

public class AppletApplication extends NotHelloWorldApplet
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                AppletFrame frame = new AppletFrame(new NotHelloWorldApplet());
                frame.setTitle("NotHelloWorldApplet");
                frame.setSize(300, 200);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
