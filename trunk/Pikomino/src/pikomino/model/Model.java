package pikomino.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import pikomino.stateMachine.DicePickState;
import pikomino.stateMachine.DiceRollState;
import pikomino.stateMachine.EndGameState;
import pikomino.stateMachine.NewTurnState;
import pikomino.stateMachine.PieceChoiceState;
import pikomino.stateMachine.State;


/**
 * This class serves the purpose of encapsulating all the data (GameBoard) and warn the observers
 * when something is changed; its the Model in the MVC pattern.
 *
 */
public class Model extends Observable {
	private GameBoard gameBoard;
	
	private State state;
	private State dicePickState;
	private State diceRollState;
	private State pieceChoiceState;
	private State newTurnState;
	private State endGameState;

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setState(State state) {
		this.state = state;
		state.enterState();
	}

	public State getState() {
		return state;
	}

	public State getDicePickState() {
		return dicePickState;
	}

	public State getDiceRollState() {
		return diceRollState;
	}

	public State getPieceChoiceState() {
		return pieceChoiceState;
	}

	public State getNewTurnState() {
		return newTurnState;
	}

	public State getEndGameState() {
		return endGameState;
	}

	public Model() {
		
	}

	public Model(GameBoard gameBoard) {
		
		this.gameBoard = gameBoard;

		dicePickState = new DicePickState(this, gameBoard);
		diceRollState = new DiceRollState(this, gameBoard);
		pieceChoiceState = new PieceChoiceState(this, gameBoard);
		newTurnState = new NewTurnState(this, gameBoard);
		endGameState = new EndGameState(this, gameBoard);
		
		setState(newTurnState);
		
		setChanged();
		notifyObservers();
	}
	
	

	public void rollDice() {

		state.diceRoll();

		setChanged();
		notifyObservers();
	}

	public List<Piece> getPieces() {
		return gameBoard.getPieces();
	}

	public void changeNextPlayer() {
		gameBoard.changeNextPlayer();

		setChanged();
		notifyObservers();
	}
	
	public void update() {
		

		setChanged();
		notifyObservers();
	}
	
	public void moveDiceToPlayedList(int index) {
		
		state.dicePick(index);

		setChanged();
		notifyObservers();
	}
	
	public boolean actualPlayerCanSteal() {

		return gameBoard.actualPlayerCanSteal();
	}
	
	public boolean actualPlayerCanPick() {

		return gameBoard.actualPlayerCanPick();
	}
	
	public boolean hasWorm() {

		return gameBoard.hasWorm();
	}
	
	public void returnPiece() {

		gameBoard.returnPiece();
	}
	
	public boolean hasAvaliablePiece() {

		return gameBoard.hasAvaliablePiece();
	}
	
	public int getTotalDicePlayed() {
		return gameBoard.getTotalDicePlayed();
	}

	public ArrayList<Dice> getPlayableDice() {
		return gameBoard.getPlayableDice();
	}

	public ArrayList<Dice> getPlayedDice() {
		return gameBoard.getPlayedDice();
	}

	public ArrayList<Player> getPlayers() {
		return gameBoard.getPlayers();
	}
	
	public int getActualPlayer() {
		return gameBoard.getActualPlayerID();
	}

	public void takePiece(Piece piece) {
		gameBoard.takePiece(piece);
		
	}

	public void stealPiece() {
		gameBoard.stealPiece();
		
	}
	
	public void setGameBoard(GameBoard gameBoard){
		this.gameBoard = gameBoard;
		
		dicePickState = new DicePickState(this, gameBoard);
		diceRollState = new DiceRollState(this, gameBoard);
		pieceChoiceState = new PieceChoiceState(this, gameBoard);
		newTurnState = new NewTurnState(this, gameBoard);
		endGameState = new EndGameState(this, gameBoard);
		
		setState(newTurnState);
	}

}
