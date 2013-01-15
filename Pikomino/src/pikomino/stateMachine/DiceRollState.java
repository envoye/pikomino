/**
 * 
 */
package pikomino.stateMachine;

import pikomino.model.Dice;
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
		int cnt = 0;
		for (Dice dice : pikominoModel.getPlayableDice()) {
			for (Dice dice2 : pikominoModel.getPlayedDice()) {
				if(dice.getDieFaceValue() == dice2.getDieFaceValue()){
					cnt++;
					break;
				}			
			}
		}
		if(pikominoModel.getPlayableDice().size() == cnt)
		{
			gameBoard.returnPiece();
			if(gameBoard.getPieces().size() == 0) {
				pikominoModel.setState(pikominoModel.getEndGameState());
				return;
			}
			pikominoModel.setState(pikominoModel.getNewTurnState());
			return;
		}
			
		pikominoModel.setState(pikominoModel.getDicePickState());
	}
	
	@Override
	public boolean canRoll() {
		return true;
	}
	
	@Override
	public void stealPiece() {
		if(canEndTurn() && gameBoard.actualPlayerCanSteal())
		{
			gameBoard.stealPiece();
			pikominoModel.setState(pikominoModel.getNewTurnState());
		}
	}
	
	@Override
	public boolean canSteal() {
		if(canEndTurn() && gameBoard.actualPlayerCanSteal())
			return true;
		return false;
	}

	@Override
	public void pickPiece() {
		if(canEndTurn() && gameBoard.actualPlayerCanPick())
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
	public boolean canPick() {
		if(canEndTurn() && gameBoard.actualPlayerCanPick())
			return true;
		return false;
	}
	
	private boolean canEndTurn() {
		if(gameBoard.hasWorm() && gameBoard.hasAvaliablePiece())
		{
			return true;
		}
		return false;
	}

}
