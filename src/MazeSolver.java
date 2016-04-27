/**
 * 
 * A recursive maze solving algorithm to be used in JUnit tests.
 * Help from https://www.cs.bu.edu/teaching/alg/maze/
 * 
 * MazeSolver.java
 * @author Andrew Fischer
 *
 */

class MazeSolver {
    
    char[][] grid;
    boolean resultFound = false;
    
    public MazeSolver(char[][] grid) {
        this.grid = grid;
        
        
    }

    public boolean solve (int x, int y) {
        
        if (valid (x, y)) {

            grid[x][y] = 'X'; // visited tag

            if (x == grid.length - 1 && y == grid[0].length - 1)
                resultFound = true;
            else {
                resultFound = solve (x + 1, y);
                if (!resultFound)
                    resultFound = solve (x, y + 1);
                if (!resultFound)
                    resultFound = solve (x-1, y);
                if (!resultFound)
                    resultFound = solve (x, y-1);
            }
            if (resultFound)
                grid[x][y] = '.'; // current path
        }
        return resultFound;
    }

    private boolean valid (int x, int y) {
        boolean valid = false;
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length)
            // Check if cell is start or a path
            if (grid[x][y] == '1' || grid[x][y] == 's') {
                valid = true;
                // check if we're at the end, if so kill the program
            } else if (grid[x][y] == 'f') {
                valid = true;
                resultFound = true;
            }
        return valid;
    }
}