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


        while(gameThread != null ) {

        //    System.out.println("The Game Loop Is Running");
        // 1 UPDATE: update information such as character positions
            update();
        // 2 UPDATE: draw the screen with the updated information
            repaint();
        }
    }

    public void update(){

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);

        g2.fillRect(100, 100, tilesize, tilesize);

        g2.dispose();
    }

}


//TIMESTAMP:  link: https://www.youtube.com/watch?v=VpH33Uw-_0E&t=187s