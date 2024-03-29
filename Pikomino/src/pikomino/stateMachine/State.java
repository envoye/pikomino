/**
 * 
 */
package pikomino.stateMachine;

import pikomino.model.GameBoard;
import pikomino.model.Model;
import pikomino.model.Piece;

/**
 * This is an abstract class to serve as an interface to the other states.
 * 
 */
public abstract class State {
	
	protected Model pikominoModel;
	protected GameBoard gameBoard;
	
    public State(Model pikominoModel, GameBoard gameBoard) {
		this.pikominoModel = pikominoModel;
		this.gameBoard = gameBoard;
	}
    
    /**
     * To be executed when the state starts
     */
    public void enterState() {}

    /**
     * To be executed when the state starts
     */
    public void exitState() {}    
    
     
    public void diceRoll() {}
    
    public void dicePick(int i) {}

    public void stealPiece() {}
    
	public void pickPiece() {
	}

	public boolean canRoll() {
		return false;
	}

	public boolean canPick() {
		return false;
	}

	public boolean canSteal() {
		return false;
	}
    
	public boolean canPickDice() {
		return false;
	}

	public boolean isGameOver() {
		return false;
	}
    
    
}