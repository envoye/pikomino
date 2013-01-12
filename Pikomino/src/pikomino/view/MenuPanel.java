package pikomino.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import pikomino.model.Model;
import pikomino.view.screen.Screen;

/**
 * This class is a Panel, this panel is where all the information about the game
 * is drawn, this information is drawn by the current screen (class Screen).
 * In junction with the PikominoFrame and Screen class represents the Vision and
 * Control of the MVC.
 *
 */
public class MenuPanel extends JPanel {

	JPanel gamePanel;
	
	public MenuPanel(JPanel gamePanel) {

		
		this.gamePanel = gamePanel;
		
		//gamePanel.removeAll();
		//gamePanel.add(new PlayerPanel(gamePanel), BorderLayout.CENTER);
	}

	static public int widthScreen = 800;
	static public int heightScreen = 600;

	private int posX, posY, widthImage, heightImage;

	private Model model = null;

	Screen screen;

}
