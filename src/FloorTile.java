/**
 * 
 * FloorTile.java
 * @author Andrew Fischer
 *
 */

import java.awt.Graphics;

public class FloorTile {
    public static final String FILE_PATH = "img/tiles/";
    
    public int x;
    public int y;
    
    public int width;
    public int height;
    
    public boolean isWalkable;
    
    public FloorTile(int x, int y, boolean walkable) {
        this.x = x;
        this.y = y;
        this.isWalkable = walkable;
    }
    
    // Stub method to be overridden.
    public void draw(Graphics g) {}
    
    @Override
    public String toString() {
        return "FloorTile at (" + x + ", " + y + ")";
    }
}
