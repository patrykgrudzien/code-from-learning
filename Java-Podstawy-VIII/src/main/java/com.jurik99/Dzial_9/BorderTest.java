package Dzial_9;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorderTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                BorderFrame  frame = new BorderFrame();
            }
        });
    }
}

/**
 * RAMKA Z PRZELACZNIKAMI SLUZACYMI DO WYBORU STYLU OBRAMOWANIA
 */
class BorderFrame extends JFrame
{
    private JPanel demoPanel;
    private JPanel buttonPanel;
    private ButtonGroup group;

    public BorderFrame()
    {
        setTitle("BorderTest");
        setSize(1000, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        demoPanel = new JPanel();
        buttonPanel = new JPanel();
        group = new ButtonGroup();

        addRadioButton("LoweredBevel (ukos dolny)", BorderFactory.createLoweredBevelBorder());
        addRadioButton("RaisedBevel (ukos górny)", BorderFactory.createRaisedBevelBorder());
        addRadioButton("Etched (wgłębienie)", BorderFactory.createEtchedBorder());
        addRadioButton("Line (linia)", BorderFactory.createLineBorder(Color.BLUE));
        addRadioButton("Mate (linia z grubościami)", BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));
        addRadioButton("Empty (pusta)", BorderFactory.createEmptyBorder());

        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched, "Rodzaje obramowań");
        buttonPanel.setBorder(titled);

        setLayout(new GridLayout(2, 1));
        add(buttonPanel);
        add(demoPanel);


    }

    public void addRadioButton(String name, final Border border)
    {
        JRadioButton button = new JRadioButton(name);
        ActionListener listener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                demoPanel.setBorder(border);
            }
        };
        button.addActionListener(listener);

        group.add(button);
        buttonPanel.add(button);
    }
}
