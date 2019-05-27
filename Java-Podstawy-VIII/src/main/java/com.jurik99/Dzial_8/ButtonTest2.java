package Dzial_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTest2
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                ButtonFrame2 window2 = new ButtonFrame2();
            }
        });
    }
}

// --- RAMKA Z PANELEM ZAWIERAJACYM PRZYCISKI --- //
class ButtonFrame2 extends JFrame
{
    private JPanel buttonPanel_2;
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame2()
    {
        setTitle("ButtonTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        buttonPanel_2 = new JPanel();
        add(buttonPanel_2);

        makeButton("Żółty", Color.YELLOW);
        makeButton("Niebieski", Color.BLUE);
        makeButton("Czerwony", Color.RED);
    }

    // METODA POMOCNICZA
    public void makeButton(String name, Color backgroundColor)
    {
        JButton button = new JButton(name);
        buttonPanel_2.add(button);
        ColorAction action = new ColorAction(backgroundColor);
        button.addActionListener(action);
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
            buttonPanel_2.setBackground(backgroundColor);     // INSTRUKCJE WYWOLYWANE W ODPOWIEDZI NA KLIKNIECIE PRZYCISKU
        }
    }
}
