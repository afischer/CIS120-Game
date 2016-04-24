/**
 * CIS120 Game Project
 * 
 * Game.java
 * @author Andrew Fischer
 *
 */

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Game implements Runnable {
    public static int TILE_W = 43;
    public static int TILE_H = 24;

    public void run() {
        
        final JFrame frame = new JFrame("Game Frame");
        frame.setLocation(0, 0);
        
        // Status Panel
        final JPanel statusPanel = new StatusPanel();
        frame.add(statusPanel, BorderLayout.EAST);
        
        // Play area
        final Dungeon dungeon = new Dungeon();
        frame.add(dungeon, BorderLayout.WEST);
        dungeon.setFocusable(true);
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        JOptionPane.showMessageDialog(frame,
                "You find yourself in a dark dungeon.\n \n"
                + "Use the arrow keys to move in the isometric space. \n \n"
                + "Be sure to play multiple times; each dungeon is unique!",
                "Instructions",
                JOptionPane.PLAIN_MESSAGE);
        
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                // add quit event listener for mac because command w pls
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }

}
