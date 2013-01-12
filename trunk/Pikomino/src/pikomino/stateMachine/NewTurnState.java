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
	}



	private void resetDice() {
		gameBoard.getPlayableDice().addAll(gameBoard.getPlayedDice());
		gameBoard.getPlayedDice().clear();
		pikominoModel.setState(pikominoModel.getDiceRollState());
	}



	/**
	 * To be executed when starting the game or at the beginning of each move to change player
	 */
	private void pickPlayer(){
		gameBoard.changeNextPlayer();
	}
	
}
