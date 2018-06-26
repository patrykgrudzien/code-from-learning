package SmallerScale.Singleton.Controller;

import SmallerScale.Singleton.Model.Model;
import SmallerScale.Singleton.View.LoginFormEvent;
import SmallerScale.Singleton.View.LoginListener;
import SmallerScale.Singleton.View.View;

public class Controller implements LoginListener {

	private Model model;
	private View view;

	public Controller(final Model model, final View view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void loginPerformed(final LoginFormEvent event) {
		System.out.println("Login event received. " + event.getName() + ": " + event.getPassword());
	}
}
