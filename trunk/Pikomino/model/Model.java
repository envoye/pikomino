import java.util.Observable;

public class Model extends Observable{
	private GameBoard gb;
	
	public Model(GameBoard g){
		gb =g;
		
		//Avisa os Observers da modificação
		setChanged();
		notifyObservers();
	}
	
	
}
