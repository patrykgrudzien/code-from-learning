package Structural.MVC.View;

import Structural.MVC.Model.Model;

import javax.swing.JFrame;

public class View extends JFrame {

	private Model model;

	public View(final Model model) {
		super("MVC Demo");

		this.model = model;
	}
}
