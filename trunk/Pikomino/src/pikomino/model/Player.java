package pikomino.model;

import java.util.Stack;

public class Player {
	private String name;
	private Stack<Piece> piecesStack;
	
	public Player(String n){
		name = n;
		piecesStack = new Stack<Piece>();
	}
	
	public int totalWorms(){
		if(isPSEmpty())
			return 0;
		
		return 0;
	}
	
	public int biggestNumber(){
		if(isPSEmpty())
			return 0;
		
		return 0;
	}
	
	private boolean isPSEmpty(){
		return piecesStack.isEmpty();
	}
	
	public void addPiecesStack(Piece p){
		piecesStack.push(p);
	}
	
	public Piece takePiecesStack(){
		return piecesStack.pop();
	}
}
