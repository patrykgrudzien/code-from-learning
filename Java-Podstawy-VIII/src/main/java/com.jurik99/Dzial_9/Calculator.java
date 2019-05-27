package Dzial_9;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class Calculator
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setLocationRelativeTo(null);
            }
        });
    }
}

/**
 * RAMKA Z PANELEM KALKULATORA
 */
class CalculatorFrame extends JFrame
{
    public CalculatorFrame()
    {
        setTitle("Calculator by JuRik");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();
    }
}


/**
 * PANEL Z PRZYCISKAMI KALKULATORA I PROCEDURA WYSWIETLAJACA WYNIK
 */
class CalculatorPanel extends JPanel
{
    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;

    public CalculatorPanel()
    {
        setLayout(new BorderLayout());

        result = 0;
        lastCommand = "=";
        start = true;

        // ------------ DODANIE WYSWIETLACZA ------------ //
        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        // ------------ DODANIE PANELU I WSTAWIENIE PRZYCISKOW NA SIATKE 4X4 ------------ //
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);
    }


    /**
     * Dodaje przycisk do panelu centralnego
     * @param label - etykieta przycisku
     * @param listener - słuchacz przycisków
     */
    public void addButton(String label, ActionListener listener)
    {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }


    /**
     * Niniejsza akcja wstawia łańcuch akcji przycisku na końcu tekstu wyświetlania
     */
    private class InsertAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String input = event.getActionCommand();
            if (start)
            {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }

    /**
     * Niniejsza akcja wykonuje polecenia określone przez akcję przycisku
     */
    private class CommandAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String command = event.getActionCommand();
            if (start)
            {
                if (command.equals("-"))
                {
                    display.setText(command);
                    start = false;
                }
                else lastCommand = command;
            }
            else
            {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }

    /**
     * Wykonuje oczekujące działania.
     * @param x - wartość, która ma być połączona z poprzednim wynikiem
     */
    public void calculate(double x)
    {
        if (lastCommand.equals("+"))    result += x;
        else if (lastCommand.equals("*"))    result *= x;
        else if (lastCommand.equals("*"))    result *= x;
        else if (lastCommand.equals("/"))    result /= x;
        else if (lastCommand.equals("="))    result = x;
        display.setText("" + result);
    }

}