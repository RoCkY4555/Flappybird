import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;
// import java.util.ArrayList;

public class GamePannel extends JPanel {
    Timer timer;
    int score = 0;
    int Highscore = 0;
    Bground bg;
    Pipe p1;
    Pipe p2;
    Bird b1;
    boolean gameOver = false; 
    boolean play = false;

    GamePannel() {
        setSize(550, 800);
        setFocusable(true);
        
        String bgFile[] = new String[45];
        for (int i = 0; i < bgFile.length; i++) {
            bgFile[i] = "bg/"+ (i) + ".png";
        }
        bg = new Bground(0, 0, 550, 800, bgFile);

        p1 = new Pipe(600);
        p2 = new Pipe(1000);
        
        b1 = new Bird(10, 270, 50, 50, "bird.png");
        callPaintAgain();
        addKeyboardControls();
    }

    @Override
    protected void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        bg.showBg(pen);
        if(play){
            p1.showBg(pen);
            p1.showBgd(pen);
            p2.showBg(pen);
            p2.showBgd(pen);
            if (checkCollision(b1, p1) || checkCollision(b1, p2)) {
                System.out.println(play);
                System.out.println(gameOver);
                gameOver = true;
                play = false;
                System.out.println("GameOver");
                p1 = new Pipe(600);
                p2 = new Pipe(1000);
            }
        }
        b1.showBird(pen);


        // Check for collisions

        pen.setFont(new Font("Arial", Font.PLAIN, 50));
        if (gameOver) {
            Highscore = Math.max(Highscore, score);
            pen.setColor(Color.red);
            pen.drawString("    Game Over:   " + String.valueOf(score), 20, 50);
            pen.drawString("    Highscore:   " + Highscore, 25, 150);
            pen.drawString("Press R to Restart" , 25, 500);
        } 
        else if(!play){
            pen.drawString("Press Space to Start", 20, 50);
        }
        else {
            pen.drawString("Score: " + String.valueOf(score), 20, 50);
            pen.drawString("HighScore: " + String.valueOf(Highscore), 70, 150);
        }
        // pen.setFont(new Font("Arial", Font.PLAIN, 50));
        // pen.drawString("High Score: " + String.valueOf(Highscore), 920, 50);
    }

    private boolean checkCollision(Bird bird, Pipe pipe) {
        Rectangle birdRect = new Rectangle(bird.xAxis, bird.yAxis, 100, 100); 
        Rectangle pipeTopRect = new Rectangle(pipe.xAxis, 0, 100, pipe.pipeHeight-50); 
        Rectangle pipeBottomRect = new Rectangle(pipe.xAxis, pipe.yAxis, 100, pipe.pipeHeightd-50); 

        return birdRect.intersects(pipeTopRect) || birdRect.intersects(pipeBottomRect) || b1.yAxis>690||b1.yAxis<-50 ;
    }

    void callPaintAgain() {
        timer = new Timer(50, (a) -> {
            if (!gameOver) {
                repaint();
                if(play){
                    score++;
                    b1.move();
                    p1.move();
                    p2.move();
                }
            }
        });
        timer.start();
    }

    void addKeyboardControls() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if(!play){
                        play=true;
                    }
                    else
                    b1.flap();
                }
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    System.out.println(play);
                    System.out.println(gameOver);
                    if(gameOver==true){
                        gameOver = false;
                        score=0;
                        p1.xAxis = 600;
                        p2.xAxis = 1000;
                        b1.xAxis = 10;
                        b1.yAxis = 270;
                    }
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
}