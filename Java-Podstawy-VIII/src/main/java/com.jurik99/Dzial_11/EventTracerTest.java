package Dzial_11;


import javax.swing.*;
import java.awt.*;

public class EventTracerTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame frame = new EventTracerFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class EventTracerFrame extends JFrame
{
    public EventTracerFrame()
    {
        setTitle("EventTracerTest");
        setSize(400, 400);

        // Dodanie suwaka i przycisku
        add(new JSlider(), BorderLayout.NORTH);
        add(new JButton("Test"), BorderLayout.SOUTH);

        // Przechwytywanie wszystkich zdarzeń komponentów znajdujących się w ramce
        EventTracer tracer = new EventTracer();
        tracer.add(this);
    }
}
