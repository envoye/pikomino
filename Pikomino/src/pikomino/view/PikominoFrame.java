package pikomino.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
		this.setResizable(false);
		
		//contentPane.addMouseListener(new BoardListener());
	}
	
	/*
	 class BoardListener extends MouseAdapter {
		 
	        public void mousePressed( MouseEvent e){
	            //Botão rodar
	        	if(getX()>=390 && e.getX()<=390+70 && e.getY()>=320 && e.getY()<=320+40){
	        		JOptionPane.showInternalMessageDialog(null, "Roll");
	        		
	        		return;
	        	}
	         
	        	JOptionPane.showInternalMessageDialog(null, "Roll");
	        }
	        
	    }
	    */
}
