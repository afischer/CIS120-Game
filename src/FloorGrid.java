
/**
 * 
 * FloorGrid.java
 * @author Andrew Fischer
 *
 */

import java.awt.Graphics;


public class FloorGrid {

    private final FloorTile[][] layout;

    private final MapGenerator map;
    private final char[][] mapArray;
    public static int WIN_X;
    public static int WIN_Y;
    public static int START_X;
    public static int START_Y;

    
    public FloorGrid(int gridW, int gridH) {
        map = new MapGenerator(gridW, gridH);
        map.makeMaze();
        mapArray = map.getMaze();
        System.out.println(map.toString());
        layout = new FloorTile[(2 * gridW) + 2][(2 * gridH) + 2];
    }
    
    public void generate() {
        for (int x = 0; x < layout.length - 1; x++) {
            for (int y = 0; y < layout[0].length - 1; y++) {
                // TODO: make this adapt to size of tile image

                int curX = ((x * Game.TILE_W) + (y * Game.TILE_W));
                int curY = ((y * Game.TILE_H) - (x * Game.TILE_H)) + Dungeon.HEIGHT/2;
                
                if (mapArray[x][y] == '0') {
                    layout[x][y] = new LavaTile(curX, curY);    
                } else if (mapArray [x][y] == 's'){
                    layout[x][y] = new StairTile(curX, curY, false);
                    START_X = x;
                    START_Y = y;
                } else if (mapArray [x][y] == 'f'){
                    layout[x][y] = new StairTile(curX, curY, true);
                    WIN_X = x;
                    WIN_Y = y;
                } else {
                    layout[x][y] = new DirtTile(curX, curY);
                }
            }
        }
    }
    
    public void draw(Graphics g) {
        for (int x = 0; x < layout.length-1; x++) {
            for (int y = 0; y < layout[0].length-1; y++) {
                layout[x][y].draw(g);
            }
        }
    }
    
    public FloorTile[][] getLayout() {
        return layout;
    }
    
    public char[][] getRawCharArray() {
        return mapArray;
    }
}
