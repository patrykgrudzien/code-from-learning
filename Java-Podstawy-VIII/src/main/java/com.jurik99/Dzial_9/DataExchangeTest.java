package Dzial_9;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class DataExchangeTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                DataExchangeFrame frame = new DataExchangeFrame();
            }
        });
    }
}

/**
 * Ramka z menu, którego akcja Plik --> Połącz wyświetla okno dialogowe z polem hasła
 */
class DataExchangeFrame extends JFrame
{
    private JTextArea textArea;
    private PasswordChooser dialog = null;

    public DataExchangeFrame()
    {
        setTitle("DataExchangeTest");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Tworzenie menu Plik
        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);
        JMenu fileMenu = new JMenu("Plik");
        mbar.add(fileMenu);

        // Tworzenie elementów menu Połącz i Zamknij
        JMenuItem connectItem = new JMenuItem("Połącz");
        connectItem.addActionListener(new ConnectAction());
        fileMenu.add(connectItem);

        // Opcja Zakmnij zamyka program
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

        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    /**
     * Akcja Connect wyświetla okno dialogowe
     */
    private class ConnectAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // Jeśli jest to pierwszy raz, tworzy okno dialogowe
            if (dialog == null)
                dialog = new PasswordChooser();

            // Ustawianie wartości domyślnych
//            dialog.setUser(new User("nazwaużytkownika", null));

            // Wyświetlanie okna dialogowego
            if (dialog.showDialog(DataExchangeFrame.this, "Połącz"))
            {
                // Pobranie danych użytkownika w przypadku zatwierdzenia
                User u = dialog.getUser();
                textArea.append("Nazwa użytkownika: " +u.getName()+ " , Hasło: " +(new String(u.getPassword())) + "\n");
            }
        }
    }
}

/**
 * Elementy służące do podania hasła, które widać w oknie dialogowym
 */
class PasswordChooser extends JPanel
{
    private JTextField userName;
    private JPasswordField passwordField;
    private JButton okButton;
    private boolean ok;
    private JDialog dialog;

    public PasswordChooser()
    {
        setLayout(new BorderLayout());

        // Tworzenie panelu z polami nazwy użytkownika i hasła
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2 ,2));
        panel.add(new JLabel("Mazwa użytkownika: "));
        panel.add(userName = new JTextField(""));

        panel.add(new JLabel("Hasło: "));
        panel.add(passwordField = new JPasswordField(""));

        add(panel, BorderLayout.CENTER);

        // Tworzenie przycisków OK i ANULUJ, które zamykają okno dialogowe
        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ok = true;
                dialog.setVisible(false);
            }
        });

        JButton cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dialog.setVisible(false);
            }
        });

        // Dodawanie przycisków w pobliżu południowej krawędzi
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);


    }


    /**
     * Ustawia wartości domyślne okna dialogowego
     * @param u domyślne informacje użytkownika
     */
    public void setUser(User u)
    {
        userName.setText(u.getName());
    }

    /**
     * Pobiera dane podane w oknie dialogowym
     *
     * @return a obiekt typu User, którego stan reprezentuje dane wprowadzone w oknie dialogowym
     */
    public User getUser()
    {
        return new User(userName.getText(), passwordField.getPassword());
    }

    /**
     * Wyświetla panel z elementami przyjmującymi dane od użytkownika w oknie dialogowym
     * @param parent komponent w ramce nadrzędnej lub wartość null
     * @param title tytuł okna dialogowego
     */
    public boolean showDialog(Component parent, String title)
    {
        ok = false;

        // Lokalizacja ramki nadrzędnej
        Frame owner = null;
        if (parent instanceof Frame)    // jeśli "parent" jest obiektem klasy "Frame"
        {
            owner = (Frame) parent;
        }
        else
        {
            owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);
            /**
             * getAncestorOfClass - zwraca najgłębiej zagnieżdżony kontener nadrzędny danego komponentu, który
             * należy do danej klasy lub jednej z jej podklas
             */
        }

        // Jeśli jest to pierwszy raz lub zmienił się użytkownik, utworzenie nowego okna dialogowego
        if (dialog == null || dialog.getOwner() != owner)
        {
            dialog = new JDialog(owner, true);
            dialog.add(this); // dodanie panelu do okna dialogowego
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.pack();
        }

        // Ustawianie tytułu i wyświetlenie okna dialogowego
        dialog.setTitle(title);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        return ok;
    }
}


/**
 * Użytkownik ma nazwę i hasło.
 * Ze względów bezpieczeństwa hasło jest przechowywane jako typ char[] a nie String.
 */
class User
{
    private String name;
    private char[] password;

    public User(String name, char[] password)
    {
        this.name = name;
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public char[] getPassword()
    {
        return password;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPassword(char[] password)
    {
        this.password = password;
    }
}