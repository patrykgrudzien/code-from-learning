package Dzial_10;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class ResourceTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                ResourceTestFrame frame = new ResourceTestFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * Ramka ładująca zasoby
 */
class ResourceTestFrame extends JFrame
{
    public ResourceTestFrame()
    {
        setTitle("Resource Test");
        setSize(300, 300);
        setLocationRelativeTo(null);

        URL iconURL = getClass().getResource("about.gif");
        Image img = Toolkit.getDefaultToolkit().getImage(iconURL);
        setIconImage(img);

        JTextArea textArea = new JTextArea();
        InputStream stream = getClass().getResourceAsStream("about.txt");
        Scanner in = new Scanner(stream);
        while (in.hasNext())
        {
            textArea.append(in.nextLine() + "\n");
        }
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
    }
}
