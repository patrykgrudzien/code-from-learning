package Dzial_9;

import java.awt.*;

public class All_Fonts
{
    public static void main(String[] args)
    {
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] allFonts = e.getAllFonts();

        for (Font f : allFonts)
        {
            System.out.println(f.getName());
        }
    }
}
