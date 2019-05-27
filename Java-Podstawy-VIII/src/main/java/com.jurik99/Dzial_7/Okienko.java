package Dzial_7;

import javax.swing.*;

public class Okienko extends JFrame
{
    public static void main(String[] args)
    {
        String szerokosc = JOptionPane.showInputDialog("Podaj szerokość okienka: ");
        int width = Integer.parseInt(szerokosc);
        String wysokosc = JOptionPane.showInputDialog("Podaj wysokość okienka: ");
        int height = Integer.parseInt(wysokosc);

        Okienko window = new Okienko();
        window.setSize(width,height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
