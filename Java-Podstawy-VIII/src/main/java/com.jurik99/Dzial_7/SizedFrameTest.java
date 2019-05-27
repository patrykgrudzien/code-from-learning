package Dzial_7;

import javax.swing.*;
import java.awt.*;

public class SizedFrameTest
{
    public static void main(String[] args)
    {
        SizedFrame window = new SizedFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}

class SizedFrame extends JFrame
{
    public SizedFrame()
    {
        // --- Sprawdzanie wymiarow ekranu --- //
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // INNY mozliwy zapis //
//        int szerokosc = Toolkit.getDefaultToolkit().getScreenSize().width;
//        int wysokosc = Toolkit.getDefaultToolkit().getScreenSize().height;

        // --- Ustawienie szerokosci i wysokosci ramki oraz jej polozenie --- //
        setSize(screenWidth/3, screenHeight/3);
        setLocationRelativeTo(null);

        // --- Ustawienie ikony i tytulu --- //
        Image img = new ImageIcon(this.getClass().getResource("Ikona.jpg")).getImage();
        setIconImage(img);
        setTitle("Moje okienko");
    }

}
