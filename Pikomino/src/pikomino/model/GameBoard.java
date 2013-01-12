package pikomino.model;

import java.util.ArrayList;

/**
 * This class represents all the data inside a gameboard.
 *
 */
public class GameBoard {
	private int actualPlayerID = -1;

	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Dice> playableDice = new ArrayList<Dice>();
	private ArrayList<Dice> playedDice = new ArrayList<Dice>();
	private ArrayList<Piece> pieces = new ArrayList<Piece>();

	public GameBoard(String... names) {
		
		if (!(names.length >= 2 && names.length <= 7))
			throw new IllegalArgumentException("Number of players not allowed!!");
		
		for (int i = 0; i < names.length; i++) {
			players.add(new Player(names[i]));
		}
		createPices();
		createPlayableDice();
	}


	public int getN_players() {
		return players.size();
	}
	
	public Player getActualPlayer() {
		return players.get(actualPlayerID);
	}

	public int getActualPlayerID() {
		return actualPlayerID;
	}

	public void setActualPlayer(int actualPlayer) {
		this.actualPlayerID = actualPlayer;
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
		if ( actualPlayerID + 1 >= players.size() ) {
			actualPlayerID = 0;
		} else {
			actualPlayerID++;
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
		return players.get(actualPlayerID);
	}

	public void rollDice() {
		// X for die
		for (Dice x : playableDice) {
			// if (x.getDieId() != 0)
			x.setDieFaceValue(rollDie());
		}
	}
	
	public boolean hasWorm() {
		// X for die
		for (Dice x : playedDice) {
			// if (x.getDieId() != 0)
			if(x.getDieFaceValue() == 6)
				return true;
		}
		return false;
	}
	
	public boolean hasAvaliablePiece() {

		if(actualPlayerCanSteal() || actualPlayerCanPick())
			return true;
		return false;
		
	}
	
	public boolean actualPlayerCanSteal() {

		for(int i = 0; i< players.size(); i++) {
			if(i!=actualPlayerID)
			{
				if(players.get(i).getTopPiece() != null && 
						players.get(i).getTopPiece().getValue() == getTotalDicePlayed())
					return true;
			}
		}
		
		return false;
	}
	
	public boolean actualPlayerCanPick() {

		if(pieces.size() > 0 && pieces.get(0).getValue() <= getTotalDicePlayed())
			return true;
		return false;
		
	}

//	public void selectedDice() {
//		// X for die
//		for (Dice x : playedDice) {
//			// if (x.getDieId() != 0)
//			x.setDieFaceValue(rollDie());
//		}
//	}

	public int getTotalDicePlayed() {
		int diceTotal = 0;

		for (Dice x : playedDice) {
			if(x.getDieFaceValue()==6)
				diceTotal +=5;
			else
				diceTotal += x.getDieFaceValue();
		}
		return diceTotal;
	}

	public void takePiece(Piece piece) {
		pieces.remove(piece);
		players.get(actualPlayerID).addPiecesStack(piece);

	}

	public void returnPiece() {
		Piece piece = players.get(actualPlayerID).takePiecesStack();
		if(piece != null)
		addPieceToBoard(piece);
		if(piece != pieces.get(pieces.size() - 1))
			pieces.remove(pieces.size() - 1);

	}

	public boolean moveDiceToPlayedList(int index) {
		Dice die_toRemove = new Dice(playableDice.get(index));
		for (int i = 0 ; i < playedDice.size() ; i++) {
			if (die_toRemove.getDieFaceValue() == playedDice.get(i).getDieFaceValue()) {
				return false;
			}
		}
		for (int i = 0 ; i < playableDice.size() ; i++) {
			if (die_toRemove.getDieFaceValue() == playableDice.get(i).getDieFaceValue()) {
				playableDice.remove(i);
				playedDice.add(die_toRemove);
				i--;
			}
		}
		return true;
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
			playableDice.add(Dice.createDice(rollDie()));
		}
	}

	private int rollDie() {
		return (int) (Math.random() * 6) + 1;
	}

	public void stealPiece() {
		for(int i = 0; i< players.size(); i++) {
			if(i!=actualPlayerID)
			{
				if(players.get(i).getTopPiece() != null && 
						players.get(i).getTopPiece().getValue() == getTotalDicePlayed())
				{
					players.get(actualPlayerID).addPiecesStack(players.get(i).takePiecesStack());
					return;
				}
			}
		}
	}
}
