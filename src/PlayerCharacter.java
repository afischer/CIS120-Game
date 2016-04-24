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
import javax.swing.JOptionPane;

public class PlayerCharacter extends Character {
    public static final String IMG_LOC = FILE_PATH + "charE.png";
        
    private static BufferedImage img;
    
    public PlayerCharacter(int start_x, int start_y) {
        super(start_x, start_y, 100);
        
        // Always starts at first walkable grid position
        this.grid_x = 1;
        this.grid_y = 1;
        
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
