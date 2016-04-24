
/**
 * 
 * FloorGrid.java
 * @author Andrew Fischer
 *
 */

import java.awt.Graphics;

import example.Game;


public class FloorGrid {

    private final FloorTile[][] layout;

    private final MapGenerator map;
    private final String mapArray;

    
    public FloorGrid(int gridW, int gridH, int startY) {
        map = new MapGenerator(gridW, gridH);
        mapArray = map.getMapStr();
        System.out.println(map.toString());
        layout = new FloorTile[(2 * gridW) + 1][(2 * gridH) + 1];
        
        for (int x = 0; x < layout.length; x++) {
            for (int y = 0; y < layout[0].length; y++) {
                // Weird isometric math.
                // TODO: make this adapt to size of tile image
                int curX = (((x + 1) * Game.TILE_W) + (y * Game.TILE_W));
                int curY = (((y + 1) * Game.TILE_H) - (x * Game.TILE_H)) + startY;
                layout[x][y] = new DirtTile(curX, curY);            
            }
        }
        
    }

    public void draw(Graphics g) {
        for (int x = 0; x < layout.length-1; x++) {
            for (int y = 0; y < layout[0].length-1; y++) {
                if (mapArray.charAt(x+(layout[x].length * y)) == '0') {
                    // TODO: walls 
                } else {
                layout[x][y].draw(g);
                }
            }
        }
    }
}
