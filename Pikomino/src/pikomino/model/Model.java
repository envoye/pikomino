package pikomino.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {
	private GameBoard gameBoard;

	public Model(GameBoard gameBoard) {
		this.gameBoard = gameBoard;

		String staticPlayers[] = { "Player1", "Player2", "Player3", "Player4",
				"Player5", "Player6", "Player7" };
		ArrayList<Player> players = new ArrayList<Player>();
		for (String x : staticPlayers) {
			Player p = new Player(x);
			players.add(p);
		}
		gameBoard.setPlayers(players);
		// Avisa os Observers da modificação
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
	
	public void moveDiceToPlayedList(int index) {
		
		gameBoard.moveDiceToPlayedList(index);

		setChanged();
		notifyObservers();
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

}
