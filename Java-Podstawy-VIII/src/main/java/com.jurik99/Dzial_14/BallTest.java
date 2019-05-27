package Dzial_14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class BallTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame frame = new BounceFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}


/**
 * Ramka zawierająca komponent piłki i przyciski
 */
class BounceFrame extends JFrame
{
    private BallComponent ballComponent;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 450;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;

    // Tworzy ramkę z komponentem zawierającym odbijającą się piłkę oraz przyciskami Start i Zakmnij
    public BounceFrame()
    {
        setSize(WIDTH, HEIGHT);
        setTitle("Piłka");
        setLocationRelativeTo(null);

        ballComponent = new BallComponent();
        add(ballComponent, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                addBall();
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
     * @param c kontener
     * @param title tytuł przycisku
     * @param listener słuchacz akcji przycisku
     */
    public void addButton(Container c, String title, ActionListener listener)
    {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }


    /**
     * Dodaje odbijającą piłke do panelu i odbija ją 1000 razy
     */
    public void addBall()
    {
        try
        {
            Ball ball = new Ball();
            ballComponent.add(ball);

            for (int i = 1; i <= STEPS; i++)
            {
                ball.move(ballComponent.getBounds());
                ballComponent.paint(ballComponent.getGraphics());
                Thread.sleep(DELAY);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}


/**
 * Piłka, która porusza się i odbija od krawędzi prostokąta
 */
class Ball
{
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    /**
     * Przesuwa piłkę do następnego położenia, odwracając kierunek, jeśli piłka uderzy w krawędź
     */
    public void move(Rectangle2D bounds)
    {
        // bounds = 434 x 376px
        x += dx;
        y += dy;

        /**
         * getX() - when I need the location of the shape, a point
         * getMinX() - when I need the left bound of the shape
         */
        if (x < bounds.getX())
        {
//            x = bounds.getX();
            dx = -dx;
        }
        if (x + XSIZE >= bounds.getX() + bounds.getWidth())
        {
//            x = bounds.getX() + bounds.getWidth() - XSIZE;
            dx = -dx;
        }
        if (y < bounds.getY())
        {
//            y = bounds.getY();
            dy = -dy;
        }
        if (y + YSIZE >= bounds.getY() + bounds.getHeight())
        {
//            y = bounds.getY() + bounds.getHeight() - YSIZE;
            dy = -dy;
        }
    }

    /**
     * Ustawia kształt piłki w jej aktualnym położeniu
     */
    public Ellipse2D getShape()
    {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }
}


/**
 * Komponent rysujący piłki
 */
class BallComponent extends JPanel
{
    private ArrayList<Ball> balls = new ArrayList<Ball>();
    /**
     * Dodaje piłkę do komponentu
     * @param b piłka, która ma zostać dodana
     */
    public void add(Ball b)
    {
        balls.add(b);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);    // czyszczenie tła
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls)
        {
            g2.fill(b.getShape());
        }
    }
}
