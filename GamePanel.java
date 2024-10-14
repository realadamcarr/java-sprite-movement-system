
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {
    private int x = 50;
    private int y = 50;

    //SCREEN SETTINGS

    final int originalTileSize = 16;  // 16x16 pixels
    final int scale = 3; // 3x scale

    final int tilesize = originalTileSize * scale; // 48x48 pixels
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth =  maxScreenCol * tilesize; // 768 pixels
    final int screenHeight = maxScreenRow * tilesize; // 576 pixels

    KeyHandler keyH = new KeyHandler();

    // FPS
    int FPS = 60;

    private GamePanel GamePanel;
    transient Player player = new Player(this.GamePanel, keyH);

    public GamePanel() {
        this.addKeyListener(this);
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.GREEN);
        setDoubleBuffered(true);
        addKeyListener(keyH);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(x, y, 50, 50); // Draw a rectangle at (x, y)
        Graphics2D g2 = null;
        player.draw(g2);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            x -= 15;
        } else if (key == KeyEvent.VK_RIGHT) {
            x += 15;
        } else if (key == KeyEvent.VK_UP) {
            y -= 15;
        } else if (key == KeyEvent.VK_DOWN) {
            y += 15;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public static void startGameThread() {
        // Implement game loop if needed
    }

    public Player getPlayer() {
        return player;
    }
}
