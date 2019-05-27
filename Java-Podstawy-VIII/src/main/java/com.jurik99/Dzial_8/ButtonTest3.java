package Dzial_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTest3
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
               ButtonFrame3 window3 = new ButtonFrame3();
            }
        });
    }
}

// --- RAMKA Z PANELEM ZAWIERAJACYM PRZYCISKI --- //
class ButtonFrame3 extends JFrame
{
    private JPanel buttonPanel_3;
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame3()
    {
        try
        {
            String className = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
            UIManager.setLookAndFeel(className);
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }

        setTitle("ButtonTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        buttonPanel_3 = new JPanel();
        add(buttonPanel_3);

        makeButton("Żółty", Color.YELLOW);
        makeButton("Niebieski", Color.BLUE);
        makeButton("Czerwony", Color.RED);
    }

    // METODA POMOCNICZA
    public void makeButton(String name, final Color backgroundColor)
    {
        JButton button = new JButton(name);
        buttonPanel_3.add(button);

        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                buttonPanel_3.setBackground(backgroundColor);
            }
        });
    }

    // METODA POMOCNICZA 2 (NA DOLE DODAWANY JEST ACTION.LISTENER DO BUTTON
    public void makeButton2(String name, final Color backgroundColor)
    {
        JButton button = new JButton(name);
        buttonPanel_3.add(button);

        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                buttonPanel_3.setBackground(backgroundColor);
            }
        };
        button.addActionListener(listener);
    }

}
