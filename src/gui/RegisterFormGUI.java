package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Constant.CommonConstants;
import backend.MyJDBC;

public class RegisterFormGUI extends Form {
    public RegisterFormGUI() {
        super("Register");
        addGUIComponents();
    }

    public void addGUIComponents() {

        // Create a register Label
        JLabel registerLabel = new JLabel("Register");
        registerLabel.setBounds(0, 25, 520, 100);
        registerLabel.setForeground(CommonConstants.TEXT_COLOR);
        registerLabel.setFont(new Font("Bell MT", Font.BOLD, 40));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create a user name label
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 150, 400, 25);
        usernameLabel.setForeground(CommonConstants.TEXT_COLOR);
        usernameLabel.setFont(new Font("Bell MT", Font.BOLD, 24));

        // Create a username text field
        JTextField userJTextField = new JTextField();
        userJTextField.setBounds(30, 185, 450, 55);
        userJTextField.setBackground(CommonConstants.SECONDARY_COLOR);
        userJTextField.setForeground(CommonConstants.TEXT_COLOR);
        userJTextField.setFont(new Font("Dialog", Font.PLAIN, 22));

        // create a password label
        JLabel pwLabel = new JLabel("Password:");
        pwLabel.setBounds(30, 260, 400, 25);
        pwLabel.setForeground(CommonConstants.TEXT_COLOR);
        pwLabel.setFont(new Font("Bell MT", Font.BOLD, 24));

        // Create a password text field for password label
        JPasswordField pwTextField = new JPasswordField();
        pwTextField.setBounds(30, 290, 450, 55);
        pwTextField.setBackground(CommonConstants.SECONDARY_COLOR);
        pwTextField.setForeground(CommonConstants.TEXT_COLOR);
        pwTextField.setFont(new Font("Dialog", Font.PLAIN, 22));

        // Re-enter Password Label
        JLabel reEnterpwLabel = new JLabel("Re-Enter Your Password:");
        reEnterpwLabel.setBounds(30, 365, 400, 25);
        reEnterpwLabel.setForeground(CommonConstants.TEXT_COLOR);
        reEnterpwLabel.setFont(new Font("Bell MT", Font.BOLD, 24));

        JPasswordField reEnterpwTextField = new JPasswordField();
        reEnterpwTextField.setBounds(30, 395, 450, 55);
        reEnterpwTextField.setBackground(CommonConstants.SECONDARY_COLOR);
        reEnterpwTextField.setForeground(CommonConstants.TEXT_COLOR);
        reEnterpwTextField.setFont(new Font("Dialog", Font.PLAIN, 22));

        // create a Register button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(125, 520, 250, 50);
        registerButton.setFont(new Font("Bell MT", Font.BOLD, 22));
        registerButton.setBackground(CommonConstants.SECONDARY_COLOR);
        registerButton.setForeground(CommonConstants.TEXT_COLOR);
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // get username, password and Re-entered password
                String username = userJTextField.getText();
                String password = new String(pwTextField.getPassword());
                String rePassword = new String(reEnterpwTextField.getPassword());

                // validate user input
                if (validateUserInput(username, password, rePassword, pwTextField, reEnterpwTextField)) {
                    // register the user to the database
                    if (MyJDBC.register(username, rePassword)) {

                        // dispose of this GUI and open Login Form GUI
                        RegisterFormGUI.this.dispose();
                        LoginFormGui loginFormGui = new LoginFormGui();
                        loginFormGui.setVisible(true);

                        JOptionPane.showMessageDialog(loginFormGui, "Account registered successfully!");
                    } else {
                        // register failed (likely due to the user is already exists in the database)
                        JOptionPane.showMessageDialog(RegisterFormGUI.this, "Error: Username is already taken!");
                    }
                }
            }

        });

        // create a Login label to load the Login GUI
        JLabel loginJLabel = new JLabel("Have an account? Login here");
        loginJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginJLabel.setBounds(125, 600, 250, 30);
        loginJLabel.setForeground(CommonConstants.TEXT_COLOR);
        loginJLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // add Functionality so that when clicked it will launch the Login Form GUI
        loginJLabel.addMouseListener((MouseListener) new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose or close Login GUI
                RegisterFormGUI.this.dispose();
                // launch the register GUI
                new LoginFormGui().setVisible(true);
            }
        });

        // add components
        add(registerLabel);
        add(usernameLabel);
        add(userJTextField);
        add(pwLabel);
        add(pwTextField);
        add(reEnterpwLabel);
        add(reEnterpwTextField);
        add(registerButton);
        add(loginJLabel);

    }

    // so here we are going to validate our user input, making sure that user has
    // placed a valid username and password
    private boolean validateUserInput(String username, String password, String rePassword, JPasswordField pwTextField, JPasswordField reEnterpwTextField) {

        if(username.isBlank() || password.isBlank() || rePassword.isBlank()){
            JOptionPane.showMessageDialog(null, "Please fill all the above details");
            return false;

        } else if (username.length()< 6 || password.length()<6 || rePassword.length()<6){
            JOptionPane.showMessageDialog(null, "Username and Password should be 6 characters long!");
            pwTextField.setText("");
            reEnterpwTextField.setText("");
            return false;

        } else if (!password.equals(rePassword)){
            JOptionPane.showMessageDialog(null, "Entered password mismatched! \nRe-enter you password!");
            pwTextField.setText("");
            reEnterpwTextField.setText("");
            return false;
        }

        return true;
    }
}
