package pikomino.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


/**
 * This class serves the purpose of encapsulating all the data (GameBoard) and warn the observers
 * when something is changed; its the Model in the MVC pattern.
 *
 */
public class Model extends Observable {
	private GameBoard gameBoard;

	public Model() {
	}
	
	public Model(GameBoard gameBoard) {
		
		this.gameBoard = gameBoard;

		setChanged();
		notifyObservers();
	}

	public void rollDice() {

		gameBoard.rollDice();

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
		
		gameBoard.moveDiceToPlayedList(index);

		setChanged();
		notifyObservers();
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

	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;	
	}

}
