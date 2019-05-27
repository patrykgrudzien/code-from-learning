package Dzial_10;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.prefs.BackingStoreException;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;

public class PreferencesTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                PreferencesTestFrame frame = new PreferencesTestFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * Ramka pobierająca dane dotyczące położenia i rozmiaru z preferencji użytkownika
 * oraz aktualizująca preferencje w momencie zamykania programu.
 */
class PreferencesTestFrame extends JFrame
{
    public PreferencesTestFrame()
    {
        // Sprawdzenie położenia, rozmiaru oraz tytułu w preferencjach
        Preferences root = Preferences.userRoot();
        final Preferences node = root.node("Dzial_10");
        int left = node.getInt("left", 800);
        int top = node.getInt("top", 500);
        int width = node.getInt("width", 300);
        int height = node.getInt("height", 200);
        setBounds(left, top, width, height);


        // Jeśli nie ma tytułu, użytkownik zostanie poproszony i jego podanie
        String title = node.get("title", "");
        if (title.equals(""))
            title = JOptionPane.showInputDialog("Wpisz tytuł dla ramki:");
        if (title == null)
            title = "";
        setTitle(title);


        // Utworzenie okna wyboru plików wyświetlającego pliki XML
        final JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_10"));


        // Akceptacja wszystkich plików z rozszerzeniem .xml
        chooser.setFileFilter(new FileFilter()
        {
            @Override
            public boolean accept(File f)
            {
                return f.getName().toLowerCase().endsWith(".xml") || f.isDirectory();
            }

            @Override
            public String getDescription()
            {
                return "Pliki XML";
            }
        });


        // Menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("Plik");
        menuBar.add(menu);

        JMenuItem exportItem = new JMenuItem("Eksport ustawień");
        menu.add(exportItem);
        exportItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (chooser.showSaveDialog(PreferencesTestFrame.this) == JFileChooser.APPROVE_OPTION)
                {
                    try
                    {
                        OutputStream outputStream = new FileOutputStream(chooser.getSelectedFile());
                        node.exportSubtree(outputStream);
                        outputStream.close();
                    }
                    catch (FileNotFoundException e1)
                    {
                        e1.printStackTrace();
                    }
                    catch (BackingStoreException e1)
                    {
                        e1.printStackTrace();
                    }
                    catch (IOException e1)
                    {
                        e1.printStackTrace();
                    }
                }
            }
        });

        JMenuItem importItem = new JMenuItem("Import ustawień");
        menu.add(importItem);
        importItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (chooser.showOpenDialog(PreferencesTestFrame.this) == JFileChooser.APPROVE_OPTION)
                {
                    try
                    {
                        InputStream inputStream = new FileInputStream(chooser.getSelectedFile());
                        Preferences.importPreferences(inputStream);
                        inputStream.close();
                    }
                    catch (FileNotFoundException e1)
                    {
                        e1.printStackTrace();
                    }
                    catch (InvalidPreferencesFormatException e1)
                    {
                        e1.printStackTrace();
                    }
                    catch (IOException e1)
                    {
                        e1.printStackTrace();
                    }
                }
            }
        });


        JMenuItem exitItem = new JMenuItem("Zamknij");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                node.putInt("left", getX());
                node.putInt("top", getY());
                node.putInt("width", getWidth());
                node.putInt("height", getHeight());
                node.put("title", getTitle());
                System.exit(0);

            }
        });
    }
}