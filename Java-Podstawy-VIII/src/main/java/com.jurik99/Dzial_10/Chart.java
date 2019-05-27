package Dzial_10;

import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;

public class Chart extends JApplet
{
    public void init()
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                String v = getParameter("values");
                if (v == null)  return;

                int n = Integer.parseInt(v);
                double[] values = new double[n];
                String[] names = new String[n];

                for (int i = 0; i < n; i++)
                {
                    values[i] = Double.parseDouble(getParameter("value." + (i + 1)));
                    names[i] = getParameter("name" + (i+1) );
                }
                add(new ChartComponent(values, names, getParameter("title")));
            }
        });
    }
}

/**
 * Komponent rysujący wykres słupkowy
 */
class ChartComponent extends JComponent
{
    private double[] values;
    private String[] names;
    private String title;

    /**
     * Tworzy obiekt typu ChartComponent
     *
     * @param v tablica wartości wykresu
     * @param n tablica nazw wartości
     * @param t tytuł wykresu
     */
    public ChartComponent(double[] v, String[] n, String t)
    {
        values = v;
        names = n;
        title = t;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        // Obliczanie wartości minimalnej i maksymalnej
        if (values == null) return;
        double minValue = 0;
        double maxValue = 0;

        for (double v : values)
        {
            if (minValue > v)   minValue = v;
            if (maxValue < v)   maxValue = v;
        }
        if (maxValue == minValue)   return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        Font titleFont = new Font("SansSerif", Font.BOLD, 20);
        Font labelFont = new Font("SansSerif", Font.PLAIN, 10);

        // Obliczanie szerokości tytułu
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D titleBounds = titleFont.getStringBounds(title, context);
        double titleWidth = titleBounds.getWidth();
        double top = titleBounds.getHeight();

        // Rysowanie tytułu
        double y = -titleBounds.getY();
        double x = (panelWidth - titleWidth) / 2;
        g2.setFont(titleFont);
        g2.drawString(title, (float) x, (float) y);

        // Obliczanie szerokości etykiet słupków
        LineMetrics labelMetrics = labelFont.getLineMetrics("", context);
        double bottom = labelMetrics.getHeight();

        y = panelHeight - labelMetrics.getDescent();
        g2.setFont(labelFont);

        // Obliczanie współczynnika skali i szerokości słupków
        double scale = (panelHeight - top - bottom) / (maxValue - minValue);
        int barWidth = panelWidth / values.length;

        // Rysowanie słupków
        for (int i = 0; i < values.length; i++)
        {
            // Uzyskanie współrzędnych prostokąta tworzącego słupek
            double x1 = i*barWidth + 1;
            double y1 = top;
            double height = values[i] * scale;
            if (values[i] >= 0)
            {
                y1 =+ (maxValue - values[i]) * scale;
            }
            else
            {
                y1 += maxValue * scale;
                height = -height;
            }

            // Wypełnienie słupka i rysowanie jego obrysu
            Rectangle2D rect = new Rectangle2D.Double(x1, y1, barWidth - 2, height);
            g2.setPaint(Color.RED);
            g2.fill(rect);
            g2.setPaint(Color.BLACK);
            g2.draw(rect);

            // Rysowanie etykiety na środku pod słupkiem
            Rectangle2D labelBounds = labelFont.getStringBounds(names[i], context);
            double labelWidth = labelBounds.getWidth();
            x = x1 + (barWidth - labelWidth) / 2;
            g2.drawString(names[i], (float) x, (float) y);
        }

    }
}
