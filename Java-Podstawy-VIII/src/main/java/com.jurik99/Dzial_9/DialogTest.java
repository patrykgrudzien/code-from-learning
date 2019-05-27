package Dzial_9;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class DialogTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                DialogFrame frame = new DialogFrame();
            }
        });
    }
}


/**
 * Ramka z menu, którego akcja Plik -> O Programie wyświetla okno dialogowe
 */
class DialogFrame extends JFrame
{
    private AboutDialog oknoDialogowe;

    public DialogFrame() throws HeadlessException
    {
        setTitle("DialogTest");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Tworzenie menu Plik
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("Plik");
        menuBar.add(fileMenu);

        // TWORZENIE ELEMENTÓW "O Programie" i "Zamknij"

        // Element "O Programie" wyświetla okno dialogowe (O Programie)
        JMenuItem aboutItem = new JMenuItem("O Programie");
        ActionListener listener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (oknoDialogowe == null)  // pierwszy raz
                {
                    oknoDialogowe = new AboutDialog(DialogFrame.this);
                }
                oknoDialogowe.setVisible(true); // wyskakujące okno dialogowe
            }
        };
        aboutItem.addActionListener(listener);

        fileMenu.add(aboutItem);

        // Element "Zamknij" powoduje zamknięcie programu
        JMenuItem exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        fileMenu.add(exitItem);
    }
}

/**
 * Przykładowe modalne okno dialogowe wyświetlające komunikat i oczekujące
 * na kliknięcie przycisku OK
 */
class AboutDialog extends JDialog
{
    public AboutDialog(JFrame owner)
    {
        super(owner, "Test okna \"O programie\"", true);

        // Dodanie etykiety w HTML
        add(new JLabel("<html><hl><i>Core Java</i></hl><hr>By JuRik99</html>"), BorderLayout.CENTER);

        // Przycisk OK zamyka okno dialogowe
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            }
        });

        // Dodanie przycisku OK do krawędzi południowej
        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);

        setSize(250, 150);
        setLocationRelativeTo(null);
    }
}