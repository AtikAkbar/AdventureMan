import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel implements Runnable{  // this class inherits JPanel class -> this is a subclass of JPanel; implement Runnable => runes the Thread
    
    // Screen Setting
    final int originalTileSize = 16; // 16x16 pixcel tile 
    final int scale = 3;    // if not scaled the charecter will look too small. 

    final int tileSize = originalTileSize * scale; // 48x48 pixcel tile size
    final int maxScreenCol = 16; // 16 tile horizontally
    final int maxScreenRow = 12; // 12 tile vertically     4x3 screen
    final int screenWidth = tileSize * maxScreenCol; //768 pixcel
    final int screenHeight = tileSize * maxScreenRow; //576 pixcel

    Thread gameThread;  // needed for animation

    public GamePanel(){   //constructor of this gamepanel
        this.setPreferredSize(new DimensionUIResource(screenWidth, screenHeight)); // set the size of this class (JPanel)
        this.setBackground(Color.BLACK);    // set background color of the screen
        this.setDoubleBuffered(true);   // enabeling this improves game renderig performence
    }  

    public void startGameThread(){
        gameThread = new Thread(this);  // this => this gamepanel class
        gameThread.start(); // starts the thread by calling run() method
    }

    public void run(){

        while (gameThread != null) {
            
            System.out.println("This loop is running.");
        }
    }
} 