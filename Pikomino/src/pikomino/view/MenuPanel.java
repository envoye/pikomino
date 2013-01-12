package pikomino.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Transparency;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import pikomino.model.Model;
import pikomino.view.screen.Screen;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class is a Panel, this panel is where all the information about the game
 * is drawn, this information is drawn by the current screen (class Screen).
 * In junction with the PikominoFrame and Screen class represents the Vision and
 * Control of the MVC.
 *
 */
public class MenuPanel extends JPanel {

	JPanel gamePanel;
	JButton btnNewGame, btnRules, exitProg, j;
	private static Font letra = new Font("Verdana", Font.PLAIN, 20);
	
	public MenuPanel(JPanel gamePanel) {
		for(int i=0; i<3; i++){
			JButton j;
			
			j = new JButton("");
			j.setVisible(false);
			add(j);
		}
		
		this.gamePanel = gamePanel;
		setLayout(new GridLayout(7, 3, 0, 0));
		setBackground(new Color(0, 221, 100));
		
		j = new JButton("");
		j.setVisible(false);
		add(j);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.setBackground(new Color(0, 221, 221));
		btnNewGame.setFont(letra);
		//btnNewGame.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		//btnNewGame.setOpaque(false);
		btnNewGame.setFocusPainted(false);
		//btnNewGame.setBorderPainted(false);
		//btnNewGame.setContentAreaFilled(false);
		btnNewGame.setBorder(new RoundedBorder(10));
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNewGame);
		
		
		for(int i=0; i<5; i++){
			JButton j;
			
			j = new JButton("");
			j.setVisible(false);
			add(j);
		}
		
		
		btnRules = new JButton("Rules");
		btnRules.setBackground(new Color(0, 221, 221));
		btnRules.setFont(letra);
		btnRules.setFocusPainted(false);
		btnRules.setBorder(new RoundedBorder(10));
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnRules);
		

		for(int i=0; i<5; i++){
			JButton j;
			
			j = new JButton("");
			j.setVisible(false);
			add(j);
		}

		
		exitProg = new JButton("Exit");
		exitProg.setBackground(new Color(0, 221, 221));
		exitProg.setFont(letra);
		exitProg.setFocusPainted(false);
		exitProg.setBorder(new RoundedBorder(10));
		exitProg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(exitProg);
		
		
		for(int i=0; i<4; i++){
			JButton j;
			
			j = new JButton("");
			j.setVisible(false);
			add(j);
		}
		
		//gamePanel.removeAll();
		//gamePanel.add(new PlayerPanel(gamePanel), BorderLayout.CENTER);
	}

	
	private static class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }


        public boolean isBorderOpaque() {
            return true;
        }


        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x,y,width-1,height-1,radius,radius);
        }
    }
	
	static public int widthScreen = 800;
	static public int heightScreen = 600;

	private int posX, posY, widthImage, heightImage;

	private Model model = null;

	Screen screen;

}
