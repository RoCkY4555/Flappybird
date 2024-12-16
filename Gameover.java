import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Gameover {

    int xAxis;
    int yAxis;
    int Width;
    int Height;
    BufferedImage Image;
    String fileName;

    Gameover(int xAxis, int yAxis, int Widht, int Height, String fileName) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.Height = Height;
        this.Width = Widht;
        this.fileName = fileName;
        loadBgImage();
    }

    void loadBgImage() {
        try {
            Image = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void showimg(Graphics pen) {
        pen.drawImage(Image, xAxis, yAxis, Width, Height, null);
    }

}
