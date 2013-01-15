/**
 * 
 */
package pikomino.stateMachine;

import pikomino.model.GameBoard;
import pikomino.model.Model;

/**
 * @author Valter
 *
 */
public class EndGameState extends State {

	/**
	 * 
	 */
	public EndGameState(Model pikominoModel, GameBoard gameBoard) {
		super(pikominoModel, gameBoard);
	}
	
	@Override
	public boolean isGameOver() {
		return true;
	}

}
