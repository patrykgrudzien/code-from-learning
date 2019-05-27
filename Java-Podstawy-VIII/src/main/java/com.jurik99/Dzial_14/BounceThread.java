package Dzial_14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class BounceThread
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame frame = new BounceFrame2();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * Klasa implementująca interfejs Runnable i tworząca animację piłki
 */
class BallRunable implements Runnable
{
    private Ball2 ball2;
    private Component component;
    public static int DELAY = 6;

    /**
     * Tworzy obiekt Runnable
     * @param ball2 piłka
     * @param component komponent, w którym odbija się piłka
     */
    public BallRunable(Ball2 ball2, Component component)
    {
        this.ball2 = ball2;
        this.component = component;
    }
    @Override
    public void run()
    {
        try
        {
            while (ball2.getX() < component.getWidth() && ball2.getY() < component.getHeight())
            {
                ball2.move(component.getBounds());
                component.repaint();
                Thread.sleep(DELAY);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void setDELAY(int DELAY)
    {
        BallRunable.DELAY = DELAY;
    }

    public static int getDELAY()
    {
        return DELAY;
    }
}

/**
 * Ramka z panelem i przyciskami
 */
class BounceFrame2 extends JFrame
{
    private BallComponent2 component2;
    private Thread thread;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    // Tworzy ramkę z komponentem zawierającym piłkę i przyciski Start i Zamknij
    public BounceFrame2()
    {
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }

        setSize(WIDTH, HEIGHT);
        setTitle("BounceThread");
        setLocationRelativeTo(null);

        component2 = new BallComponent2();
        add(component2, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();

        addButton(buttonPanel, "Dodaj kulkę", new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BallRunable.getDELAY();
                addBall();
            }
        });

        addButton(buttonPanel, "Normal", new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BallRunable.setDELAY(6);
            }
        });

        addButton(buttonPanel, "Szybciej", new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BallRunable.setDELAY(4);
            }
        });

        addButton(buttonPanel, "TURBO", new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BallRunable.setDELAY(2);
            }
        });

        addButton(buttonPanel, "Zamknij", new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Dodaje przycisk do kontenera
     */
    public void addButton(Container container, String title, ActionListener listener)
    {
        JButton button = new JButton(title);
        container.add(button);
        button.addActionListener(listener);
    }

    /**
     * Dodaje piłkę do obszaru roboczego i uruchamia wątek wykonujący kod odpowiedzialny za jej odbijanie
     */
    public void addBall()
    {
        Ball2 b = new Ball2();
        component2.add(b);
        Runnable r = new BallRunable(b, component2);
        thread = new Thread(r);
        thread.start();
    }

}

/**
 * Piłka, która porusza się i odbija od krawędzi prostokąta
 */
class Ball2
{
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 2;
    private double dy = 0.15;

    /**
     * Przesuwa piłkę do następnego położenia, odwracając kierunek, jeśli piłka uderzy w krawędź
     */
    public void move(Rectangle2D bounds)
    {
        x += dx;
        y += dy;

        /**
         * getX() - when I need the location of the shape, a point
         * getMinX() - when I need the left bound of the shape
         */
        if (x < bounds.getX())
        {
            x = bounds.getX();
            dx = -dx;
        }
        if (x + XSIZE >= bounds.getX() + bounds.getWidth())
        {
            x = bounds.getX() + bounds.getWidth() - XSIZE;
            dx = -dx;
        }
        if (y < bounds.getY())
        {
            y = bounds.getY();
            dy = -dy;
        }
        if (y + YSIZE >= bounds.getY() + bounds.getHeight())
        {
            y = (bounds.getY() + bounds.getHeight()) * 3;
        }
    }

    /**
     * Ustawia kształt piłki w jej aktualnym położeniu
     */
    public Ellipse2D getShape()
    {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }
}


/**
 * Komponent rysujący piłki
 */
class BallComponent2 extends JPanel
{
    private ArrayList<Ball2> balls = new ArrayList<Ball2>();
    private ArrayList<Color> colors = new ArrayList<Color>();

    /**
     * Dodaje piłkę do komponentu
     *
     * @param b piłka, która ma zostać dodana
     */
    public void add(Ball2 b)
    {
        balls.add(b);
    }

    public void removeBall()
    {
        if (balls.size() == 1)
        {
            balls.remove(balls.size());
            repaint();
        }
        else if (balls.size() > 1)
        {
            int index = balls.size() - 1;
            balls.remove(index);
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);    // czyszczenie tła
        setBackground(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        colors.add(new Color(red, green, blue));

//        colors.add(Color.RED);
//        colors.add(Color.GREEN);
//        colors.add(Color.BLUE);
//        colors.add(Color.YELLOW);

        for (int i = 0; i < balls.size(); i++)
        {
            g2.setPaint(colors.get(i));
            if (colors.get(i) == this.getBackground())
            {
                g2.setPaint(Color.WHITE);
            }
            g2.fill(balls.get(i).getShape());
        }
    }
}
