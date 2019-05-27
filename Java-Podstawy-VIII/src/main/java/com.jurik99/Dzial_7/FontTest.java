package Dzial_7;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class FontTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new FontFrame();
                frame.setTitle("FontTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}

// --- Ramka z komponentem zawierajacym tekst --- //
class FontFrame extends JFrame
{
    public FontFrame()
    {
        add(new FontComponent());
        pack();
    }
}


// --- Komponent z tekstem w ramce na srodku --- //
class FontComponent extends JComponent
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        String message = "Witaj świecie!";

        Font czcionka = new Font("Serif", Font.BOLD, 36);
        g2.setFont(czcionka);

        // Sprawdzenie rozmiaru tekstu
        FontRenderContext context = g2.getFontRenderContext();  // obiekt reprezentujacy wlasnosci czcionki urzadzenia z ekranem
        Rectangle2D bounds = czcionka.getStringBounds(message, context);

        // (x,y) = lewy gorny rog tekstu
        double x = (getWidth() - bounds.getWidth()) / 2;
        double y = (getHeight() - bounds.getHeight()) / 2;

        // Dodanie wydluzenia gornego do y w celu siegniecia do linii bazowej
        double ascent = -bounds.getY();
        double baseY = y + ascent;

        // Rysowanie komunikatu
        g2.drawString(message, (int) x, (int) baseY);
        g2.setPaint(Color.BLUE);

        // Rysowanie linii bazowej
        g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));

        // Rysowanie otaczajacego tekst prostokata
        Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
        g2.draw(rect);
    }

    // --------------------------------------------
    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}