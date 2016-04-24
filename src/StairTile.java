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
public class StairTile extends FloorTile {
    public boolean isEnd;
    
    public static final String IN_IMG_LOC = FILE_PATH + "isoDownE.png";
    public static final String OUT_IMG_LOC = FILE_PATH + "isoDownS.png";
    private BufferedImage img;
    
    public StairTile(int x, int y, boolean isEnd) {
        super(x, y, true);
        this.isEnd = isEnd;
        
    }
    
    @Override
    public void draw(Graphics g) {
        try {
            if (isEnd) {
                img = ImageIO.read(new File(IN_IMG_LOC));
            } else {
                img = ImageIO.read(new File(OUT_IMG_LOC));
            }
        } catch (IOException e) {
                System.out.println("Internal Error:" + e.getMessage());
                // TODO: handle exception
        }
        g.drawImage(img, x, y, null);
    }
}