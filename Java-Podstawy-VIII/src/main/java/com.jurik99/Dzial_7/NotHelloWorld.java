package Dzial_7;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class NotHelloWorld
{
    public static void main(String[] args)
    {
//        NotHelloWorldFrame frame = new NotHelloWorldFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//        frame.setResizable(false);

        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                NotHelloWorldFrame frame = new NotHelloWorldFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });

    }
}

// --- Ramka zawierajaca panel z komunikatem --- //
class NotHelloWorldFrame extends JFrame
{
    public NotHelloWorldFrame()
    {
        setTitle("NotHelloWorld");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // Dodanie panelu do ramki
        NotHelloWorldPanel panel = new NotHelloWorldPanel();
        add(panel);
    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
}

// --- Panel wyswietlajacy komunikat --- //
class NotHelloWorldPanel extends JComponent
{
    public void paintComponent(Graphics g)
    {
        g.setFont(sansbold14);
        g.drawString("To nie jest program \"Witaj świecie!\"", MESSAGE_X, MESSAGE_Y);
    }
    Font sansbold14 = new Font("SansSerif", Font.BOLD + Font.ITALIC, 14);
    public static final int MESSAGE_X = 25;
    public static final int MESSAGE_Y = 90;
}
