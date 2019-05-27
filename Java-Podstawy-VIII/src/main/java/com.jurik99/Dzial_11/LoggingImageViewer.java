package Dzial_11;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public class LoggingImageViewer
{
    public static void main(String[] args)
    {
        if (System.getProperty("java.me.jurik99.util.logging.config.class") == null && System.getProperty("java.me.jurik99.util.config.file") == null)
        {
            try
            {
                Logger.getLogger("Dzial_11").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 3;
                Handler handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("Dzial_11").addHandler(handler);
            }
            catch (IOException e)
            {
                Logger.getLogger("Dzial_11").log(Level.SEVERE, "Nie można utworzyć handlera pliku dziennika", e);
            }
        }

        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                Handler windowHandler = new WindowHandler();
                windowHandler.setLevel(Level.ALL);
                Logger.getLogger("Dzial_11").addHandler(windowHandler);

                JFrame frame = new ImageViewerFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Logger.getLogger("Dzial_11").fine("Wyświetlanie ramki");
                frame.setVisible(true);
            }
        });
    }
}

/**
 * Ramka zawierająca obraz
 */
class ImageViewerFrame extends JFrame
{
    private JLabel label;
    private static Logger logger = Logger.getLogger("Dzial_11");
    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;

    public ImageViewerFrame()
    {
        logger.entering("ImageViewerFrame", "<init>");
        setTitle("LoggingImageViewer");
        setSize(WIDTH, HEIGHT);


        // Pasek menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Plik");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Otwórz");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());

        JMenuItem exitItem = new JMenuItem("Zakończ");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                logger.fine("Kończenie");
                System.exit(0);
            }
        });


        // Etykieta
        label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        add(label, SwingConstants.CENTER);
        logger.exiting("ImageViewerFrame", "<init>");

    }


    private class FileOpenListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", event);

            // Okno wyboru plików
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            // Akceptowanie wszystkich plików z rozszerzeniem .gif
            chooser.setFileFilter(new FileFilter()
            {
                @Override
                public boolean accept(File f)
                {
                    return f.getName().endsWith(".gif") || f.isDirectory();
                }

                @Override
                public String getDescription()
                {
                    return "Obrazy gif";
                }
            });

            // Wyświetlanie okna dialogowego wyboru plików
            int r = chooser.showOpenDialog(ImageViewerFrame.this);

            // Jeśli plik obrazu został zaakceptowany, jest on ustawiany jako ikona etykiety
            if (r == JFileChooser.APPROVE_OPTION)
            {
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE, "Wczytywanie pliku {0}", name);
                label.setIcon(new ImageIcon(name));
            }
            else
                logger.fine("Anulowano okno otwierania pliku.");
            logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");
        }
    }

}

/**
 * Klasa Handler wyświetlająca rekordy dziennika w oknie
 */
class WindowHandler extends StreamHandler   // tworzy obiekt HANDLER zapisujący do plików
{
    private JFrame frame;

    public WindowHandler()
    {
        frame = new JFrame();
        final JTextArea output = new JTextArea();
        output.setEditable(false);
        frame.setSize(400, 200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream()
        {
            @Override
            public void write(int b) throws IOException
            {
                // nie jest wywoływana
            }

            public void write(byte[] b, int off, int len)
            {
                output.append(new String(b, off, len));
            }
        });
    }

    public void publish(LogRecord record)
    {
        if (!frame.isVisible())return;
        super.publish(record);      // wysyła rekord w odpowiednie miejsce
        flush();    // opróżnia bufor
    }
}