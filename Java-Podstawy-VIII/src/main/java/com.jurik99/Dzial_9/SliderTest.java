package Dzial_9;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Dictionary;
import java.util.Hashtable;

public class SliderTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                SliderTestFrame frame = new SliderTestFrame();
            }
        });
    }
}

/**
 * Ramka zawierająca kilka suwaków oraz pole tekstowe pokazujące
 * wartości ustawiane za ich pomocą.
 */
class SliderTestFrame extends JFrame
{
    private JPanel sliderPanel;
    private JTextField textField;
    private ChangeListener listener;

    public SliderTestFrame()
    {
//        try
//        {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//            SwingUtilities.updateComponentTreeUI(this);
//        }
//        catch (ClassNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//        catch (InstantiationException e)
//        {
//            e.printStackTrace();
//        }
//        catch (IllegalAccessException e)
//        {
//            e.printStackTrace();
//        }
//        catch (UnsupportedLookAndFeelException e)
//        {
//            e.printStackTrace();
//        }


        setTitle("ComboBoxTest");
        setSize(400, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        sliderPanel = new JPanel();
        sliderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));



        // Wspólny słuchacz wszystkich suwaków
        listener = new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                // Aktualizacja pola tekstowego w odpowiedzi na zmianę wartości suwaka
                JSlider source = (JSlider) e.getSource();
                textField.setText("" +source.getValue());
            }
        };



        // Zwykły suwak
        JSlider slider = new JSlider();
        addSlider(slider, "Zwykły");

        // Suwak z podziałką
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Podziałka");

        // Suwak z dosuwaniem gałki do najbliższej kreski
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Dosuwany");

        // Suwak bez prowadnicy
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(false);
        addSlider(slider, "Bez prowadnicy");

        // Suwak o odwróconym działaniu
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setInverted(true);
        addSlider(slider, "Odwrócony");

        // Suwak z etykietami liczbowymi
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Etykiety");

        // Suwak z etykietami literowymi
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setSnapToTicks(true);

        Dictionary<Integer, Component> labelTable = new Hashtable<Integer, Component>();
        labelTable.put(0, new JLabel("A"));
        labelTable.put(20, new JLabel("B"));
        labelTable.put(40, new JLabel("C"));
        labelTable.put(60, new JLabel("D"));
        labelTable.put(80, new JLabel("E"));
        labelTable.put(100, new JLabel("F"));

        slider.setLabelTable(labelTable);
        addSlider(slider, "Niestandardowe etykiety");

        // Suwak z etykietami ikonowymi
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(20);
        slider.setSnapToTicks(true);

        labelTable = new Hashtable<Integer, Component>();

        // Dodawanie obrazów kart
        labelTable.put(0, new JLabel(new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\nine.gif")));
        labelTable.put(20, new JLabel(new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\ten.gif")));
        labelTable.put(40, new JLabel(new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\jack.gif")));
        labelTable.put(60, new JLabel(new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\queen.gif")));
        labelTable.put(80, new JLabel(new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\king.gif")));
        labelTable.put(100, new JLabel(new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\ace.gif")));

        slider.setLabelTable(labelTable);
        addSlider(slider, "Ikony");


        textField= new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Serif", Font.BOLD, 16));
        add(textField, BorderLayout.SOUTH);
        add(sliderPanel, BorderLayout.CENTER);

    }

    /**
     * Dodaje suwak do panelu suwaków i wiąże słuchacza
     * @param s - suwak
     * @param description - opis suwaka
     */
    public void addSlider(JSlider s, String description)
    {
        s.addChangeListener(listener);
        JPanel panel = new JPanel();
        panel.add(s);
        panel.add(new JLabel(description));
        sliderPanel.add(panel);
    }
}
