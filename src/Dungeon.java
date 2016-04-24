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
    
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public final FloorGrid grid = new FloorGrid(7, 7);
    private FloorTile[][] layout = grid.getLayout();
    
    public static PlayerCharacter player; 
    
    public static final int WIDTH  = (int) (screenSize.getWidth() - 400);
    public static final int HEIGHT = (int) (screenSize.getHeight() - 200);
    
    public static final int INTERVAL = 30;
    
    EnemyCharacter ec = new EnemyCharacter();

    
    public Dungeon() {        
        setBorder(BorderFactory.createLineBorder(Color.gray));
        setFocusable(true);
        
        Timer timer = new Timer(INTERVAL, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.start();
        
        // Generate floor grid
        grid.generate();
        
        // Initialize player on first non-wall brick
        player = new PlayerCharacter(
                layout[1][1].x + Game.TILE_W/2 + 5, 
                layout[1][1].y - Game.TILE_H - 10);
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {player.moveW();}
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {player.moveE();}
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {player.moveS();}
                else if (e.getKeyCode() == KeyEvent.VK_UP) {player.moveN();}
            }
        });
    }
    
    void tick() {
        if (Math.random() < .01) {
            ec.moveRandom();
        }
        System.out.println("Player at ("+ player.grid_x + ", "+ player.grid_y + ");");
        if (!layout[player.grid_x][player.grid_y].isWalkable) {
            System.out.println("OUCH");
        }
        repaint();
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
