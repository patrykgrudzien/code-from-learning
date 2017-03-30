package SmallerScale.Singleton.Controller;

import SmallerScale.Singleton.Model.Model;
import SmallerScale.Singleton.View.LoginFormEvent;
import SmallerScale.Singleton.View.LoginListener;
import SmallerScale.Singleton.View.View;

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
