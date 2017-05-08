package SmallerScale.BeanDAOFactory.View;

import SmallerScale.BeanDAOFactory.Model.Database;
import SmallerScale.BeanDAOFactory.Model.Model;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class View extends JFrame implements ActionListener
{
    private Model model;
    private JButton okButton;
    private JTextField nameField;
    private JPasswordField passField;

    private CreateUserListener createUserListener;

    public View(final Model model)
    {
        super("MVC Demo");

        this.model = model;

        nameField = new JTextField(10);
        passField = new JPasswordField(10);
        okButton = new JButton("Create user");

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

        // ========================================================================================== //
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowOpened(final WindowEvent e)
            {
                try
                {
                    Database.getInstance().connect();
                    if (Database.getInstance().isConnect())
                    {
                        JOptionPane.showMessageDialog(View.this, "Connected to database", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch (final Exception e1)
                {
                    JOptionPane.showMessageDialog(View.this, "Unable to connect to database.", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void windowClosing(final WindowEvent e)
            {
                Database.getInstance().disconnect();
                if (Database.getInstance().isDisconnect())
                {
                    try
                    {
                        View.this.setVisible(false);
                        Thread.sleep(500);
                    }
                    catch (final InterruptedException e1)
                    {
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(View.this, "Successfully disconnected.", "Info", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        // ========================================================================================== //
        setSize(600, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(final ActionEvent e)
    {
        final String password = new String(passField.getPassword());
        final String name = nameField.getText();

        fireLoginEvent(new CreateUserEvent(name, password));

        final int reply = JOptionPane.showConfirmDialog(null, "User has been added. Do you want to add next one?", "Info", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION)
        {
            passField.setText("");
            nameField.setText("");
        }
    }

    /**
     * We want to pass ANYTHING WHICH IMPLEMENTS "LoginListener" INTERFACE
     * <p>
     * We want to store reference to the object which IMPLEMENTS "LoginListener" interface
     */
    public void setCreateUserListener(final CreateUserListener createUserListener)
    {
        this.createUserListener = createUserListener;
    }

    private void fireLoginEvent(final CreateUserEvent event)
    {
        if (createUserListener != null)
        {
            createUserListener.loginPerformed(event);
        }
    }
}
