/**
 * MapGenerator.java
 * @Author Andrew Fischer
 * 
 * Map generator using recursive backtracking algorithm. Adapted from
 * http://weblog.jamisbuck.org/2010/12/27/maze-generation-recursive-backtracking
 * 
 */

import java.util.Collections;
import java.util.Arrays;

public class MapGenerator {
    private int x;
    private int y;
    private final int[][] map;
 
    public MapGenerator(int x, int y) {
        this.x = x;
        this.y = y;
        map = new int[this.x][this.y];
        generateMaze(0, 0);
    }
 
    private void generateMaze(int cx, int cy) {
        DIR[] dirs = DIR.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (DIR dir : dirs) {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (between(nx, x) && between(ny, y)
                    && (map[nx][ny] == 0)) {
                map[cx][cy] |= dir.bit;
                map[nx][ny] |= dir.opposite.bit;
                generateMaze(nx, ny);
            }
        }
    }
 
    private static boolean between(int v, int upper) {
        return (v >= 0) && (v < upper);
    }
 
    private enum DIR {
        N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
        private final int bit;
        private final int dx;
        private final int dy;
        private DIR opposite;
 
        // use the static initializer to resolve forward references
        static {
            N.opposite = S;
            S.opposite = N;
            E.opposite = W;
            W.opposite = E;
        }
 
        private DIR(int bit, int dx, int dy) {
            this.bit = bit;
            this.dx = dx;
            this.dy = dy;
        }
    };
    
    public String getMapStr() {
        String mapStr = "";
        for (int i = 0; i < y; i++) {
            // draw the north edge
            for (int j = 0; j < x; j++) {
                mapStr += ((map[j][i] & 1) == 0 ? "00" : "01");
            }
            mapStr += ("0");
            // draw the west edge
            for (int j = 0; j < x; j++) {
                mapStr += ((map[j][i] & 8) == 0 ? "01" : "11");
            }
            mapStr += ("0");
        }
        // draw the bottom line
        for (int j = 0; j < x; j++) {
            mapStr += ("00");
        }
        mapStr += ("0");
        return mapStr;
    }
    
    @Override
    public String toString() {
        String mapStr = "";
        for (int i = 0; i < y; i++) {
            // draw the north edge
            for (int j = 0; j < x; j++) {
                mapStr += ((map[j][i] & 1) == 0 ? "+-" : "+ ");
            }
            mapStr += ("+\n");
            // draw the west edge
            for (int j = 0; j < x; j++) {
                mapStr += ((map[j][i] & 8) == 0 ? "| " : "  ");
            }
            mapStr += ("|\n");
        }
        // draw the bottom line
        for (int j = 0; j < x; j++) {
            mapStr += ("+_");
        }
        mapStr += ("+\n");
        return mapStr;
    }
    
}