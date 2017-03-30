package Structural.Observer.Controller;

import Structural.Observer.Model.Model;
import Structural.Observer.View.LoginFormEvent;
import Structural.Observer.View.LoginListener;
import Structural.Observer.View.View;

public class Controller implements LoginListener
{
    private Model model;
    private View view;

    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
    }

    @Override
    public void loginPerformed(LoginFormEvent event)
    {
        System.out.println("Login event received. " + event.getName() + ": " + event.getPassword());
    }
}
