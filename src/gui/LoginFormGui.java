package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Constant.CommonConstants;
import backend.MyJDBC;

public class LoginFormGui extends Form {
    public LoginFormGui() {
        super("Login");
        addGUIComponents();
    }

    public void addGUIComponents() {
        // Create a Login Label
        JLabel loginLabel = new JLabel("Login");
        // configure components x,y position and width/height values relatively
        loginLabel.setBounds(0, 25, 520, 100);
        // change the font color
        loginLabel.setForeground(CommonConstants.TEXT_COLOR);
        // change the font size
        loginLabel.setFont(new Font("Bell MT", Font.BOLD, 40));
        // center text
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);

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
        pwLabel.setBounds(30, 335, 400, 25);
        pwLabel.setForeground(CommonConstants.TEXT_COLOR);
        pwLabel.setFont(new Font("Bell MT", Font.BOLD, 24));

        // Create a password text field
        JPasswordField pwTextField = new JPasswordField();
        pwTextField.setBounds(30, 365, 450, 55);
        pwTextField.setBackground(CommonConstants.SECONDARY_COLOR);
        pwTextField.setForeground(CommonConstants.TEXT_COLOR);
        pwTextField.setFont(new Font("Dialog", Font.PLAIN, 22));

        // create a Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(125, 520, 250, 50);
        loginButton.setFont(new Font("Bell MT", Font.BOLD, 22));
        loginButton.setBackground(CommonConstants.SECONDARY_COLOR);
        loginButton.setForeground(CommonConstants.TEXT_COLOR);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // we will first retrive the username and password value from our user
                // get username & password
                String username = userJTextField.getText();
                String password = new String(pwTextField.getPassword());

                // chech database if the username and password combo is valid or not
                if (MyJDBC.validateLogin(username, password)) {
                    // login successful
                    JOptionPane.showMessageDialog(LoginFormGui.this, "Login Successful!");

                    // close the current window and open WelcomePage
                    setVisible(false);
                    new WelcomePage(username).setVisible(true);

                } else {
                    // login failed
                    JOptionPane.showMessageDialog(LoginFormGui.this, "Login failed...!\n You are redirect to the Registration Form.");
                    // dispose or close Login GUI and open Register GUI
                    LoginFormGui.this.dispose();
                    new RegisterFormGUI().setVisible(true);
                }
            }

        });

        // create a Register label to load the register GUI
        JLabel registerLabel = new JLabel("Not a User? Register here");
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setBounds(125, 600, 250, 30);
        registerLabel.setForeground(CommonConstants.TEXT_COLOR);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // add Functionality so that when clicked it will launch the Register Form GUI
        registerLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose or close Login GUI
                LoginFormGui.this.dispose();
                // launch the register GUI
                new RegisterFormGUI().setVisible(true);
            }

        });

        // add components
        add(loginLabel);
        add(usernameLabel);
        add(userJTextField);
        add(pwLabel);
        add(pwTextField);
        add(loginButton);
        add(registerLabel);
    }
}
