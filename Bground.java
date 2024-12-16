import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Bground {

    private int xAxis;
    private int yAxis;
    private int bgWidht;
    private int bgHeight;
    private String fileName[];
    private BufferedImage[] bgImage;

    Bground(int xAxis, int yAxis, int bgWidht, int bgHeight, String fileName[]) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.bgHeight = bgHeight;
        this.bgWidht = bgWidht;
        this.fileName = fileName;
        bgImage = new BufferedImage[fileName.length];
        loadBgImage();
    }

    private void loadBgImage() {
        try {
            for (int i = 0; i < bgImage.length; i++) {
                bgImage[i] = ImageIO.read(new File(fileName[i]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }

    int currImg = 0;
    void showBg(Graphics pen) {
        if (currImg == bgImage.length)
            currImg = 0;
        pen.drawImage(bgImage[currImg], xAxis, yAxis, bgWidht, bgHeight, null);
        currImg++;
    }
}