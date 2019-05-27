package Dzial_9;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

public class OptionDialogTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                OptionDialogFrame frame = new OptionDialogFrame();
            }
        });
    }
}

/**
 * Ramka z przełącznikami otoczonymi obramowaniem z tytułem
 */
class ButtonPanel extends JPanel
{
    private ButtonGroup group;
    /**
     * Tworzy panel przycisków.
     *
     * @param title tytuł widoczny na obramowaniu
     * @param options tablica etykiet przełączników
     */
    public ButtonPanel(String title, String...options)
    {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        group = new ButtonGroup();

        // Tworzenie po jednym przełączniku do każdej opcji
        for (String opcje : options)
        {
            JRadioButton b = new JRadioButton();
            b.setActionCommand(opcje);
            add(b);
            group.add(b);
            b.setSelected(opcje == options[0]);
        }
    }

    /**
     * Pobiera aktualnie zaznaczoną opcję
     *
     * @return etykieta aktualnie zaznaczonego przełącznika
     */
    public String getSelection()
    {
        return group.getSelection().getActionCommand();
    }
}


/**
 * Ramka zawierająca ustawienia dotyczące wyboru różnych okien dialogowych opcji
 */
class OptionDialogFrame extends JFrame
{
    public static final int DEFAULT_WIDTH = 600;
    public static final int DEFAULT_HEIGHT = 400;

    private ButtonPanel typePanel, messagePanel, messageTypePanel, optionPanel, optionTypePanel, inputPanel;

    private String messageString = "Message";
    private Icon messageIcon = new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\blue-ball.gif");
    private Object messageObject = new Date();
    private Component messageComponent = new SampleComponent();


    public OptionDialogFrame() throws HeadlessException
    {
        setTitle("OptionDialogTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2, 3));

        typePanel = new ButtonPanel("Typ", "Message", "Confirm", "Option", "Input");
        messageTypePanel = new ButtonPanel("Typ komunikatu", "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE");
        messagePanel = new ButtonPanel("Komunikat", "String", "Icon", "Component", "Other", "Object[]");
        optionTypePanel = new ButtonPanel("Potwierdzenie", "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION");
        optionPanel = new ButtonPanel("Opcja", "String[]", "Icon[]", "Object[]");
        inputPanel = new ButtonPanel("Dane wejściowe", "Text Field", "Combo Box");

        gridPanel.add(typePanel);
        gridPanel.add(messageTypePanel);
        gridPanel.add(messagePanel);
        gridPanel.add(optionTypePanel);
        gridPanel.add(optionPanel);
        gridPanel.add(inputPanel);

        //Dodawanie panelu z przyciskiem pokaż
        JPanel showPanel = new JPanel();
        JButton showBtton = new JButton("Pokaż");
        showBtton.addActionListener(new ShowAction());
        showPanel.add(showBtton);

        add(gridPanel, BorderLayout.CENTER);
        add(showPanel, BorderLayout.SOUTH);
    }

    /**
     * Pobiera aktualnie wybrany komunikat
     *
     * @return łańcuch, ikona, komponent lub tablica obiektów w zależności od wyboru w panelu "Komunikat"
     */
    public Object getMessage()
    {
        String s = messagePanel.getSelection();

        if (s.equals("String")) return messageString;
        else if (s.equals("Icon"))  return messageIcon;
        else if (s.equals("Component"))  return messageComponent;
        else if (s.equals("Object[]"))  return new Object[] {messageString, messageIcon, messageComponent, messageObject};
        else if (s.equals("Other")) return messageObject;
        else return null;
    }

    /**
     * Pobiera aktualnie wybrane pozycje
     * @return tablica łańcuchów, ikon lub obiektów w zależności od wyboru w panelu Opcja
     */
    public Object[] getOptions()
    {
        String s = optionPanel.getSelection();
        if (s.equals("String[]"))
            return new String[] { "Yellow", "Blue", "Red" };
        else if (s.equals("Icon[]"))
            return new Icon[] { new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\yellow-ball.gif"), new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\blue-ball.gif"), new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\red-ball.gif") };
        else if (s.equals("Object[]"))
            return new Object[] { messageString, messageIcon, messageComponent, messageObject };
        else
            return null;
    }

    /**
     * Pobiera wybrany komunikat lub typ opcji
     *
     * @param panel Typ komunikatu lub panel Potwierdzenie
     * @return wybrana stała XXX_MESSAGE lub XXX_OPTION constant z klasy JOptionPane
     */
    public int getType(ButtonPanel panel)
    {
        String s = panel.getSelection();
        try
        {
            return JOptionPane.class.getField(s).getInt(null);
        }
        catch (Exception e)
        {
            return -1;
        }
    }

    /**
     * Słuchacz akcji przycisku "Pokaż" wyświetla okno dialogowe potwierdzenia, danych wejściowych,
     * komunikatu lub opcji w zależności od wyboru typu panelu
     */
    private class ShowAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (typePanel.getSelection().equals("Confirm"))
            {
                JOptionPane.showConfirmDialog(OptionDialogFrame.this, getMessage(), "Title", getType(optionTypePanel), getType(messageTypePanel));
            }
            else if (typePanel.getSelection().equals("Input"))
            {
                if (inputPanel.getSelection().equals("Text field"))
                    JOptionPane.showInputDialog(OptionDialogFrame.this, getMessage(), "Title", getType(messageTypePanel));
                else
                    JOptionPane.showInputDialog(OptionDialogFrame.this, getMessage(), "Title", getType(messageTypePanel), null, new String[] {"Yellow", "Blue", "Red"}, "Blue");
            }
            else if (typePanel.getSelection().equals("Message"))
                JOptionPane.showMessageDialog(OptionDialogFrame.this, getMessage(), "Title", getType(messageTypePanel));
            else if (typePanel.getSelection().equals("Option"))
                JOptionPane.showOptionDialog(OptionDialogFrame.this, getMessage(), "Title", getType(optionTypePanel), getType(messageTypePanel), null, getOptions(), getOptions()[0]);
        }
    }
}


/**
 * Komponent z polamowaną powierzchnią
 */
class SampleComponent extends JComponent
{
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1);
        g2.setPaint(Color.YELLOW);
        g2.fill(rect);
        g2.setPaint(Color.BLUE);
        g2.draw(rect);
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(10, 10);
    }
}