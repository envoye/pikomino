package pikomino.model;

import java.util.ArrayList;

public class GameBoard {
	private int n_players = 2;
	private int actualPlayer = -1;

	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Dice> playableDice = new ArrayList<Dice>();
	private ArrayList<Dice> playedDice = new ArrayList<Dice>();
	private ArrayList<Piece> pieces = new ArrayList<Piece>();

	public GameBoard(String... names) throws Exception {
		if (n_players == names.length) {
			for (int i = 0; i < n_players; i++) {
				players.add(new Player(names[i]));
			}
		} else {
			throw new Exception("Erro lista de nomes!");
		}
		createPices();
		createPlayableDice();
	}

	public GameBoard(int np, ArrayList<String> names) throws Exception {
		if (np >= 2 && np <= 7) {
			n_players = np;
		} else {
			throw new Exception("Number of players not allowed!!");
		}

		if (n_players == names.size()) {
			for (int i = 0; i < n_players; i++) {
				players.add(new Player(names.get(i)));
			}
		} else {
			throw new Exception("Erro lista de nomes!");
		}
	}

	public int getN_players() {
		return n_players;
	}

	public void setN_players(int n_players) {
		this.n_players = n_players;
	}

	public int getActualPlayer() {
		return actualPlayer;
	}

	public void setActualPlayer(int actualPlayer) {
		this.actualPlayer = actualPlayer;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public void setPlayableDice(ArrayList<Dice> playableDice) {
		this.playableDice = playableDice;
	}

	public void setPlayedDice(ArrayList<Dice> playedDice) {
		this.playedDice = playedDice;
	}

	public void changeNextPlayer() {
		if ((actualPlayer + 1) >= n_players) {
			actualPlayer = 0;
		} else {
			actualPlayer++;
		}
	}

	public ArrayList<Dice> getPlayableDice() {
		return this.playableDice;
	}

	public ArrayList<Dice> getPlayedDice() {
		return this.playedDice;
	}

	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}

	public Player getCurrentPlayer() {
		return players.get(actualPlayer);
	}

	public void rollDice() {
		// X for die
		for (Dice x : playableDice) {
			// if (x.getDieId() != 0)
			x.setDieFaceValue(rollDie());
		}
	}

	public void selectedDice() {
		// X for die
		for (Dice x : playedDice) {
			// if (x.getDieId() != 0)
			x.setDieFaceValue(rollDie());
		}
	}

	public int getTotalDicePlayed() {
		int diceTotal = 0;

		// X for die
		for (Dice x : playedDice) {
			diceTotal += x.getDieFaceValue();
		}
		return diceTotal;
	}

	public void takePiece(Piece piece) {
		pieces.remove(piece);
		players.get(actualPlayer).addPiecesStack(piece);

	}

	public void returnPiece() {
		Piece piece = players.get(actualPlayer).takePiecesStack();
		addPieceToBoard(piece);
		pieces.remove(pieces.size() - 1);

	}

	public void moveDiceToPlayedList(int index) {
		Dice die_toRemove = new Dice(playableDice.get(index));

		for (Dice x : playedDice) {
			if (die_toRemove.getDieFaceValue() == x.getDieFaceValue()) {
				playableDice.remove(x);
				playedDice.add(die_toRemove);
			}
		}
	}

	private void addPieceToBoard(Piece p) {
		if (p.getValue() < pieces.get(0).getValue()) {
			pieces.add(0, p);
		} else if (p.getValue() < pieces.get(pieces.size() - 1).getValue()) {
			pieces.add(pieces.size(), p);
		} else {

			for (int i = 1; i < pieces.size() - 1; i++) {
				if (pieces.get(i).getValue() > p.getValue()
						&& pieces.get(i + 1).getValue() < p.getValue()) {
					pieces.add(i, p);
				}
			}
		}
	}

	private void createPices() {
		for (int i = 21; i < 37; i++)
			pieces.add(Piece.createPiece(i));

	}

	private void createPlayableDice() {
		for (int i = 0; i < 8; i++) {
			playableDice.add(new Dice(rollDie()));
		}
	}

	private int rollDie() {
		return (int) (Math.random() * 6) + 1;
	}
}
