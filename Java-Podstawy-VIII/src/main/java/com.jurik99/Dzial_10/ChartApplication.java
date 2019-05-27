package Dzial_10;

import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;

public class ChartApplication
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                ChartApplicationFrame frame = new ChartApplicationFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

//                String v = "9";
//                if (v == null)  return;
//                int n = Integer.parseInt(v);
                double[] values = {3100, 7500, 8000, 4200, 88000, 71000, 32000, 30600, 1430};
                String[] names = {"Merkury", "Wenus", "Ziemia", "Mars", "Jowisz", "Saturn", "Uran", "Neptun", "Pluton"};

                frame.add(new ChartApplicationComponent(values, names, "Średnice planet"));
            }
        });
    }
}


class ChartApplicationFrame extends JFrame
{
    public ChartApplicationFrame()
    {
        setTitle("Tytuł");
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
}


class ChartApplicationComponent extends JComponent
{
    private String title;
    private double[] values;
    private String[] names;

    public ChartApplicationComponent(double[] v, String[] n, String t)
    {
        values = v;
        names = n;
        title = t;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        Font titleFont = new Font("Arial", Font.BOLD, 20);


        // Obliczanie szerokości tytułu
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D titleBounds = titleFont.getStringBounds(title, context);

        double titleWidth = titleBounds.getWidth();
        double top = titleBounds.getHeight();


        // Rysowanie tytułu
        double y = -titleBounds.getY();
//        double y = (panelHeight - top) / 2 - titleBounds.getY();
        double x = (panelWidth - titleWidth) / 2 ;
        g2.setFont(titleFont);
        g2.drawString(title, (float) x, (float) y);


        // Obliczanie szerokości etykiet słupków
        Font labelFont = new Font("Arial", Font.BOLD, 15);
        LineMetrics labelMetrics = labelFont.getLineMetrics("", context);
        double bottom = labelMetrics.getHeight();

        y = panelHeight - labelMetrics.getDescent();
        g2.setFont(labelFont);


        // Obliczanie wartości minimalnej i maksymalnej
        if (values == null) return;

        double minValue = 0;
        double maxValue = 0;

        for (double v : values)
        {
            if (v < minValue)   minValue = v;
            if (v > maxValue)   maxValue = v;
        }
        if (maxValue == minValue)   return;


        // Obliczanie współczynnika skali i szerokości słupków
        double scale = (panelHeight - top - bottom) / (maxValue - minValue);
        int barWidth = panelWidth / values.length;


        // Rysowanie słupków
        for (int i = 0; i < values.length; i++)
        {
            // Uzyskanie współrzędnych prostokąta tworzącego słupek
            double x1 = i*barWidth+1;
            double y1 = top;
            double height = values[i] * scale;
            if (values[i] >= 0)
                y1 += (maxValue - values[i]) * scale;
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
