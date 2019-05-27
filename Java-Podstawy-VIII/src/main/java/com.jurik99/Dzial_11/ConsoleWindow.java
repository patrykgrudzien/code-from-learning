package Dzial_11;

import javax.swing.*;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Okno wyświetlające bajty wysłane do strumieni System.out i System.err
 */
public class ConsoleWindow
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
    public static final int LEFT = 200;
    public static final int TOP = 200;

    public static void init()
    {
        JFrame frame = new JFrame();
        frame.setTitle("ConsoleWindow");
        final JTextArea output = new JTextArea();
        output.setEditable(false);
        frame.add(new JScrollPane(output));
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(LEFT, TOP);
        frame.setFocusableWindowState(false);
        frame.setVisible(true);


        // Definicja strumienia PrintStream wysyłającego swoje bajty do obszaru tekstowego
        PrintStream consoleStream = new PrintStream(new OutputStream()
        {
            @Override
            public void write(int b)
            {
                // nigdy nie wywoływana
            }

            public void write(byte[] b,int off, int len)
            {
                output.append(new String(b, off, len));
            }
        });


        // Ustawienie strumieni System.out i System.err na powyższy strumień
        System.setOut(consoleStream);
        System.setErr(consoleStream);
    }
}
