package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import Constant.CommonConstants;


public class WelcomePage extends Form implements ActionListener{

    JLabel welcomLabel, greetingLabel, dateTimeLable, t1;
    JTextArea textArea;
    JButton exit, generate;
    String username;
    
    public WelcomePage(String username){
        super("Welcome");
        this.username = username;
        addGuiComponents();
    }

    private void addGuiComponents() {

        //Create a user name label
        greetingLabel = new JLabel("Good morning"); // good morning, noon, afternoon, evening 
        greetingLabel.setBounds(30,60,400,35);
        greetingLabel.setForeground(CommonConstants.TEXT_COLOR);
        greetingLabel.setFont(new Font("Bell MT", Font.BOLD, 27));
        add(greetingLabel);

        // get the date and time 
        Calendar calendar = Calendar.getInstance(); 
        Date date = new Date();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour < 12) {
            greetingLabel.setText("Good Morning!"); 
        } else if (hour < 17) {
            greetingLabel.setText("Good Afternoon!");
        } else {
            greetingLabel.setText("Good Evening!");
        }

        //Create a user name label
        dateTimeLable = new JLabel();
        dateTimeLable.setBounds(30,90,400,25);
        dateTimeLable.setForeground(CommonConstants.TEXT_COLOR);
        dateTimeLable.setFont(new Font("Bell MT", Font.BOLD, 18));
        add(dateTimeLable);

        // get time day,date and year, like: Tue, Feb 06 2024
        dateTimeLable.setText(date.toString().substring(0, 3)+ ", " + date.toString().substring(4, 10)+" "+ date.toString().substring(24));

        //Create a label to welcome
        welcomLabel = new JLabel("Welcome "+ username +"!");
        welcomLabel.setBounds(30,150,400,25);
        welcomLabel.setForeground(CommonConstants.TEXT_COLOR);
        welcomLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(welcomLabel);

        //Create a label to display text
        welcomLabel = new JLabel("Quote of the day is");
        welcomLabel.setBounds(30,180,400,25);
        welcomLabel.setForeground(CommonConstants.TEXT_COLOR);
        welcomLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        add(welcomLabel);

        // create a text area to display quotes
        textArea = new JTextArea("Demo text...");
        textArea.setBounds(35, 220, 435, 220);
        textArea.setForeground(CommonConstants.TEXT_COLOR);
        textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(5, 5,5,5));
        textArea.setEditable(false);
        add(textArea);

        // create a exit button
        generate = new JButton("Generate");
        generate.setBounds(300, 500, 150, 30);
        generate.setFont(new Font("Dialog", Font.BOLD, 18));
        generate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        generate.setBackground(CommonConstants.SECONDARY_COLOR);
        generate.setForeground(CommonConstants.TEXT_COLOR);
        add(generate);
        generate.addActionListener(this);

        // create a exit button
        exit = new JButton("Exit");
        exit.setBounds(350, 550, 100, 30);
        exit.setFont(new Font("Dialog", Font.BOLD, 18));
        exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exit.setBackground(CommonConstants.SECONDARY_COLOR);
        exit.setForeground(CommonConstants.TEXT_COLOR);
        add(exit);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == generate){

            // add method to display quotes

        }else if (ae.getSource() == exit){
            System.exit(0);
        }
    }
}
