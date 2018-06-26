package Structural.MVC.Controller;

import Structural.MVC.Model.Model;
import Structural.MVC.View.View;

public class Controller {

	private Model model;
	private View view;

	public Controller(final Model model, final View view) {
		this.model = model;
		this.view = view;
	}
}
