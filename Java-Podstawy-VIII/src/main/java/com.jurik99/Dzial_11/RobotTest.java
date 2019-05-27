package Dzial_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class RobotTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                // Ramka z panelem zawierającym przycisk
                ButtonFrame_2 frame = new ButtonFrame_2();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                // Powiązanie robota z ekranem
                GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
//                GraphicsDevice[] screen = environment.getScreenDevices();
                GraphicsDevice screen = environment.getDefaultScreenDevice();

                try
                {
//                    for (int i=0; i<screen.length; i++)
//                    {
//                        Robot robot = new Robot(screen[i]);
//                        runTest(robot);
//                    }
                    Robot robot = new Robot(screen);
                    runTest(robot);
                }
                catch (AWTException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Uruchamia procedurę testową.
     * @param robot robot związany z ekranem
     */
    public static void runTest(Robot robot)
    {
        // Symulacja naciśnięcia spacji
        robot.keyPress(' ');
        robot.keyRelease(' ');

        // Symulacja naciśnięcia klawisza Tab i spacji
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(' ');
        robot.keyRelease(' ');

        // Symulacja kliknięcia myszą prawego przycisku w oknie
        robot.delay(2000);
        robot.mouseMove(200, 50);
        robot.mousePress(MouseEvent.BUTTON1_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_MASK);

        // Zrobienie zrzutu ekranu i wyświetlenie obrazu
        robot.delay(2000);
        BufferedImage image = robot.createScreenCapture(new Rectangle(0, 0, 400, 300));

        ImageFrame frame = new ImageFrame(image);
        frame.setVisible(true);
    }
}

/**
 * Ramka zawierająca wyświetlany obraz
 */
class ImageFrame extends JFrame
{
    public ImageFrame(Image img)
    {
        setTitle("Zrzut ekranu");
        setSize(450, 350);

        JLabel label = new JLabel(new ImageIcon(img));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        add(label);
    }
}