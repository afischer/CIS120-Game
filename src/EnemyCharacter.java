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

public class EnemyCharacter extends Character {
    public static final String IMG_LOC = FILE_PATH + "enemyS.png";
    
    public static final int INIT_X = 500;
    public static final int INIT_Y = 500;
    
    private static BufferedImage img;
    
    public EnemyCharacter() {
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

    public void moveRandom() {
        double r = Math.random();
        if (r < .25) {
            this.moveN();
        } else if (r < .5) {
            this.moveS();
        } else if (r < .75) {
            this.moveE();
        } else {
            this.moveW();
        }
                
    }
}
