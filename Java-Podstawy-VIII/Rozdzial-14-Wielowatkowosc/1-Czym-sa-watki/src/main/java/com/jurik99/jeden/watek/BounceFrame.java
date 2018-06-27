package com.jurik99.jeden.watek;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame
{
	private static final long serialVersionUID = 7651021870525336837L;

	private BallComponent ballComponent;
	private static final int STEPS = 1000;
	private static final int DELAY = 3;

	/*
	 * Tworzy ramke z komponentem zawierajacym odbijajaca sie pilke oraz przyciskami "Start" i "Zamknij"
	 */

	public BounceFrame()
	{
		setTitle("Piłka");

		ballComponent = new BallComponent();
		add(ballComponent, BorderLayout.CENTER);

		final JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", actionEvent -> addBall());
		addButton(buttonPanel, "Zamknij", actionEvent -> System.exit(0));

		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}

	/*
	 * Dodaje odbijajaca sie pilke do panelu i odbija ja 1000 razy
	 */
	public void addBall()
	{
		try
		{
			final Ball ball = new Ball();
			ballComponent.addBall(ball);

			for (int i = 0; i <= STEPS; i++)
			{
				ball.move(ballComponent.getBounds());
				ballComponent.paint(ballComponent.getGraphics());
				Thread.sleep(DELAY);
			}
		}
		catch (final InterruptedException exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * Dodaje przycisk do kontenera
	 * @param container kontener
	 * @param title tytul przycisku
	 * @param listener sluchacz akcji przycisku
	 */
	public void addButton(final Container container, final String title, final ActionListener listener)
	{
		final JButton button = new JButton(title);
		container.add(button);
		button.addActionListener(listener);
	}
}
