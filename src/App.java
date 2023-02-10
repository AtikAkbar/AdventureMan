import javax.naming.ldap.ManageReferralControl;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame window = new JFrame();   // to open a widow
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // window will close if pressed 'X'
        window.setResizable(false); // window can not be resized
        window.setTitle("Adventure Man");   // the title of the widow

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);  // add gamepanel to this window
        window.pack();  // causes the window to be sized to fit the preferred size and layout of its subcomponents (gamepad) 

        window.setLocationRelativeTo(null); // window will be displayed at the center of the screen
        window.setVisible(true);    // window will be visible

        gamePanel.startGameThread();
    }
}
