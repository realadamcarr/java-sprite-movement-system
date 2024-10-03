import java.awt.*;
import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable{
    
    //SCREEN SETTINGS

    final int originalTileSize = 16;  // 16x16 pixels
    final int scale = 3; // 3x scale

    final int tilesize = originalTileSize * scale; // 48x48 pixels  
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth =  maxScreenCol * tilesize; // 768 pixels
    final int screenHeight = maxScreenRow * tilesize; // 576 pixels


    // FPS
    int FPS = 60;


    //set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    KeyHandler keyH = new KeyHandler();
    public GamePanel() {
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(keyH);
        setFocusable(true);
        
    }

    private static Thread gameThread;
    
    public static void startGameThread() {
    
        gameThread.start();
    
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null ) {



        //    System.out.println("The Game Loop Is Running");
        // 1 UPDATE: update information such as character positions
            update();
        // 2 UPDATE: draw the screen with the updated information
            repaint();


            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){
        if(keyH.upPressed == true) {
            playerY -= playerSpeed;
        }
        else if(keyH.downPressed == true) {
            playerY += playerSpeed;
        }
        else if(keyH.leftPressed == true) {
            playerX -= playerSpeed;
        }
        else if(keyH.rightPressed == true) {
            playerX += playerSpeed;
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);

        g2.fillRect(playerX, playerY, tilesize, tilesize);

        g2.dispose();
    }

}


//TIMESTAMP:  link: https://www.youtube.com/watch?v=VpH33Uw-_0E&t=187s