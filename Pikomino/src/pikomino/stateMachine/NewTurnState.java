package pikomino.stateMachine;

import pikomino.model.GameBoard;
import pikomino.model.Model;

/**
 * @author Valter
 *
 */

public class NewTurnState extends State {

	/**
	 * 
	 */
	public NewTurnState(Model pikominoModel, GameBoard gameBoard) {
		super(pikominoModel, gameBoard);
	}

	

	@Override
	public void enterState() {
		pickPlayer();
		resetDice();
		pikominoModel.setState(pikominoModel.getDiceRollState());
	}



	private void resetDice() {
		gameBoard.getPlayableDice().addAll(gameBoard.getPlayedDice());
		gameBoard.getPlayedDice().clear();
		
	}

	private void pickPlayer(){
		gameBoard.changeNextPlayer();
	}
	
}
