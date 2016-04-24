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
    public PlayerCharacter player = new PlayerCharacter();
    public final FloorGrid grid = new FloorGrid(7, 7, HEIGHT/2);

    public static final int WIDTH  = (int) (screenSize.getWidth() - 400);
    public static final int HEIGHT = (int) (screenSize.getHeight() - 200);
    
    public static final int INTERVAL = 30;
    
    EnemyCharacter ec = new EnemyCharacter();

    
    public Dungeon(JLabel status) {
        setBorder(BorderFactory.createLineBorder(Color.gray));
        setFocusable(true);
        
        Timer timer = new Timer(INTERVAL, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.start();
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {player.moveW();}
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {player.moveE();}
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {player.moveS();}
                else if (e.getKeyCode() == KeyEvent.VK_UP) {player.moveN();}
            }

            public void keyReleased(KeyEvent e) {
//                square.v_x = 0;
//                square.v_y = 0;
            }
        });
    }
    
    void tick() {
        if (Math.random() < .01) {
            ec.moveRandom();
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
