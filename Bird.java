import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bird {
    int xAxis;
    int yAxis;
      int bgWidth;
     int bgHeight;
     int velocityY; // To control the vertical speed
    BufferedImage spriteSheet;
    BufferedImage singleImages[] = new BufferedImage[13];
    
    Bird(int xAxis, int yAxis, int bgWidth, int bgHeight, String fileName) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.bgHeight = bgHeight;
        this.bgWidth = bgWidth;
        this.velocityY = 0; // Initial vertical speed
        loadBgImage();
        singleImages = cutSpriteSheet();
    }

    BufferedImage[] cutSpriteSheet() {
        singleImages[0] = spriteSheet.getSubimage(0, 0, 134, 124);
        singleImages[1] = spriteSheet.getSubimage(134, 0, 134, 124);
        singleImages[2] = spriteSheet.getSubimage(268, 0, 134, 124);
        singleImages[3] = spriteSheet.getSubimage(402, 0, 134, 124);
        singleImages[4] = spriteSheet.getSubimage(536, 0, 134, 124);
        singleImages[5] = spriteSheet.getSubimage(0, 124, 134, 124);
        singleImages[6] = spriteSheet.getSubimage(134, 124, 134, 124);
        singleImages[7] = spriteSheet.getSubimage(268, 124, 134, 124);
        singleImages[8] = spriteSheet.getSubimage(402, 124, 134, 124);
        singleImages[9] = spriteSheet.getSubimage(536, 124, 134, 124);
        singleImages[10] = spriteSheet.getSubimage(0, 248, 134, 124);
        singleImages[11] = spriteSheet.getSubimage(134, 248, 134, 124);
        singleImages[12] = spriteSheet.getSubimage(268, 248, 134, 124);
        // singleImages[13] = spriteSheet.getSubimage(402, 248, 134, 124);
        return singleImages;
    }

    private void loadBgImage() {
        try {
            spriteSheet = ImageIO.read(new File("spriteBird.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    int currImg = 0;
    void showBird(Graphics pen) {
        if(currImg==13){
           currImg = 0; 
        }
        pen.drawImage(singleImages[currImg], xAxis, yAxis, 100, 100, null);
        currImg++;
    }

    void move() {
        // Apply gravity
        velocityY += 2; // Increase downward speed due to gravity
        yAxis += velocityY;

        // Reset position if it hits the ground
        if (yAxis >= 750 - bgHeight) {
            yAxis = 750 - bgHeight;
            velocityY = 0; // Reset vertical speed
        }
    }

    void flap() {
        velocityY = -20; // Set upward speed when flapping
    }
}

