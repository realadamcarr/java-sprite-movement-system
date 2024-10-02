import java.awt.Component;
import javax.swing.JFrame;

public class Main {
   public static void main(String[] args) {
      JFrame window = new JFrame();
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setResizable(false);
      window.setTitle("Nerd quest");

      Thread gameThread;

      GamePanel var2 = new GamePanel();
      window.add(var2);
      window.pack();
      window.setLocationRelativeTo((Component)null);
      window.setVisible(true);

      GamePanel.startGameThread();
   }
}
