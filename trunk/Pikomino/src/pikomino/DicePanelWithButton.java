package pikomino;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pikomino.utils.Images;

/**
 * Shows a pair of dice that are rolled when the user clicks a button that
 * appears below the dice.
 */
public class DicePanelWithButton extends JPanel {
    
    private int dado1 = 4;  // The values shown on the dice.
    private int dado2 = 3;
    private int dado3 = 2;
    private int dado4 = 5;
    private int dado5 = 6;
    private int dado6 = 1;
    private int dado7 = 3;
    private int dado8 = 2;
    private Timer timer;   // Used to animate rolling of the dice.

    /**
     * The constructor sets up the panel. It creates the button and the drawing
     * surface panel on which the dice are drawn and puts them into a
     * BorderLayout. It adds an ActionListener to the button that rolls the dice
     * when the user clicks the button.
     */
    public DicePanelWithButton() {
        
        setLayout(new BorderLayout(2, 2));
        setBackground(Color.blue);  // Will show through the gap in the BorderLayout.
        setBorder(BorderFactory.createLineBorder(Color.blue, 2));
        
        JPanel dicePanel;
        dicePanel = new JPanel() {
     @Override
     public void paintComponent(Graphics g) {                
         super.paintComponent(g);  // fill with background color.
         drawDie(g, dado1, 10, 10); // Just draw the dice.
         drawDie(g, dado2, 10, 65);
         drawDie(g, dado3, 65, 10);
         drawDie(g, dado4, 65, 65);
         drawDie(g, dado5, 120, 10);
         drawDie(g, dado6, 120, 65);
         drawDie(g, dado7, 175, 10);
         drawDie(g, dado8, 175, 65);
     }
 };
        
        dicePanel.setPreferredSize(new Dimension(230, 120));
        dicePanel.setBackground(new Color(255, 255, 255));  // light blue
        add(dicePanel, BorderLayout.CENTER);
        
        JButton rollButton = new JButton("Roll!");
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                roll();
            }
        });
        
        add(rollButton, BorderLayout.SOUTH);
        
    } // end constructor

    /**
     * Draw a die with upper left corner at (x,y). The die is 45 by 45 pixels in
     * size. The val parameter gives the value showing on the die (that is, the
     * number of dots).
     */
    void drawDie(Graphics g, int val, int x, int y) {
        //g.setColor(Color.white);
        //g.fillRect(x, y, 45, 45);
        //g.setColor(Color.black);
        //g.drawRect(x, y, 44, 44);
        
        if (val == 1) {
           g.drawImage(Images.diceImages.get(1), x, y, 45, 45, this);
        }
        if (val == 2) {
            g.drawImage(Images.diceImages.get(2), x, y, 45, 45, this);
        }
        if (val == 3) {
            g.drawImage(Images.diceImages.get(3), x, y, 45, 45, this);
        }
        if (val == 4) {
            g.drawImage(Images.diceImages.get(4), x, y, 45, 45, this);
        }
        if (val == 5) {
            g.drawImage(Images.diceImages.get(5), x, y, 45, 45, this);
        }
        if (val == 6) {
            g.drawImage(Images.diceImages.get(6), x, y, 45, 45, this);
        }
        
    }

    /**
     * Run an animation that randomly changes the values shown on the dice 10
     * times, every 100 milliseconds.
     */
    private void roll() {
        if (timer != null) {
            return;
        }
        timer = new Timer(100, new ActionListener() {
            int frames = 1;

            @Override
            public void actionPerformed(ActionEvent evt) {
                dado1 = (int) (Math.random() * 6) + 1;
                dado2 = (int) (Math.random() * 6) + 1;
                dado3 = (int) (Math.random() * 6) + 1;
                dado4 = (int) (Math.random() * 6) + 1;
                dado5 = (int) (Math.random() * 6) + 1;
                dado6 = (int) (Math.random() * 6) + 1;
                dado7 = (int) (Math.random() * 6) + 1;
                dado8 = (int) (Math.random() * 6) + 1;
                repaint();
                frames++;
                if (frames == 10) {
                    timer.stop();
                    timer = null;
                }
            }
        });
        timer.start();
    }
} // end class DicePanelWithButton

