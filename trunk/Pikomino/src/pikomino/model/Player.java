package pikomino.model;

import java.util.Stack;

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


	public void setPiecesStack(Stack<Piece> piecesStack) {
		this.piecesStack = piecesStack;
	}


	public int totalWorms(){
		if(isPSEmpty())
			return 0;
		
		int sum=0;
		// X for Piece
		for(Piece x : piecesStack){
			sum+=x.getValue();
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
		return piecesStack.pop();
	}
	
	public Piece getTopPiece(){
		return piecesStack.lastElement();
	}
}
