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

public class PikominoFrame extends JFrame implements Observer {

	private Model model;
	private JPanel gamePanel;
	
	public PikominoFrame(Model model) {
		
		this.model = model;
		this.setTitle("Pikomino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800+16, 600+38);
		
		gamePanel = new JPanel();
		gamePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(gamePanel);
		gamePanel.setLayout(new CardLayout(0, 0));
		gamePanel.add(new GamePanel(model), BorderLayout.CENTER);
		this.setResizable(false);
		
		model.addObserver(this);
		
		
	}

	@Override
	public void update(Observable o, Object arg) {

		gamePanel.repaint();
	}
	
	
}
