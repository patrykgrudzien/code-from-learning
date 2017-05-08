package Structural.MVC;

import Structural.MVC.Controller.Controller;
import Structural.MVC.Model.Model;
import Structural.MVC.View.View;

import javax.swing.SwingUtilities;

public class Application
{
    public static void main(final String[] args)
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
        final Model model = new Model();

        /**
         * View of the Model.
         *
         * View is showing the DATA !!!
         */
        final View view = new View(model);

        /**
         * Controller sends commands to the Model (tells the Model what to do)
         * but also
         * tells View what to do.
         *
         * Controller also listens Model & View
         */
        final Controller controller = new Controller(model, view);
    }
}
