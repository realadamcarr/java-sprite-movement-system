import java.awt.Component;
import javax.swing.JFrame;

public class Main {
   public static void main(String[] args) {
      JFrame window = new JFrame();
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setResizable(false);
      window.setTitle("Nerd quest");

      GamePanel gamePanel = new GamePanel();
      window.add(gamePanel);
      window.pack();
      window.setLocationRelativeTo((Component)null);
      window.setVisible(true);

      GamePanel.startGameThread();
   }
}
