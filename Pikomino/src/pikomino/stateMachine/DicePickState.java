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
public class DicePickState extends State {

	/**
	 * 
	 */
	public DicePickState(Model pikominoModel, GameBoard gameBoard) {
		super(pikominoModel, gameBoard);
	}
	@Override
	public void dicePick(int i) {
		if(!gameBoard.moveDiceToPlayedList(i))
			return;

		if(gameBoard.getPlayableDice().size() > 0) {
			//Go back to roll dice state
			pikominoModel.setState(pikominoModel.getDiceRollState());
		} else {
			if(gameBoard.hasWorm() && gameBoard.hasAvaliablePiece())
			{
				pikominoModel.setState(pikominoModel.getPieceChoiceState());
			} else {
				gameBoard.returnPiece();

				if(gameBoard.getPieces().size() == 0) {
					pikominoModel.setState(pikominoModel.getEndGameState());
					return;
				}
				
				pikominoModel.setState(pikominoModel.getNewTurnState());
			}
		}
	}
	
	@Override
	public boolean canPickDice() {
		return true;
	}

}
