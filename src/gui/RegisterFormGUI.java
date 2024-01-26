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

public class RegisterFormGUI extends Form{
    public RegisterFormGUI(){
        super("Login");
        addGUIComponents();
    }
    /**
     * 
     */
    public void addGUIComponents(){
        //Create a register Label
        JLabel registerLabel = new JLabel("Register");
        //configure components x,y position and width/height values relatively
        registerLabel.setBounds(0, 25, 520, 100);
        //change the font color
        registerLabel.setForeground(CommonConstants.TEXT_COLOR);
        //change the font size
        registerLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        //center text
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //Create a user name label
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30,150,400,25);
        usernameLabel.setForeground(CommonConstants.TEXT_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        //Create a username text field
        JTextField userJTextField = new JTextField();
        userJTextField.setBounds(30,185,450,55);
        userJTextField.setBackground(CommonConstants.SECONDARY_COLOR);
        userJTextField.setForeground(CommonConstants.TEXT_COLOR);
        userJTextField.setFont(new Font("Dialog", Font.PLAIN, 24));

        //create a password label
        JLabel pwLabel = new JLabel("Password:");
        pwLabel.setBounds(30,255,400,25);
        pwLabel.setForeground(CommonConstants.TEXT_COLOR);
        pwLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        //Create a password text field for password label
        JPasswordField pwTextField = new JPasswordField();
        pwTextField.setBounds(30,300,450,55);
        pwTextField.setBackground(CommonConstants.SECONDARY_COLOR);
        pwTextField.setForeground(CommonConstants.TEXT_COLOR);
        pwTextField.setFont(new Font("Dialog", Font.PLAIN, 24));

        //Re-enter Password Label
        JLabel reEnterpwLabel = new JLabel("Re-Enter Your Password:");
        reEnterpwLabel.setBounds(30,365,400,25);
        reEnterpwLabel.setForeground(CommonConstants.TEXT_COLOR);
        reEnterpwLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        JPasswordField reEnterpwTextField = new JPasswordField();
        reEnterpwTextField.setBounds(30,395,450,55);
        reEnterpwTextField.setBackground(CommonConstants.SECONDARY_COLOR);
        reEnterpwTextField.setForeground(CommonConstants.TEXT_COLOR);
        reEnterpwTextField.setFont(new Font("Dialog", Font.PLAIN, 24));


        //create a Register button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(125,520,250,50);
        registerButton.setFont(new Font("Dialog", Font.BOLD, 18));
        registerButton.setBackground(CommonConstants.SECONDARY_COLOR);
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // -------- Backend code goes here ---------
        registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //get username
                String username = userJTextField.getText();

                //get password
                String password = new String(pwTextField.getPassword());

                //get Re-entered password
                String rePassword = new String(pwTextField.getPassword());

                // validate user input
                if(validateUserInput(username, password, rePassword)){
                    // register the user to the database
                    if(MyJDBC.register(username, rePassword)){
                        // dispose of this GUI
                        RegisterFormGUI.this.dispose();

                        //take user back to the login GUI
                        LoginFormGui loginFormGui = new LoginFormGui();
                        loginFormGui.setVisible(true);

                        //create a result dialog box
                        JOptionPane.showMessageDialog(loginFormGui, "Registered account successfully!...");
                    }else{
                        //register failed (likely due to the user is already exists in the database)
                        JOptionPane.showMessageDialog(RegisterFormGUI.this, "Error: Username is already taken!");
                    }
                }
                else{
                    //invalid user input
                    JOptionPane.showMessageDialog(RegisterFormGUI.this, "Error: Username must be atleast 6 character long \n and or password must match");
                }
            }
            
        });

        //create a Login label to load the Login GUI
        JLabel loginJLabel = new JLabel("Have an account? Login here");
        loginJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginJLabel.setBounds(125,600,250,30);
        loginJLabel.setForeground(CommonConstants.TEXT_COLOR);
        loginJLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

         //add Functionality so that when clicked it will launch the Login Form GUI
         loginJLabel.addMouseListener((MouseListener) new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //dispose or close Login GUI
                RegisterFormGUI.this.dispose();
                //launch the register GUI
                new LoginFormGui().setVisible(true);
            }
        });

        //add components
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
    
    //so here we are going to validate our user input, making sure that user has placed a valid username and password
    private boolean validateUserInput(String username, String password, String rePassword){
        //all fields must have a value
        if(username.length() == 0 || password.length() == 0 || rePassword.length() == 0){
            return false;
        }

        //username has to be atleast 6 characters long
        if(username.length() < 6){
            return false;
        }

        //password and rePassword must be same like username
        if(!password.equals(rePassword)){
            return false;
        }

        return true;
    }
}
