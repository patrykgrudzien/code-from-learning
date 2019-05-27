package Dzial_9;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

public class ToolbarTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                ToolbarFrame frame = new ToolbarFrame();
            }
        });
    }
}

/**
 * Ramka z paskiem narzędzi i menu służącym do zmiany kolorów
 */
class ToolbarFrame extends JFrame
{
    public static final int DEFAULT_WIDTH = 600;
    public static final int DEFAULT_HEIGHT = 400;

    private JPanel panel;

    public ToolbarFrame() throws HeadlessException
    {
        setTitle("MenuTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Dodawanie panelu, którego kolor ma być zmieniany
        panel = new JPanel();
        add(panel, BorderLayout.CENTER);

        // Tworzenie akcji
        Action blueAction = new ColorAction("Niebieski", new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\blue-ball.gif"), Color.BLUE);
        Action yellowAction = new ColorAction("Żółty", new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\yellow-ball.gif"), Color.YELLOW);
        Action redAction = new ColorAction("Czerwony", new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\red-ball.gif"), Color.RED);

        Action exitAction = new AbstractAction("Koniec", new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\exit.gif"))
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        };
        exitAction.putValue(Action.SHORT_DESCRIPTION, "Zamknij");

        // Wstawianie elementów do paska narzędzi
        JToolBar bar = new JToolBar("Pasek narzędzi");
        bar.add(blueAction);
        bar.add(yellowAction);
        bar.add(redAction);
        bar.addSeparator();
        bar.add(exitAction);

        add(bar, BorderLayout.NORTH);

        // Wstawianie elementów do menu
        JMenu menu = new JMenu("Kolor");
        menu.add(blueAction);
        menu.add(yellowAction);
        menu.add(redAction);
        menu.add(exitAction);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    /**
     * Akcja dotycząca koloru zmienia kolor tła ramki
     */
    class ColorAction extends AbstractAction
    {
        public ColorAction(String name, Icon icon, Color c)
        {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Kolor tła: " +name);
            putValue("Kolor", c);
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            Color c = (Color) getValue("Kolor");
            panel.setBackground(c);
        }
    }
}
