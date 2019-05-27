package Dzial_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridBagLayoutTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                GridBagLayoutTestFrame frame = new GridBagLayoutTestFrame();
            }
        });
    }
}

/**
 * Ramka zawierająca komponenty ustawiające własności czcionki w rozkładzie GridBagLayout
 */
class GridBagLayoutTestFrame extends JFrame
{
    public static final int DEFAULT_WIDTH = 350;
    public static final int DEFAULT_HEIGHT = 200;

    private JComboBox face;
    private JComboBox size;
    private JCheckBox bold;
    private JCheckBox italic;
    private JTextArea sample;

    public GridBagLayoutTestFrame() throws HeadlessException
    {
        setTitle("GridBagLayoutTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        ActionListener listener = new FontAction();

        // Tworzenie komponentów
        JLabel faceLabel = new JLabel("Czcionka: ");
        face = new JComboBox(new String[] {"Serif", "SansSerif", "Monospaced", "Dialog", "DialogInput", "Timew New Roman"});
        face.addActionListener(listener);

        JLabel sizeLabel = new JLabel("Rozmiar: ");
        size = new JComboBox(new String[] {"8", "10", "12", "15", "18", "24", "36", "48"});
        size.addActionListener(listener);

        bold = new JCheckBox("Pogrubienie");
        bold.addActionListener(listener);

        italic = new JCheckBox("Kursywa");
        italic.addActionListener(listener);

        sample = new JTextArea();
        sample.setText("Przykładowy tekst napisany w JTextArea by JuRik99");
        sample.setEditable(false);
        sample.setLineWrap(true);
        sample.setBorder(BorderFactory.createLoweredBevelBorder());

        // Dodawanie komponentów do siatki przy użyciu klasy pomocniczej GBC
        add(faceLabel, new GBC(0, 0).setAnchor(GBC.EAST));
        add(face, new GBC(1,0).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
        add(sizeLabel, new GBC(0, 1).setAnchor(GBC.EAST));
        add(size, new GBC(1, 1).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
        add(bold, new GBC(1, 2, 1, 1).setAnchor(GBC.WEST).setWeight(100, 100));
        add(italic, new GBC(1, 3, 1, 1).setAnchor(GBC.WEST).setWeight(100, 100));
        add(sample, new GBC(2, 0, 1, 4).setFill(GBC.BOTH).setWeight(100, 100));
    }

    /**
     * Słuchacz akcji zmieniający czcionkę przykładowego tekstu
     */
    private class FontAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String fontFace = (String) face.getSelectedItem();
            int fontStyle = (bold.isSelected() ? Font.BOLD : 0) + (italic.isSelected() ? Font.ITALIC : 0);
            int fontSize = Integer.parseInt((String) size.getSelectedItem());

            Font font = new Font(fontFace, fontStyle, fontSize);

            sample.setFont(font);
            sample.repaint();
        }
    }
}
