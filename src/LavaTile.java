import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 
 * LavaTile.java
 * @author Andrew Fischer
 *
 */
public class LavaTile extends FloorTile {
    public static final String IMG_LOC = FILE_PATH + "isoLava.png";

    
    private static BufferedImage img;
    
    public LavaTile(int x, int y) {
        super(x, y, false);
        
        try {
            if (img == null) {
                img = ImageIO.read(new File(IMG_LOC));
            }
        } catch (IOException e) {
                System.out.println("Internal Error:" + e.getMessage());
                // TODO: handle exception
        }
        
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
    }
}