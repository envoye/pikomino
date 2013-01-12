package pikomino;

import javax.swing.UIManager;

import pikomino.model.GameBoard;
import pikomino.model.Model;
import pikomino.view.MenuFrame;
import pikomino.view.PikominoFrame;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		
		try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){}       
		//new MenuFrame().setVisible(true);
		
		new PikominoFrame(new Model()).setVisible(true);

	}

}
