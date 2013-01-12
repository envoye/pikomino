package pikomino;

import javax.swing.JFrame;

import pikomino.model.GameBoard;
import pikomino.model.Model;
import pikomino.view.PikominoFrame;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {

		new PikominoFrame(new Model(new GameBoard("Player1","Player2","p3"))).setVisible(true);

	}

}
