package com.jurik99.jeden.watek;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.EventQueue;

public class BounceMain
{
	public static void main(final String[] args)
	{
		EventQueue.invokeLater(() ->
		                       {
			                       final JFrame frame = new BounceFrame();
			                       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			                       frame.setVisible(true);
		                       });
	}
}