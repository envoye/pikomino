package pikomino.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pikomino.model.Model;

public class PikominoFrame extends JFrame {

	private Model model;
	private JPanel contentPane;
	private GamePanel gamePanel;
	
	public PikominoFrame(Model model) {
		
		this.model = model;
		this.setTitle("Pikomino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800+26, 600+71);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(new GamePanel(model), BorderLayout.CENTER);
	}
	
	
	
}
