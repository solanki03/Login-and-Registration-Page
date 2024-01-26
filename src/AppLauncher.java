import javax.swing.SwingUtilities;

import backend.MyJDBC;
import gui.LoginFormGui;

public class AppLauncher {
    public static void main(String[] args) {
        // we use invokeLater() to make updates to GUI more thread safe and efficient
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // instance of loginFormGUI
                new LoginFormGui().setVisible(true);

                // check user test
                //System.out.println(MyJDBC.checkUser("username"));

                //check register test
                //System.out.println(MyJDBC.register("username1234", "123456789"));

                //check login test
                //System.out.println(MyJDBC.validateLogin("username1234", "password"));
            }

        });
    }
}
