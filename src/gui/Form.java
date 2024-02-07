package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Constant.CommonConstants;

public class Form extends JFrame {
    //create a constructor
    public Form(String title){
        //set the title of the JFrame bar
        super(title);

        //set the size of the GUI
        setSize(520,680);

        //configure GUI to end process after closing
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //set layout to null to disable layout management to place the componenets whatever we want
        setLayout(null);

        //login GUI in the center of the screen
        setLocationRelativeTo(null);

        //create the background color of GUI
        getContentPane().setBackground(CommonConstants.PRIMARY_COLOR);

        // set Image Icon of the JFrame
        ImageIcon image1 = new ImageIcon("src\\Icon\\img.png"); 
        this.setIconImage(image1.getImage());// change icon of frame
    }
    
}
