package pikomino.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pikomino.model.Model;


/**
 * This class represents the actual window of the game, it has an GamePanel.
 * In junction with the GamePanel and Screen class represents the Vision of the MVC.
 *
 */
public class PikominoFrame extends JFrame implements Observer {

	private Model model;
	private JPanel gamePanel;
	
	/**
	 * This class represents the actual window of the game
	 * @param model its the data model
	 */
	public PikominoFrame(Model model) {
		
		this.model = model;
		this.setTitle("Pikomino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 628);
		
		gamePanel = new JPanel();
		setContentPane(gamePanel);
		gamePanel.setLayout(new CardLayout(0, 0));
		gamePanel.add(new GamePanel(model), BorderLayout.CENTER);
		this.setResizable(false);
		
		model.addObserver(this);
		
		
	}

	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {

		gamePanel.repaint();
	}
	
	
}
