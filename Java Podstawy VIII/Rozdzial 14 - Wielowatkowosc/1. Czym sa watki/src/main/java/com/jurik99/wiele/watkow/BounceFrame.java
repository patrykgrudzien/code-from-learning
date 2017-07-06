package com.jurik99.wiele.watkow;

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
	@SuppressWarnings("Duplicates")
	public void addBall()
	{
		final Ball ball = new Ball();
		ballComponent.addBall(ball);

		final Runnable ballRunnable = new BallRunnable(ball, ballComponent);
		final Thread thread = new Thread(ballRunnable);
		thread.start();
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
