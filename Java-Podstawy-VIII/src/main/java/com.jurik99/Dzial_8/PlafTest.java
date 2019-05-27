package Dzial_8;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlafTest
{
    public static void main(String[] args)
    {
        PlafFrame window = new PlafFrame();
    }
}

// --- RAMKA Z PANELEM ZAWIERAJACYM PRZYCISKI ZMIENIAJACE STYL --- //
class PlafFrame extends JFrame
{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public PlafFrame()
    {
        setTitle("PlafTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        buttonPanel = new JPanel();

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos)
        {
            makeButton(info.getName(), info.getClassName());
        }

        add(buttonPanel);
    }

    /**
     * @param name - nazwa przycisku
     * @param plafName - nazwa klasy stylu
     */
    void makeButton(String name, final String plafName)
    {
        // DODANIE PRZYCISKU DO PANELU
        JButton button = new JButton(name);
        buttonPanel.add(button);

        // USTAWIENIE AKCJI PRZYCISKU
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // Akcja przycisku - przelaczanie na nowy styl
                try
                {
                    UIManager.setLookAndFeel(plafName);
                    SwingUtilities.updateComponentTreeUI(PlafFrame.this);
                }
                catch (ClassNotFoundException e1)
                {
                    e1.printStackTrace();
                }
                catch (UnsupportedLookAndFeelException e1)
                {
                    e1.printStackTrace();
                }
                catch (InstantiationException e1)
                {
                    e1.printStackTrace();
                }
                catch (IllegalAccessException e1)
                {
                    e1.printStackTrace();
                }
            }
        };
        button.addActionListener(listener);
    }
}
