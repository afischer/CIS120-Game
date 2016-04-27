import java.awt.*;
import java.awt.event.*;
import java.beans.ConstructorProperties;
import java.util.Random;

import javax.swing.*;

/**
 * 
 * Dungeon.java
 * 
 * @author Andrew Fischer
 *
 */

@SuppressWarnings("serial")
public class Dungeon extends JPanel {
    
    public static int floor = 1;
    
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static FloorGrid grid = new FloorGrid(floor + 4, floor + 4);
    private FloorTile[][] layout = grid.getLayout();
    
    public static PlayerCharacter player; 
    
    public static final int WIDTH  = (int) (screenSize.getWidth() - 400);
    public static final int HEIGHT = (int) (screenSize.getHeight() - 200);
        
    private String msg = "";
    
    EnemyCharacter ec = new EnemyCharacter();

    public Dungeon() {        
        setBorder(BorderFactory.createLineBorder(Color.gray));
        setFocusable(true);
        
        Timer timer = new Timer(Game.INTERVAL, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.start();
        
        // Generate floor grid
        grid.generate();
        
        // Initialize player on first non-wall brick
        player = new PlayerCharacter(
                layout[FloorGrid.START_X][FloorGrid.START_Y].x + Game.TILE_W/2 + 5, 
                layout[FloorGrid.START_X][FloorGrid.START_Y].y - Game.TILE_H - 10,
                20);
        player.setGridPos(FloorGrid.START_X, FloorGrid.START_Y);
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {player.moveW();}
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {player.moveE();}
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {player.moveS();}
                else if (e.getKeyCode() == KeyEvent.VK_UP) {player.moveN();}
                System.out.println(player.toString());
            }
        });
    }
    
    void tick() {
        if (Math.random() < .01) {
            ec.moveRandom();
        }
        if (!layout[player.grid_x][player.grid_y].isWalkable && player.hp > 0) {
            player.decHP(1);
        }
        
        // Check for death
        if (player.hp < 1) {
            JOptionPane.showMessageDialog(null,
                    "Looks like you will never get out of here. \n"
                    + "Hopefully you've had some fun. \n \n"
                    + "Floors Survived: " + floor + "\n"
                    + "",
                    "You've Died.",
                    JOptionPane.PLAIN_MESSAGE);
            floor = 1;
            resetLvl(true);
        } else if (player.grid_x == FloorGrid.WIN_X && player.grid_y == FloorGrid.WIN_Y) {
        // check for win
            JOptionPane.showMessageDialog(null,
                    "You decend.a dark set of stairs. \n"
                    +"You wonder what awaits you on floor " + (floor + 1) + ".",
                    "Floor " + floor + " Complete!",
                    JOptionPane.PLAIN_MESSAGE);
            floor++;
            resetLvl(false);
        } 
        if (player.grid_x == ec.grid_x && player.grid_y == ec.grid_y) {
            encounter();
        }
        repaint();
    }
    
    private void resetLvl(boolean resetHP) {
        if (resetHP) {
            player.hp = 100;
        }
        grid = new FloorGrid(floor + 4, floor + 4);
        grid.generate();
        layout = grid.getLayout();
        player.pos_x = (layout[FloorGrid.START_X][FloorGrid.START_Y].x + Game.TILE_W/2 + 5); 
        player.pos_y = (layout[FloorGrid.START_X][FloorGrid.START_Y].y - Game.TILE_H - 10);
        player.grid_x = FloorGrid.START_X;
        player.grid_y = FloorGrid.START_Y;
    }
    
    private void encounter() {
        msg += "You encounter an enemy!";
        JButton attack = new JButton("Attack!");
        JButton defend = new JButton("Defend");
        JButton flee = new JButton("Run Away!");
        
        attack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((ec.hp >= 0)) {
                msg += "You attack!";
                try {Thread.sleep(400);} catch (InterruptedException e1) {}
                int eDmg = 10 + (int)(Math.random() * 20);
                int pDmg = 5 + (int)(Math.random() * 10);
                ec.decHP(eDmg);
                player.decHP(pDmg);
                msg += "\nYou dealt " + eDmg + " damage! \n"
                        + "Enemy hits back with " + pDmg +" damage!";
                System.out.println(ec.hp);} else {
                    msg = "moo";
                }
            }
        });
        
        defend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Attack!");
            }
        });
        
        
        Object[] buttons = new Object[] {attack, defend, flee};
        ImageIcon sprite = new ImageIcon(ec.getSprite());
        JOptionPane.showOptionDialog(null, msg, "Encounter", 0, JOptionPane.PLAIN_MESSAGE, sprite, buttons, attack);
        
        
    }

    public static FloorTile[][] getGridLayout() {
        return grid.getLayout();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);        
        grid.draw(g);
        player.draw(g);
        ec.draw(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}
