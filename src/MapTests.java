import static org.junit.Assert.*;
import org.junit.Test;

public class MapTests {

    /**
     * Ensure the map has start and end
     */
    @Test
    public void hasTerminalsTest() {
        FloorGrid grid = new FloorGrid(7, 7);
        char[][] layout = grid.getRawCharArray();
        boolean hasStart = false;
        boolean hasEnd = false;
        for (int x = 0; x < layout.length; x++) {
            for (int y = 0; y < layout.length; y++) {
                if (layout[x][y] == 's') {hasStart = true;}
                if (layout[x][y] == 'f') {hasEnd = true;}
            }
        }
        assertTrue(hasStart && hasEnd);
    }
    
    @Test
    public void terminalsOnEdgesTest() {
        FloorGrid grid = new FloorGrid(7, 7);
        char[][] layout = grid.getRawCharArray();
        boolean hasStart = false;
        boolean hasEnd = false;
        for (int x = 0; x < layout.length; x++) {
            for (int y = 0; y < layout.length; y++) {
                if (layout[x][y] == 's' && y == 0) {hasStart = true;}
                if (layout[x][y] == 'f' && y == layout.length-1) {hasEnd = true;}
            }
        }
        assertTrue(hasStart && hasEnd);
    }
    

    
    @Test
    public void isTraversableTest() {
        FloorGrid grid = new FloorGrid(7, 7);
        char[][] layout = grid.getRawCharArray();
        int startRow = 0;
        for (int x = 0; x< layout.length; x++) {
            for (int y = 0; y < layout[0].length; y++) {
                if (layout[x][y] == 's') {
                    startRow = x;
                }
            }
        }
        
        MazeSolver m = new MazeSolver(layout);
        assertTrue(m.solve(startRow, 0));
        
    }
}
