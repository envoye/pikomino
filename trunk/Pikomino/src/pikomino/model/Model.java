package pikomino.model;
import java.util.List;
import java.util.Observable;

public class Model extends Observable{
	private GameBoard gb;
	
	public Model(GameBoard g){
		gb =g;
		
		//Avisa os Observers da modificação
		setChanged();
		notifyObservers();
	}
	
	public List<Piece> getPieces() {
		return gb.getPieces();
	}
	
	public void changeNextPlayer(){
		gb.changeNextPlayer();
		
		setChanged();
		notifyObservers();
	}
	
	
}
