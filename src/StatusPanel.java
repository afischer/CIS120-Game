import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 * StatusPanel.java
 * @author Andrew Fischer
 *
 */

@SuppressWarnings("serial")
public class StatusPanel extends JPanel {
    
    private JLabel status = new JLabel();
    private JLabel health = new JLabel();

    private final JButton resetBtn = new JButton("Restart");
    
    public StatusPanel() {
        Timer timer = new Timer(Game.INTERVAL, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.start();
        
        status.setText("Your Stats:");
        health.setText("HP: " + Dungeon.player.hp);
        
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        
        this.add(status);
        this.add(resetBtn);
        this.add(health);
    }
    
    Timer timer = new Timer(30, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    });
    
    void tick() {
        health.setText("HP: " + Dungeon.player.hp);
    }
    
    private void reset() {
        System.out.println("RESET");
        // TODO Auto-generated method stub    
    };
    
}
