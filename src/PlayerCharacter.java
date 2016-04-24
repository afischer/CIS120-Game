/**
 * 
 * PlayerCharacter.java
 * @author Andrew Fischer
 *
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PlayerCharacter extends Character {
    public static final String IMG_LOC = FILE_PATH + "charE.png";
    
    public static final int INIT_X = 160;
    public static final int INIT_Y = 310;
    
    private static BufferedImage img;
    
    public PlayerCharacter() {
        super(INIT_X, INIT_Y, 100);
        
        try {
            if (img == null) {
                img = ImageIO.read(new File(IMG_LOC));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawImage(img, pos_x, pos_y, null);
    }
}
