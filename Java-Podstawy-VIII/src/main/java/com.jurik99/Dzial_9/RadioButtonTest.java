package Dzial_9;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                RadioButtonFrame frame = new RadioButtonFrame();
            }
        });
    }
}

/**
 * RAMKA Z PRZYKLADOWA ETYKIETA TEKSTOWA I PRZELACZNIKAMI SLUZACYMI DO WYBORU ROZMIARU CZCIONKI
 */
class RadioButtonFrame extends JFrame
{
    private JPanel buttonPanel;
    private ButtonGroup group;
    private JLabel label;
    private static final int DEFAULT_SIZE = 8;

    public RadioButtonFrame() throws HeadlessException
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


        setTitle("RadioButtonTest");
        setSize(600,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


        // Dodanie przykladowej etykiety tekstowej
        label = new JLabel("Patka to wariatka jak jej Matka :D");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        // Dodanie przelacznikow
        buttonPanel = new JPanel();
        group = new ButtonGroup();

        addRadioButton("Mała", 8);
        addRadioButton("Średnia", 12);
        addRadioButton("Duża", 18);
        addRadioButton("Bardzo duża", 36);

        add(buttonPanel, BorderLayout.SOUTH);


    }

    /**
     * TWORZY PRZEŁĄCZNIK USTAWIAJĄCY ROZMIAR CZCIONKI PRZYKŁADOWEGO TEKSTU.
     * @param name - łańcuch identyfikujący przełącznik
     * @param size - rozmiar czcionki ustawiany przez przełącznik
     */
    public void addRadioButton(String name, final int size)
    {
        boolean selected = size==DEFAULT_SIZE;
        JRadioButton button = new JRadioButton(name, selected);
        group.add(button);
        buttonPanel.add(button);

        // Niniejszy sluchacz ustawia rozmiar czcionki etykiety
        ActionListener listener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                label.setFont(new Font("Serif", Font.PLAIN, size));
            }
        };
        button.addActionListener(listener);
    }
}
