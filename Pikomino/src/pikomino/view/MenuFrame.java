package pikomino.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pikomino.model.Model;

public class MenuFrame extends JFrame {
	private Model model;
	private JPanel panel;
	
	public static void main(String[] args) {
		new MenuFrame().setVisible(true);
		
	}

	public MenuFrame() {
		this.model = model;
		this.setTitle("Pikomino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 628);
		
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(new CardLayout(0, 0));
		panel.add(new MenuPanel(), BorderLayout.CENTER);
		this.setResizable(false);
		
	}
	
}
