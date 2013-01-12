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
	public void pieceChoice() {

		pikominoModel.setState(pikominoModel.getNewTurnState());
	}

	@Override
	public void stealPiece() {
		if(gameBoard.actualPlayerCanSteal())
		{
			gameBoard.stealPiece();
		}
	}

	@Override
	public void pickPiece() {
		if(gameBoard.actualPlayerCanPick())
		{
			gameBoard.takePiece();
		}
	}
	
}
