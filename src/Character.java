/**
 * 
 * Character.java
 * @author Andrew Fischer
 *
 */

import java.awt.Graphics;

public class Character {
    public static final String FILE_PATH = "img/chars/";
    
    public int pos_x;
    public int pos_y;
    public int grid_x;
    public int grid_y;
    
    public int hp;
    
    public Character(int start_x, int start_y, int start_hp) {
        this.pos_x = start_x;
        this.pos_y = start_y;
        this.hp = start_hp;
    }
    
    public void setGridPos(int x, int y){
        this.grid_x = x;
        this.grid_y = y;
    }
    
    public void moveN() {

        if (grid_x + 1 < Dungeon.getGridLayout().length - 1 && grid_x > -1) {
            pos_x += Game.TILE_W;
            pos_y -= Game.TILE_H;
            grid_x++;
        }
    }

    public void moveS() {
        if (grid_x - 1 < Dungeon.getGridLayout().length - 1&& grid_x - 1 > -1) {
            pos_x -= Game.TILE_W;
            pos_y += Game.TILE_H;
            grid_x--;
        }
    }
    
    public void moveE() {
        if (grid_y + 1 < Dungeon.getGridLayout()[0].length - 1 && grid_y + 1 > - 1) {
            pos_x += Game.TILE_W;
            pos_y += Game.TILE_H;
            grid_y++;
        }
    }
    
    public void moveW() {
        if (grid_y - 1 < Dungeon.getGridLayout()[0].length-1 && grid_y - 1 > -1) {
            pos_x -= Game.TILE_W;
            pos_y -= Game.TILE_H;
            grid_y--;
        }
    }
    
    public void decHP(int amt) {
        this.hp -= amt;
    }
    
    public void draw(Graphics g) {}
    
    @Override
    public String toString() {
        return "Character at ("+ grid_x + ", "+ grid_y + ");";

    }
}
