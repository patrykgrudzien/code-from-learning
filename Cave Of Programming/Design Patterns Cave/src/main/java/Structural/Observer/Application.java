package Structural.Observer;

import Structural.Observer.Controller.Controller;
import Structural.Observer.Model.Model;
import Structural.Observer.View.View;

import javax.swing.SwingUtilities;

public class Application
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                runApp();
            }
        });
    }

    private static void runApp()
    {
        /**
         * It's completely INDEPENDENT of other classes
         *
         * Model should never import ANYTHING FROM VIEW PACKAGE and
         * CONTROLLER PACKAGE either !!!
         */
        Model model = new Model();

        /**
         * View of the Model.
         *
         * View is showing the DATA !!!
         */
        View view = new View(model);

        /**
         * Controller sends commands to the Model (tells the Model what to do)
         * but also
         * tells View what to do.
         *
         * Controller also listens Model & View
         */
        Controller controller = new Controller(model, view);

        // ================================================================================================= //
        /**
         * CONTROLLER listens to the VIEW
         * If a "loginEvent" occurs in a VIEW tell CONTROLLER about it
         */
        view.setLoginListener(controller);
    }
}
