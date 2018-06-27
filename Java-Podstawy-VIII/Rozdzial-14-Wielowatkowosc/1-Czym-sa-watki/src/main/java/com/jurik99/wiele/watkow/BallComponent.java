package com.jurik99.wiele.watkow;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class BallComponent extends JPanel
{
	private static final long serialVersionUID = 1084269849995196308L;

	private static final int DEFAULT_WIDTH = 450;
	private static final int DEFAULT_HEIGHT = 350;

	private List<Ball> balls = new ArrayList<>();

	/**
	 * Dodaje pilke do komponentu
	 * @param ball pilka, ktora ma zostac dodana
	 */
	public void addBall(final Ball ball)
	{
		balls.add(ball);
	}

	@Override
	public void paintComponent(final Graphics graphics)
	{
		// --- czyszczenie tla ---
		super.paintComponent(graphics);

		final Graphics2D graphics2D = (Graphics2D) graphics;

		for (final Ball ball : balls)
		{
			graphics2D.fill(ball.getEllipseShape());
		}
	}

	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
