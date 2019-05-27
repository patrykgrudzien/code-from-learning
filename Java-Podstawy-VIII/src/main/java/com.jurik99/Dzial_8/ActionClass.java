package Dzial_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionClass
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                ActionFrame frame = new ActionFrame();
            }
        });
    }
}

// --- RAMKA Z PANELEM, KTORY DEMONSTRUJE AKCJE ZMIANY KOLOROW --- //
class ActionFrame extends JFrame
{
    private JPanel buttonPanel;

    public ActionFrame()
    {

        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }

        setTitle("ActionTest");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        buttonPanel = new JPanel();

        // DEFINICJE AKCJI
        ColorAction yellowAction = new ColorAction("Żółty", new ImageIcon("D:\\Moje Dokumenty\\Eclipse\\Java.Podstawy.VIII\\src\\Dzial_8\\yellow-ball.gif"), Color.YELLOW);
        ColorAction blueAction = new ColorAction("Niebieski", new ImageIcon("D:\\Moje Dokumenty\\Eclipse\\Java.Podstawy.VIII\\src\\Dzial_8\\blue-ball.gif"), Color.BLUE);
        ColorAction redAction = new ColorAction("Czerwony", new ImageIcon("D:\\Moje Dokumenty\\Eclipse\\Java.Podstawy.VIII\\src\\Dzial_8\\red-ball.gif"), Color.RED);

        // DODANIE PRZYCISKOW DO AKCJI
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        // DODANIE PANELU DO RAMKI
        add(buttonPanel);

        // POWIAZANIE KLAWISZY Z, N i C z NAZWAMI
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Z"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl N"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl C"), "panel.red");

        // POWIAZANIE NAZW Z AKCJAMI
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.blue", blueAction);
        amap.put("panel.red", redAction);
    }

    // ---------------------------------------------------------------------------------------- //
    public class ColorAction extends AbstractAction
    {
        /**
         * @param name - nazwa, ktora pojawi sie na przycisku
         * @param icon - ikona, ktora pojawi sie na przycisku
         * @param c - kolor tla
         */
        public ColorAction(String name, Icon icon, Color c)
        {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Ustawia kolor panelu na " +name.toLowerCase());
            putValue("color", c);
        }

        public void actionPerformed(ActionEvent e)
        {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}
