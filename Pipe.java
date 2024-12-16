import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;




public class Pipe {
    int[] len = {100,150,200,250,300,350,400,450,500,550};
    int[] y = {250,300,350,400,450,500,550,600,650,700,750};
    int[] h  ={550,500,450,400,350};
     int xAxis;
     int yAxis =500;
     int pipeHeight = 300;
     int pipeHeightd = 300;
    private BufferedImage bgImage;
    private BufferedImage bgImaged;

    Pipe(int xAxis) {
        this.xAxis = xAxis;
        loadBgImage();
    }

    private void loadBgImage() {
        try {
                bgImage = ImageIO.read(new File("piped.png"));
                bgImaged = ImageIO.read(new File("pipe.png"));
            }
         catch (IOException e) {
            e.printStackTrace();
        }
        

    }

    void showBg(Graphics pen) {
      
        pen.drawImage(bgImage, xAxis, 0, 129, pipeHeight, null);
    }
    void showBgd(Graphics pen) {
      
        pen.drawImage(bgImaged, xAxis, yAxis, 129, pipeHeightd, null);
    }

    void move(){
        if(xAxis < -300){
            int index = (int)(Math.random() * len.length);
            pipeHeight = len[index];
            
            if(pipeHeight<=300){
                yAxis = y[index];
                pipeHeightd = h[index];
            }
            else
            yAxis = y[index];

            System.out.println(pipeHeight);
            System.out.println(pipeHeightd);
            System.out.println(yAxis);
            xAxis=500;
        }
        xAxis-=15;
    }
}
