package Dzial_9;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class ComboBoxTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                ComboBoxFrame frame = new ComboBoxFrame();
            }
        });
    }
}

/**
 * RAMKA Z PRZYKŁADOWĄ ETYKIETĄ TEKSTOWĄ I LISTĄ
 * ROZWIJALNĄ UMOŻLIWIAJĄCĄ WYBÓR KROJU CZCIONKI.
 */
class ComboBoxFrame extends JFrame
{
    private JComboBox faceCombo;
    private JLabel label;
    private static final int DEFAULT_SIZE = 18;

    public ComboBoxFrame()
    {
        setTitle("ComboBoxTest");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Dodanie tekstu etykiety
        label = new JLabel("Patka to wariatka jak jej Matka :D");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        // Tworzenie listy rozwijalnej i dodawanie nazw czcionek
        faceCombo = new JComboBox();
        faceCombo.setEditable(true);
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("Monospaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");
        faceCombo.addItem("Times New Roman Bold");

        // Dodanie listy rozwijalnej do panelu znajdującego się przy południowej krawędzi ramki
        JPanel comboPanel = new JPanel();
        comboPanel.add(faceCombo);
        add(comboPanel, BorderLayout.SOUTH);

        // Słuchacz listy rozwijalnej zmienia krój pisma etykiety na czcionkę wybraną przez użytkownika
        ActionListener listener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               label.setFont(new Font((String) faceCombo.getSelectedItem(), Font.PLAIN, DEFAULT_SIZE));
            }
        };
        faceCombo.addActionListener(listener);
    }
}
