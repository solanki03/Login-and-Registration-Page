import javax.swing.SwingUtilities;

import gui.LoginFormGui;

public class AppLauncher {
    public static void main(String[] args) {
        // we use invokeLater() to make updates to GUI more thread safe and efficient
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // instance of loginFormGUI
                new LoginFormGui().setVisible(true);
            }

        });
    }
}
