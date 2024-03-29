package pikomino.model;

import java.util.Stack;


/**
 * This class represents a Player in the game.
 *
 */
public class Player {
	
	private String name;
	private Stack<Piece> piecesStack;
	
		
	public Player(String n){
		name = n;
		piecesStack = new Stack<Piece>();
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Stack<Piece> getPiecesStack() {
		return piecesStack;
	}


	public int totalWorms(){
		if(isPSEmpty())
			return 0;
		
		int sum=0;
		// X for Piece
		for(Piece x : piecesStack){
			sum+=x.getWormValue();
		}
		
		return sum;
	}
	
	public int biggestNumber(){
		if(isPSEmpty())
			return 0;
		
		int biggest=0;
		for(Piece x : piecesStack){
			if(x.getValue() > biggest){
				biggest = x.getValue();
			}
		}
		
		return biggest;
	}
	
	private boolean isPSEmpty(){
		return piecesStack.isEmpty();
	}
	
	public void addPiecesStack(Piece p){
		piecesStack.push(p);
	}
	
	public Piece takePiecesStack(){
		if(piecesStack.isEmpty())
			return null;
		return piecesStack.pop();
	}
	
	public Piece getTopPiece(){
		if(piecesStack.isEmpty())
			return null;
		return piecesStack.peek();
	}
}
