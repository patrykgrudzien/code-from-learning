package Dzial_7;

import javax.swing.UIManager;

public class AllStyles
{
    public static void main(String[] args)
    {
        UIManager.LookAndFeelInfo[] styles = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo s : styles)
        {
            System.out.println(s.getName());
            System.out.println(s.getClassName());
            System.out.println();
        }
    }
}
