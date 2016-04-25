import java.awt.*;
import java.awt.event.*;
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
                layout[FloorGrid.START_X][FloorGrid.START_Y].y - Game.TILE_H - 10);
        player.setGridPos(FloorGrid.START_X, FloorGrid.START_Y);
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {player.moveW();}
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {player.moveE();}
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {player.moveS();}
                else if (e.getKeyCode() == KeyEvent.VK_UP) {player.moveN();}
                System.out.println("Player at ("+ player.grid_x + ", "+ player.grid_y + ");");
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
                    "You died.",
                    "Oh no",
                    JOptionPane.PLAIN_MESSAGE);
        } else if (player.grid_x == FloorGrid.WIN_X && player.grid_y == FloorGrid.WIN_Y) {
        // check for win
            JOptionPane.showMessageDialog(null,
                    "You won.",
                    "Winner",
                    JOptionPane.PLAIN_MESSAGE);
            floor++;
//            grid = new FloorGrid(floor + 4, floor + 4);
        } 
        repaint();
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
