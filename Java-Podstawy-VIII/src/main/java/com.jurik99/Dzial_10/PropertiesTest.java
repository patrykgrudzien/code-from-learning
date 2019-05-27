package Dzial_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Program testujący mechanizm własności.
 * Niniejszy program zapamiętuje położenie, rozmiar i tytuł ramki.
 */
public class PropertiesTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                PropertiesTestFrame frame = new PropertiesTestFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * Ramka pobierająca dane dotyczące położenia i rozmiaru z pliku własności
 * oraz aktualizująca ów plik w momencie zamykania programu
 */
class PropertiesTestFrame extends JFrame
{
    private File propertiesFile;
    private Properties settings;

    public PropertiesTestFrame()
    {
        // Sprawdzanie położenia, rozmiaru i tytułu w pliku własności
        String userDir = System.getProperty("user.home");
        File propertiesDir = new File(userDir, ".JuRik_settings");
        if (!propertiesDir.exists())
            propertiesDir.mkdir();
        propertiesFile  = new File(propertiesDir, "program.properties");

        Properties defaultSettings = new Properties();
        defaultSettings.put("left", "500");
        defaultSettings.put("top", "500");
        defaultSettings.put("width", "300");
        defaultSettings.put("height", "200");
        defaultSettings.put("title", "");

        settings = new Properties(defaultSettings);

        if (propertiesFile.exists())
            try
            {
                FileInputStream in = new FileInputStream(propertiesFile);
                settings.load(in);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        int left = Integer.parseInt(settings.getProperty("left"));
        int top = Integer.parseInt(settings.getProperty("top"));
        int width = Integer.parseInt(settings.getProperty("width"));
        int height = Integer.parseInt(settings.getProperty("height"));
        setBounds(left, top, width, height);


        // Jeśli nie ma tytułu, użytkownik zostanie poproszony o jego podanie
        String title = settings.getProperty("title");
        if (title.equals(""))
            title = JOptionPane.showInputDialog("Wpisz tytuł dla ramki:");
        if (title == null)
            title = "";
        setTitle(title);


        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                settings.put("left", "" +getX());
                settings.put("top", "" +getY());
                settings.put("width", "" +getWidth());
                settings.put("height", "" +getHeight());
                settings.put("title", "" +getTitle());

                try
                {
                    FileOutputStream out = new FileOutputStream(propertiesFile);
                    settings.store(out, "Ustawienia programu");
                }
                catch (FileNotFoundException e1)
                {
                    e1.printStackTrace();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }

                System.exit(0);
            }
        });
    }
}
