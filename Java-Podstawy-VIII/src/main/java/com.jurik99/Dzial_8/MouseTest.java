package Dzial_8;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class MouseTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                MouseFrame frame = new MouseFrame();
            }
        });
    }
}

/**
 * RAMKA ZAWIERAJACA PANEL TESTUJACY DZIALANIA MYSZY
 */
class MouseFrame extends JFrame
{
    public MouseFrame()
    {
        super("");
        setTitle("MouseTest");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Dodanie komponentu do ramki
        MouseComponent component = new MouseComponent();
        add(component);
    }
}

/**
 * KOMPONENT Z DZIALANIAMI MYSZY, DO KTOREGO MOZNA DODAWAC (LUB Z KTOREGO MOZNA USUWAC) KWADRATY
 */
class MouseComponent extends JComponent
{
    private static final int SIDELENGTH = 30;
    private ArrayList<Rectangle2D> kwadraty;
    private Rectangle2D current;

// ------------------------------------------------------------------------------------------------------ //
    public MouseComponent()
    {
        kwadraty = new ArrayList<Rectangle2D>();
        current = null;
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

// ------------------------------------------------------------------------------------------------------ //
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        // Rysowanie wszystkich kwadratow
        for (Rectangle2D r : kwadraty)
        {
            g2.setPaint(Color.BLACK);
            g2.fill(r);
            g2.draw(r);
        }
    }


    /**
     * ZNAJDUJE PIERWSZY KWADRAT ZAWIERAJACY PUNKT.
     * @param punkt - punkt
     * @return - pierwszy kwadrat zawierajacy punkt p
     */
    public Rectangle2D find(Point2D punkt)
    {
        for (Rectangle2D r : kwadraty)
        {
            if (r.contains(punkt))  return r;
        }
        return null;
    }

    /**
     * DODAJE KWADRAT DO ZBIORU.
     * @param p - srodek kwadratu
     */
    public void add(Point2D p)
    {
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
        kwadraty.add(current);
        repaint();
    }


    /**
     * USUWA KWADRAT ZE ZBIORU.
     * @param s - kwadrat, ktory ma byc usuniety
     */
    public void remove(Rectangle2D s)
    {
        if (s == null) return;
        if (s == current) current = null;
        kwadraty.remove(s);
        repaint();
    }


    /**
     * KWADRAT ZAWIERAJACY KURSOR MYSZY
     */
    private class MouseHandler extends MouseAdapter
    {
        public void mousePressed(MouseEvent event)
        {
            // Dodanie nowego kwadratu, jesli kursor nie jest wewnatrz innego kwadratu
            current = find(event.getPoint());
            if (current == null)    add(event.getPoint());
        }

        public void mouseClicked(MouseEvent event)
        {
            // Usuniecie kwadratu w wyniku jego dwukrotnego klikniecia
            current = find(event.getPoint());
            if (current != null && event.getClickCount() >= 2)  remove(current);
        }
    }


// ------------------------------------------------------------------------------------------------------ //
    private class MouseMotionHandler implements MouseMotionListener
    {
        @Override
        public void mouseMoved(MouseEvent event)
        {
            // Ustawianie kursona na krzyzyk. jesli znajduje sie wewnatrz kwadratu
            if (find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }

        @Override
        public void mouseDragged(MouseEvent event)
        {
            if (current != null)
            {
                int x = event.getX();
                int y = event.getY();

                // Przeciagniecie aktualnego kwadratu w celu wycentrowania go w pukcie (x,y)
                current.setFrame(x - SIDELENGTH/2, y - SIDELENGTH/2, SIDELENGTH, SIDELENGTH);
                repaint();
            }
        }
    }
}