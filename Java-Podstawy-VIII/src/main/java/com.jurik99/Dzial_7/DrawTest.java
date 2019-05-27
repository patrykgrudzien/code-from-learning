package Dzial_7;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class DrawTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                DrawFrame ramka = new DrawFrame();
                ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ramka.setVisible(true);
            }
        });
    }
}

// --- Ramka zawierajaca panel z rysunkami --- //
class DrawFrame extends JFrame
{
    public DrawFrame()
    {
        setTitle("DrawTest");
        setSize(DEFAULT_WIDTH, DEFAUL_HEIGHT);
        setLocationRelativeTo(null);

        // Dodanie panelu do ramki
        DrawComponent panel = new DrawComponent();
        add(panel);
    }

    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAUL_HEIGHT = 400;
}

// --- Komponent wyswietlajacy prostokaty i elipsy --- //
class DrawComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;

        // --- Rysowanie PROSTOKATA --- //
        double lefX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;

        Rectangle2D prostokat = new Rectangle2D.Double(lefX, topY, width, height);
        g2.draw(prostokat);

        // --- Rysowanie ELIPSY --- //
        Ellipse2D elipsa = new Ellipse2D.Double();
        elipsa.setFrame(prostokat);
        g2.setPaint(Color.blue);
        g2.fill(elipsa);
        g2.draw(elipsa);

        // --- Rysowanie PRZEKATNEJ --- //
        g2.draw(new Line2D.Double(lefX, topY, lefX + width, topY + height));

        // --- Rysowanie KOLA --- //
        double centerX = prostokat.getCenterX();
        double centerY = prostokat.getCenterY();
        double promien = 150;

        Ellipse2D kolo = new Ellipse2D.Double();
        kolo.setFrameFromCenter(centerX, centerY, centerX + promien, centerY + promien);
        g2.draw(kolo);

        // --- Rysowanie LINII pomiedzy dwoma punktami --- //
        Point2D.Float punktA = new Point.Float(200,200);
        Point2D.Float punktB = new Point.Float(300,300);
        Line2D.Float linia = new Line2D.Float(punktA, punktB);
        g2.setPaint(Color.RED);
        g2.draw(linia);

        // --- Drukowanie napisu --- //
        g2.setPaint(new Color(255,0,0));
        g2.drawString("UWAGA!", 250, 250);

    }
}