package Dzial_9;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChooserTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                ColorChooserFrame frame = new ColorChooserFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * Ramka z panelem wyboru koloru
 */
class ColorChooserFrame extends JFrame
{
    public ColorChooserFrame() throws HeadlessException
    {
        setTitle("ColorChooserTest");
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Dodanie panelu wyboru koloru do ramki
        ColorChooserPanel panel = new ColorChooserPanel();
        add(panel);
    }
}

/**
 * Panel z przyciskami uruchamiającymi 3 typy okien
 */
class ColorChooserPanel extends JPanel
{
    private JDialog dialog;
    private JColorChooser chooser;

    public ColorChooserPanel()
    {
        JButton modalButton = new JButton("Modalne");
        modalButton.addActionListener(new ModalListener());
        add(modalButton);

        JButton modelessButton = new JButton("Niemodalne");
        modelessButton.addActionListener(new ModelessListener());
        add(modelessButton);

        JButton immediateButton = new JButton("Bezpośrednie");
        immediateButton.addActionListener(new ImmediateListener());
        add(immediateButton);
    }

    /**
     * Niniejszy słuchasz wyświetla okno modalne
     */
    private class ModalListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Color defaultColor = getBackground();
            Color selected = JColorChooser.showDialog(ColorChooserPanel.this, "Ustaw kolor tła", defaultColor);
            if (selected != null)
                setBackground(selected);
        }
    }


    /**
     * Niniejszy słuchacz wyświetla okno niemodalne.
     * Kolor tła panelu zmienia się po kliknięciu przycisku OK.
     */
    private class ModelessListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            chooser = new JColorChooser();
            dialog = JColorChooser.createDialog(ColorChooserPanel.this, "Kolor tła", false, chooser, new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    setBackground(chooser.getColor());
                }
            }, null);

            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }


    /**
     * Niniejszy słuchacz wyświetla okno niemodalne.
     * Kolor tła panelu zmienia się bezpośrednio po wybraniu przez użytkownika koloru.
     */
    private class ImmediateListener implements ActionListener
    {
        public ImmediateListener()
        {
            chooser = new JColorChooser();
            chooser.getSelectionModel().addChangeListener(new ChangeListener()
            {
                @Override
                public void stateChanged(ChangeEvent e)
                {
                    setBackground(chooser.getColor());
                }
            });

            dialog = new JDialog( (Frame) null, false);
            dialog.add(chooser);
            dialog.pack();
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }
}
