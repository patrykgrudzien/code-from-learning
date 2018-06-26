package Structural.Observer.View;

import Structural.Observer.Model.Model;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

	private Model model;
	private JButton okButton;
	private JTextField nameField;
	private JPasswordField passField;

	private LoginListener loginListener;

	public View(final Model model) {
		super("MVC Demo");

		this.model = model;

		nameField = new JTextField(10);
		passField = new JPasswordField(10);
		okButton = new JButton("OK");

		setLayout(new GridBagLayout());

		final GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(100, 0, 0, 10);
		gc.fill = GridBagConstraints.NONE;

		add(new JLabel("Name: "), gc);

		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx = 2;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(100, 0, 0, 0);
		gc.fill = GridBagConstraints.NONE;

		add(nameField, gc);

		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 10);
		gc.fill = GridBagConstraints.NONE;

		add(new JLabel("Password: "), gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 2;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill = GridBagConstraints.NONE;

		add(passField, gc);

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 2;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 100;
		gc.fill = GridBagConstraints.NONE;

		add(okButton, gc);
		okButton.addActionListener(this);

		setSize(600, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final String password = new String(passField.getPassword());
		final String name = nameField.getText();

		fireLoginEvent(new LoginFormEvent(name, password));
	}

	/**
	 * We want to pass ANYTHING WHICH IMPLEMENTS "LoginListener" INTERFACE
	 * <p>
	 * We want to store reference to the object which IMPLEMENTS "LoginListener" interface
	 */
	public void setLoginListener(final LoginListener loginListener) {
		this.loginListener = loginListener;
	}

	private void fireLoginEvent(final LoginFormEvent event) {
		if (loginListener != null) {
			loginListener.loginPerformed(event);
		}
	}
}
