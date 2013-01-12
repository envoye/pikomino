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
public class DiceRollState extends State {

	/**
	 * 
	 */
	public DiceRollState(Model pikominoModel, GameBoard gameBoard) {
		super(pikominoModel, gameBoard);
	}

	@Override
	public void diceRoll() {
		gameBoard.rollDice();

	}

	@Override
	public void endTurn() {
		if(gameBoard.hasWorm() && gameBoard.hasAvaliablePiece())
		{
			pikominoModel.setState(pikominoModel.getPieceChoiceState());
		}

	}

}
