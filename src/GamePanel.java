import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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

    KeyHandler keyH = new KeyHandler(); // instantiating keyHandler
    Thread gameThread;  // needed for animation

    // set players default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel(){   //constructor of this gamepanel
        this.setPreferredSize(new DimensionUIResource(screenWidth, screenHeight)); // set the size of this class (JPanel)
        this.setBackground(Color.BLACK);    // set background color of the screen
        this.setDoubleBuffered(true);   // enabeling this improves game renderig performence
        this.addKeyListener(keyH);  // so game panel can recognize key input
        this.setFocusable(true);    // gamepanel can be focused to recive key input
    }  

    public void startGameThread(){
        gameThread = new Thread(this);  // this => this gamepanel class
        gameThread.start(); // starts the thread by calling run() method
    }

    @Override
    public void run(){

        while (gameThread != null) {    
            
            // Game loop 
            // 1. Update : update informatin such as charecter positions
            update();
            // 2. Draw : draw the screen with the updated information
            repaint(); // calles paintComponent() method
        }
    }

    public void update() {
        if (keyH.upPressed == true) {
            playerY -= playerSpeed; 
            // short form of playerY = playerY - playerSpeed
        }
        else if (keyH.downPressed == true) {
            playerY += playerSpeed; // y value increase as thay go down.
        }
        else if (keyH.rightPressed == true) {
            playerY += playerSpeed; // x value increase as thay go right.
        }
        else if (keyH.leftPressed == true) {
            playerY -= playerSpeed; 
        }
    }

    // draw staf on the screen
    public void paintComponent(Graphics g) {    //Graphics is a class that has many function to draw object on screen

        super.paintComponent(g);    // this line is written when printComponent method is used in JPanel. super => is a keyword which regers to the parent class of this GamePanel class -> JPanel.

        Graphics2D g2 = (Graphics2D)g;  // converting Graphics class to Graphics2D for better controle over gameplay and additional function.

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();   // program will run without method but it is good practie to save some memory. hover over the method to see more details.
    }

} 