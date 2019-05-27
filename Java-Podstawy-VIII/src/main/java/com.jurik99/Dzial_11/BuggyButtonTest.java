package Dzial_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BuggyButtonTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                BuggyButtonFrame frame = new BuggyButtonFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class BuggyButtonFrame extends JFrame
{
    public BuggyButtonFrame()
    {
        setTitle("BuggyButtonTest");
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Dodanie panelu do ramki
        JPanel panel = new BuggyButtonPanel();
        add(panel);
    }
}

class BuggyButtonPanel extends JPanel
{
    public BuggyButtonPanel()
    {
        ActionListener listener = new ButtonListener();

        JButton yellowButton = new JButton("Żółty");
        add(yellowButton);
        yellowButton.addActionListener(listener);

        JButton blueButton = new JButton("Niebieski");
        add(blueButton);
        blueButton.addActionListener(listener);

        JButton redButton = new JButton("Czerwony");
        add(redButton);
        redButton.addActionListener(listener);
    }

    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String arg = e.getActionCommand();
            if (arg.equalsIgnoreCase("żółty")) setBackground(Color.YELLOW);
            else if (arg.equalsIgnoreCase("niebieski")) setBackground(Color.BLUE);
            else if (arg.equalsIgnoreCase("czerwony")) setBackground(Color.RED);
        }
    }
}
