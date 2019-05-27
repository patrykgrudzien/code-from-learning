package Dzial_7;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                ImageFrame frame = new ImageFrame();
            }
        });

    }
}

// --- Ramka zawierajaca komponent obrazu --- //
class ImageFrame extends JFrame
{
    public ImageFrame()
    {
        setTitle("ImageTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        ImageComponent component = new ImageComponent();
        add(component);
    }

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
}

// --- Komponent wyswietlajacy powielony obraz --- //
class ImageComponent extends JComponent
{
    public ImageComponent()
    {
        try
        {
            image = ImageIO.read(new File("D:\\Moje Dokumenty\\IntelliJ IDEA\\PROJEKTY\\Java.Podstawy.VIII\\src\\Dzial_7\\blue-ball.gif"));
        }
        catch (IOException e)
        {
            System.err.println("Obraz jest niedostepny!");
        }
    }

    public void paintComponent(Graphics g)
    {
        if (image == null) return;

        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        // RYSOWANIE OBRAZU W LEWYM GORNYM ROGU
        g.drawImage(image, 0, 0, null);

        // POWIELANIE OBRAZU W OBREBIE KOMPONENTU
        for (int i=0; i*imageWidth <= getWidth(); i++)
            for (int j=0; j*imageHeight <= getHeight(); j++)
                if (i+j > 0) g.copyArea(0, 0, imageWidth, imageHeight, i*imageWidth, j*imageHeight);
    }

    private Image image;
}