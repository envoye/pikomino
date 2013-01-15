/**
 * 
 */
package pikomino.stateMachine;

import pikomino.model.GameBoard;
import pikomino.model.Model;
import pikomino.model.Piece;

/**
 * @author Valter
 *
 */
public class PieceChoiceState extends State {

	/**
	 * 
	 */
	public PieceChoiceState(Model pikominoModel, GameBoard gameBoard) {
		super(pikominoModel, gameBoard);
	}

	@Override
	public void stealPiece() {
		if(gameBoard.actualPlayerCanSteal())
		{
			gameBoard.stealPiece();
			pikominoModel.setState(pikominoModel.getNewTurnState());
		}
	}

	@Override
	public void pickPiece() {
		if(gameBoard.actualPlayerCanPick())
		{
			gameBoard.takePiece();
			if(gameBoard.getPieces().size() == 0){
				pikominoModel.setState(pikominoModel.getEndGameState());
				return;
			}
			pikominoModel.setState(pikominoModel.getNewTurnState());
		}
	}
	
	@Override
	public boolean canSteal() {
		if(gameBoard.actualPlayerCanSteal())
			return true;
		return false;
	}
	
	@Override
	public boolean canPick() {
		if(gameBoard.actualPlayerCanPick())
			return true;
		return false;
	}
	
}
