package Dzial_11;

import javax.swing.*;

/**
 * A frame with a button panel
 * @version 1.31 2004-05-11
 * @author Cay Horstmann
 */
class ButtonFrame_2 extends JFrame
{
   public ButtonFrame_2()
   {
      setTitle("ButtonTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // add panel to frame

      ButtonPanel_2 panel = new ButtonPanel_2();
      add(panel);
   }

   public static final int DEFAULT_WIDTH = 300;
   public static final int DEFAULT_HEIGHT = 200;
}
