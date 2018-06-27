package com.jurik99.wiele.watkow;

import java.awt.Component;

public class BallRunnable implements Runnable
{
	private Ball ball;
	private Component component;
	private static final int STEPS = 1000;
	private static final int DELAY = 3;

	/**
	 * Tworzy obiekt Runnable
	 * @param ball pilka
	 * @param component komponent, w ktorym odbija sie pilka
	 */
	public BallRunnable(final Ball ball, final Component component)
	{
		this.ball = ball;
		this.component = component;
	}

	@Override
	public void run()
	{
		try
		{
			for (int i = 0; i <= STEPS; i++)
			{
				ball.move(component.getBounds());
				component.repaint();
				Thread.sleep(DELAY);
			}
		}
		catch (final InterruptedException exception)
		{
			exception.printStackTrace();
		}
	}
}
