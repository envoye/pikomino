package pikomino.view;

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

public class GamePanel extends JPanel {

	static public int widthScreen = 800;
	static public int heightScreen = 600;

	private int posX, posY, widthImage, heightImage;

	private Model model = null;

	Screen screen;

	public GamePanel(Model model) {
		this.model = model;
		screen = new Screen(this, model, widthScreen, heightScreen);

		this.addMouseListener(new ClickListener());

	}

	@Override
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);

		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		GraphicsDevice gs = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gs.getDefaultConfiguration();

		BufferedImage bimage = gc.createCompatibleImage(widthScreen,
				heightScreen, Transparency.OPAQUE);
		Graphics2D gBuffered = bimage.createGraphics();

		g.setColor(new Color(12, 117, 24));
		g.fillRect(0, 0, getWidth(), getHeight());

		// gBuffered.setColor(Color.red);
		// gBuffered.fillRect(0,0,getWidth(),getHeight());

		screen.render(gBuffered);

		if (getWidth() > getHeight() * 1.33333f) {
			widthImage = Math.round(getHeight() + getHeight() * (1f / 3f));
			heightImage = getHeight();

			posX = Math.round(Math.max(0, (getWidth() - widthImage) / 2f));
			posY = 0;

		} else {
			if (getWidth() < getHeight() * 1.33333f) {
				widthImage = getWidth();
				heightImage = Math.round(getWidth() - getWidth() * (1f / 4f));

				posX = 0;
				posY = Math
						.round(Math.max(0, (getHeight() - heightImage) / 2f));

			} else {
				posX = 0;
				posY = 0;
				widthImage = getWidth();
				heightImage = getHeight();
			}
		}

		g.drawImage(bimage, posX, posY, widthImage, heightImage, this);
	}

	class ClickListener implements MouseListener {
		@Override
		public void mousePressed(MouseEvent e) {
			screen.clickRato(e.getX(), e.getY());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

	}

}
