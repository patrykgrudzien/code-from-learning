package Dzial_7;

import java.awt.*;

public class ListFonts
{
    public static void main(String[] args)
    {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for(String font : fontNames)
            System.out.println(font);

        System.out.println("\nLiczba czcionek: " +fontNames.length);
    }
}
