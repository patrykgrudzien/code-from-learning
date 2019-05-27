package Dzial_9;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                CheckBoxFrame frame = new CheckBoxFrame();
            }
        });
    }
}

/**
 * RAMKA Z PRZYKLADOWA ETYKIETA TEKSTOWA I POLAMI WYBORU ATRYBUTOW CZCIONKI
 */
class CheckBoxFrame extends JFrame
{
    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONT_SIIZE = 20;

    public CheckBoxFrame() throws HeadlessException
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


        setTitle("CheckBoxTest");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Dodanie przykladowej etykiety tekstowej
        label = new JLabel("Patka to wariatka jak jej Matka :D");
        label.setFont(new Font("Serif", Font.PLAIN, FONT_SIIZE));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);



        ActionListener listener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int mode = 0;
                if (bold.isSelected())  mode += Font.BOLD;  // public static final int BOLD
                if (italic.isSelected())  mode += Font.ITALIC;
                label.setFont(new Font("Serif", mode, FONT_SIIZE));
            }
        };



        // Dodanie pol wyboru
        JPanel buttonPanel = new JPanel();

        bold = new JCheckBox("Pogrubienie");
        bold.addActionListener(listener);
        buttonPanel.add(bold);

        italic = new JCheckBox("Kursywa");
        italic.addActionListener(listener);
        buttonPanel.add(italic);

        add(buttonPanel, BorderLayout.SOUTH);

    }
}
