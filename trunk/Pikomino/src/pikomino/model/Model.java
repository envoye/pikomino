package pikomino.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable{
	private GameBoard gb;
	
	public Model(GameBoard g){
		gb =g;
		
		String staticPlayers []= {"Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7"};
		ArrayList<Player>players = new ArrayList<Player>();
		for(String x: staticPlayers){
			Player p = new Player(x);
			players.add(p);
		}
		gb.setPlayers(players);
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
	
	public ArrayList<Dice> getPlayableDice(){
		return gb.getPlayableDice();
	}
	
	public ArrayList<Dice> getPlayedDice(){
		return gb.getPlayedDice();
	}
	public ArrayList<Player> getPlayers() {
		return gb.getPlayers();
	}
	
}
