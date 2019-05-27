package Dzial_9;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class TextComponentTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                TextComponentFrame frame = new TextComponentFrame();
            }
        });
    }
}

/**
 * RAMKA Z PROSTYMI KOMPONENTAMI TEKSTOWYMI
 */
class TextComponentFrame extends JFrame
{
    public TextComponentFrame()
    {
        setTitle("TextComponentTest");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        final JTextField textField = new JTextField();
        final JPasswordField passwordField = new JPasswordField();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 2));
        northPanel.add(new JLabel("Nazwa użytkownika: ", SwingConstants.RIGHT));
        northPanel.add(textField);
        northPanel.add(new JLabel("Hasło: ", SwingConstants.RIGHT));
        northPanel.add(passwordField);

        add(northPanel, BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea(8, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);

        // Dodanie przycisku wstawiajacego tekst do obszaru tekstowego
        JPanel southPanel = new JPanel();

        JButton insertButton = new JButton("Wstaw");
        southPanel.add(insertButton);

        ActionListener listener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String password = new String(passwordField.getPassword());
                textArea.append("Nazwa użytkownika: " +textField.getText()+ "\nHasło: " +password+"\n");
            }
        };
        insertButton.addActionListener(listener);
        add(southPanel, BorderLayout.SOUTH);
    }
}
