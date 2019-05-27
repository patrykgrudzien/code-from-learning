package Dzial_9;

import javax.swing.*;
import java.awt.*;

public class PolaTekstowe
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                PolaTekstoweFrame frame = new PolaTekstoweFrame();
            }
        });
    }
}

class PolaTekstoweFrame extends JFrame
{
    public PolaTekstoweFrame()
    {
        setTitle("Pola tekstowe");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel panel = new JPanel();
        add(panel);

        JLabel user = new JLabel("Nazwa użytkownika: ", SwingConstants.LEFT);
        panel.add(user);
        JTextField textField = new JTextField(20);
        textField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(textField);

        JLabel password = new JLabel("Hasło: ", SwingConstants.LEFT);
        panel.add(password);
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(passwordField);

        JTextArea area = new JTextArea(10, 25);
        area.setLineWrap(true);
        panel.add(area);

        JScrollPane scrollPane = new JScrollPane(area);
        panel.add(scrollPane);
    }


}

