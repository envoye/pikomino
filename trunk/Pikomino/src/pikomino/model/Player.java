package pikomino.model;

import java.util.Stack;

public class Player {
	private String name;
	private Stack<Piece> piecesStack;
	
	public Player(String n){
		name = n;
		piecesStack = new Stack<Piece>();
	}
}
