package Dzial_9;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorderLayout
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                BorderLayoutFrame window = new BorderLayoutFrame();
            }
        });
    }
}

// --- RAMKA Z PANELEM ZAWIERAJACYM PRZYCISKI --- //
class BorderLayoutFrame extends JFrame
{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 200;

    public BorderLayoutFrame()
    {
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
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

        // TWORZENIE PRZYCISKOW
        JButton yellowButton = new JButton("Zółty");
        JButton blueButton = new JButton("Niebieski");
        JButton redButton = new JButton("Czerwony");
        JButton orangeButton = new JButton("Pomarańczowy");
        JButton brownButton = new JButton("Brązowy");

        buttonPanel = new JPanel();

        // DODANIE PRZYCISKOW DO PANELU
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);
        buttonPanel.add(orangeButton);
        buttonPanel.add(brownButton);

        // DODANIE PANELU DO RAMKI
        add(buttonPanel, java.awt.BorderLayout.SOUTH);

        // UTWORZENIE AKCJI PRZYCISKOW
        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        ColorAction redAction = new ColorAction(Color.RED);
        ColorAction orangeAction = new ColorAction(new Color(255, 108, 0));
        ColorAction brownAction = new ColorAction(new Color(140, 67, 0));


        // POWIAZANIE AKCJI Z PRZYCISKAMI
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
        orangeButton.addActionListener(orangeAction);
        brownButton.addActionListener(brownAction);
    }

    // SLUCHACZ AKCJI USTAWIAJACY KOLOR TLA PANELU
    private class ColorAction implements ActionListener
    {
        private Color backgroundColor;

        public ColorAction(Color c)
        {
            backgroundColor = c;
        }

        public void actionPerformed(ActionEvent e)
        {
            buttonPanel.setBackground(backgroundColor);     // INSTRUKCJE WYWOLYWANE W ODPOWIEDZI NA KLIKNIECIE PRZYCISKU
        }
    }
}
