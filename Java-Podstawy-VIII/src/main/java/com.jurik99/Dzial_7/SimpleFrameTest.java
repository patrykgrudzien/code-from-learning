package Dzial_7;

import javax.swing.JFrame;

public class SimpleFrameTest
{
    public static void main(String[] args)
    {
        SimpleFrame frame = new SimpleFrame();
        frame.setTitle("Przykładowe okno");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

class SimpleFrame extends JFrame
{
    public SimpleFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
}
