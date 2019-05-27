package Dzial_9;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class MenuTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                MenuTestFrame frame = new MenuTestFrame();
            }
        });
    }
}

/**
 * Ramka z paskiem MENU
 */
class MenuTestFrame extends JFrame
{
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
    private Action saveAction;
    private Action saveAsAction;
    private JCheckBoxMenuItem readOnlyItem;
    private JPopupMenu popupMenu;

    public MenuTestFrame() throws HeadlessException
    {
        setTitle("MenuTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JMenu fileMenu = new JMenu("Plik");
        fileMenu.add(new TestAction("Nowy"));

        // AKCELERATORY
        JMenuItem openItem = fileMenu.add(new TestAction("Otwórz"));
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        fileMenu.addSeparator();

        saveAction = new TestAction("Zapisz");
        JMenuItem saveItem = fileMenu.add(saveAction);
        saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        saveAsAction = new TestAction("Zapisz jako");
        fileMenu.add(saveAsAction);

        fileMenu.addSeparator();

        fileMenu.add(new AbstractAction("Zakończ")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        // MENU Z POLEM WYBORU I PRZEŁĄCZNIKAMI
        readOnlyItem = new JCheckBoxMenuItem("Tylko do odczytu");
        readOnlyItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean saveOK = readOnlyItem.isSelected();
                saveAction.setEnabled(!saveOK);
                saveAsAction.setEnabled(!saveOK);
            }
        });

        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Wstawianie");
        insertItem.setSelected(true);
        JRadioButtonMenuItem overTypeItem = new JRadioButtonMenuItem("Nadpisywanie");
        group.add(insertItem);
        group.add(overTypeItem);

        // IKONY
        Action cutAction = new TestAction("Wytnij");
        cutAction.putValue(Action.SMALL_ICON, new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\cut.gif"));

        Action copyAction = new TestAction("Kopiuj");
        copyAction.putValue(Action.SMALL_ICON, new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\copy.gif"));

        Action pasteAction = new TestAction("Wklej");
        pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\paste.gif"));

        JMenu editMenu = new JMenu("Edycja");
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);

        // ZAGNIEŻDŻONE MENU
        JMenu optionMenu = new JMenu("Opcje");
        optionMenu.add(readOnlyItem);
        optionMenu.addSeparator();
        optionMenu.add(insertItem);
        optionMenu.add(overTypeItem);

        editMenu.addSeparator();
        editMenu.add(optionMenu);

        // MNEMONIKI
        JMenu helpMenu = new JMenu("Pomoc");
        helpMenu.setMnemonic('P');

        JMenuItem indexItem = new JMenuItem("Indeks");
        indexItem.setMnemonic('I');
        helpMenu.add(indexItem);

        // MNEMONIKI MOŻNA TAKŻE DODAWAĆ DO AKCJI
        Action aboutAction = new TestAction("O programie");
        aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('O'));
        helpMenu.add(aboutAction);

        // DODANIE WSZYSTKICH MENU NAJWYŻSZEGO RZĘDU DO PASKA MENU
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // MENU KONTEKSTOWE
        popupMenu = new JPopupMenu();
        popupMenu.add(cutAction);
        popupMenu.add(copyAction);
        popupMenu.add(pasteAction);

        JPanel panel = new JPanel();
        panel.setComponentPopupMenu(popupMenu);
        add(panel);

        /**
         * Poniższy wiersz stanowi obejście błędu 4966109
         */
        panel.addMouseListener(new MouseAdapter()
        {
        });

    }
}

/**
 * Przykładowa akcja, która drukuje nazwę akcji do wyjścia System.out
 */
class TestAction extends AbstractAction
{
    public TestAction(String name)
    {
        super(name);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JOptionPane.showMessageDialog(null, "Wybrano: " +getValue(Action.NAME));
//        System.out.println(getValue(Action.NAME) + " selected.");
    }

}
