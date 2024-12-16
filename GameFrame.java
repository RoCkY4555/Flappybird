import javax.swing.JFrame;

public class GameFrame extends JFrame {
   GameFrame(){
    setTitle("Car Game");
    setSize(550, 800);
    setLocationRelativeTo(null);
    setResizable(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GamePannel gamePannel = new GamePannel();
    add(gamePannel);
    setVisible(true);
   }
}
