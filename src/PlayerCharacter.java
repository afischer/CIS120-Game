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
        
    private static BufferedImage img;
    public int pp;
    
    public PlayerCharacter(int start_x, int start_y, int start_pp) {
        super(start_x, start_y, 100);
        
        
        // Always starts at first walkable grid position

        this.pp = start_pp;
        
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
