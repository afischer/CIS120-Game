/**
 * 
 * Character.java
 * @author Andrew Fischer
 *
 */

import java.awt.Graphics;

import example.Game;

public class Character {
    public static final String FILE_PATH = "img/chars/";
    
    public int pos_x;
    public int pos_y;
    
    
    public int hp;
    
    public Character(int start_x, int start_y, int start_hp) {
        this.pos_x = start_x;
        this.pos_y = start_y;
        this.hp = start_hp;
    }
    
    public void moveN() {
        pos_x += Game.TILE_W;
        pos_y -= Game.TILE_H;
    }

    public void moveS() {
        pos_x -= Game.TILE_W;
        pos_y += Game.TILE_H;
    }
    
    public void moveE() {
        pos_x += Game.TILE_W;
        pos_y += Game.TILE_H;
    }
    
    public void moveW() {
        pos_x -= Game.TILE_W;
        pos_y -= Game.TILE_H;
    }
    
    public void draw(Graphics g) {}
}
