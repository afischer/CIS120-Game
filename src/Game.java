/**
 * CIS120 Game Project
 * 
 * Game.java
 * @author Andrew Fischer
 *
 */

import java.awt.*;
import javax.swing.*;

public class Game implements Runnable {
    public void run() {
        
        final JFrame frame = new JFrame("Game Frame");
        frame.setLocation(0, 0);
        
        // Status Panel
        final JPanel status_panel = new JPanel();
        frame.add(status_panel, BorderLayout.EAST);
        final JLabel status = new JLabel("Stats pannel goes here");
        status_panel.add(status);
        
        // Play area
        final Dungeon dungeon = new Dungeon(status);
        frame.add(dungeon, BorderLayout.WEST);
        
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        JOptionPane.showMessageDialog(frame,
                "You find yourself in a dark dungeon.\n \n"
                + "Use the arrow keys to move in the isometric space. \n \n"
                + "Be sure to play multiple times; each dungeon is unique!",
                "Instructions",
                JOptionPane.PLAIN_MESSAGE);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }

}
