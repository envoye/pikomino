package pikomino;

import javax.swing.JFrame;

import pikomino.model.Model;
import pikomino.view.PikominoFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new PikominoFrame(new Model(null)).setVisible(true);

//		JFrame window = new JFrame();
//		DicePanelWithButton content = new DicePanelWithButton();
//		window.setContentPane(content);
//		window.pack();
//		window.setLocation(200, 50);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setResizable(true); // User can't change the window's size.
//		window.setVisible(true);

		// TODO Auto-generated method stub
		String teste3 = "Success2!";
		System.out.println(teste3);
	}

}
