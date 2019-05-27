package Dzial_9;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

public class FileChooserTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                ImageViewerFrame frame = new ImageViewerFrame();
            }
        });
    }
}

/**
 * Ramka z menu zawierającym opcję Otwórz i obszarem do prezentacji otwartych obrazków
 */
class ImageViewerFrame extends JFrame
{
    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;

    private JLabel label;
    private JFileChooser chooser;

    public ImageViewerFrame()
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

        setTitle("FileChooserTest");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Pasek MENU
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Plik");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Otwórz");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());

        menu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Zamknij");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(panel);

        // Etykieta do wyświetlania obrazów
        label = new JLabel("Test");
        panel.add(label);

        add(scrollPane);

        // Okno wyboru plików
        chooser = new JFileChooser();

        /**
         * Akceptuje wszystkie pliki obrazów z rozszerzeniem .jpg .jpeg .gif
         *
         final ExtensionFileFilter filter = new ExtensionFileFilter();
         filter.addExtension("jpg");
         filter.addExtension("jpeg");
         filter.addExtension("gif");
         filter.setDescription("Pliki obrazów");
         */
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Pliki obrazów", "jpg", "jpeg", "gif");
        FileNameExtensionFilter filter_2 = new FileNameExtensionFilter("Pliki instalacyjne", "exe");
        chooser.addChoosableFileFilter(filter);
        chooser.addChoosableFileFilter(filter_2);
//        chooser.setFileFilter(filter);

        chooser.setFileView(new FileIconView(filter, new ImageIcon("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9\\palette.gif")));

        chooser.setAccessory(new ImagePreviewer(chooser));
    }

    /**
     * Słuchacz elementu menu Plik --> Otwórz
     */
    private class FileOpenListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            chooser.setCurrentDirectory(new File("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_9"));

            // Wyświetlanie okna dialogowego wyboru plików
            int result = chooser.showDialog(ImageViewerFrame.this, "Wybierz");

            // Jeśli plik obrazu jest zaakceptowany, jest ustawiany jako ikona etykiety
            if (result == JFileChooser.APPROVE_OPTION)
            {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        }
    }
}

/**
 * Widok plików wyświetlający ikonę obok wszystkich plików zaakceptowanych przez filtr
 */
class FileIconView extends FileView
{
    /**
     * Tworzy obiekt FileIconView
     *
     * @param filter filtr plików - wszystkie pliki zaakceptowane przez ten filtr będą miały ikonę
     * @param icon   ikona wyświetlana obok wszystkich zaakceptowanych plików
     */
    private FileFilter filter;
    private Icon icon;

    public FileIconView(FileFilter filter, Icon icon)
    {
        this.filter = filter;
        this.icon = icon;
    }

    public Icon getIcon(File f)
    {
        if ( ! f.isDirectory() && filter.accept(f))     // jeżeli plik nie jest FOLDEREM i filtr akceptuje rozszerzenie pliku "f" to zwróć ikonę
        {
            return icon;
        }
        else
        {
            return null;
        }
    }
}


/**
 * Akcesorium wyświetlające podgląd obrazów
 */
class ImagePreviewer extends JLabel
{
    /**
     * Tworzy obiekt ImagePreviewer
     *
     * @param chooser okno wyboru plików, którego własność zmienia się, powoduje zmianę obrazu w tym podglądzie
     */
    public ImagePreviewer(JFileChooser chooser)
    {
        setPreferredSize(new Dimension(100, 100));
        setBorder(BorderFactory.createEtchedBorder());

        chooser.addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent event)
            {
                if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
                {
                    // Użytkownik wybrał inny plik
                    File f = (File) event.getNewValue();
                    if (f == null)
                    {
                        setIcon(null);
                        return;
                    }

                    // Wczytanie obrazu jako ikony
                    ImageIcon icon = new ImageIcon(f.getPath());

                    // Skalowanie obrazu, jeśli jest zbyt duży na ikonę
                    if (icon.getIconWidth() > getWidth())
                    {
                        icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));
                    }
                    setIcon(icon);
                }
            }
        });
    }
}
