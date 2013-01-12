package pikomino.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Transparency;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import pikomino.model.Model;
import pikomino.utils.Images;
import pikomino.view.screen.Screen;
import java.awt.image.BufferedImage;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * This class is a Panel, this panel is where all the information about the game
 * is drawn, this information is drawn by the current screen (class Screen).
 * In junction with the PikominoFrame and Screen class represents the Vision and
 * Control of the MVC.
 *
 */
public class MenuPanel extends JPanel {
	
	public MenuPanel(final JPanel gamePanel, final Model model) {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("655px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("85px"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(14dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("45dlu"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("365px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("90px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		btnHelp = new JButton("");
		btnHelp.setOpaque(false);
		btnHelp.setFocusPainted(false);
		btnHelp.setBorderPainted(false);
		btnHelp.setContentAreaFilled(false);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File pdf = new File("Data\\Images\\Manual\\regras_pickomino_br.pdf");  
				try {  
				  Desktop.getDesktop().open(pdf);  
				} catch(Exception ex) {  
				  ex.printStackTrace();  
				  JOptionPane.showMessageDialog(null, "Não é possivel mostrar ajuda!");  
				}
				
			}
		});
		add(btnHelp, "4, 4, 3, 3");
		
		btnNew = new JButton("");
		btnNew.setOpaque(false);
		btnNew.setFocusPainted(false);
		btnNew.setBorderPainted(false);
		btnNew.setContentAreaFilled(false);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gamePanel.removeAll();
				JPanel newGamePanel = new PlayersPanel(gamePanel, model);
				gamePanel.add(newGamePanel, BorderLayout.CENTER);
				gamePanel.updateUI();
			}
		});
		add(btnNew, "4, 10, 3, 1, default, fill");
	

		
		
		//gamePanel.removeAll();
		//gamePanel.add(new PlayerPanel(gamePanel), BorderLayout.CENTER);
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
		
		g.fillRect(0, 0, getWidth(), getHeight());

		g.drawImage(Images.getInicio(), 0, 0, widthScreen, heightScreen,null);

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
	static public int heightScreen = 624;

	private int posX, posY, widthImage, heightImage;

	private Model model = null;

	Screen screen;
	private JButton btnNew;
	private JButton btnHelp;

}
