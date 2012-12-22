package pikomino.model;
import java.util.ArrayList;


public class GameBoard {
	private int n_players=2;
	
	private Dice dice;
	//private Barbecue barbecue;
	private ArrayList<Player> players = new ArrayList<Player>();
	private int actualPlayer = 0;
	
	public GameBoard(ArrayList<String> names) throws Exception{
		if(n_players == names.size()){
			for(int i=0; i<n_players; i++){
				players.add(new Player(names.get(i)));
			}
		}else{
			throw new Exception("Erro lista de nomes!");
		}
	}
	
	public GameBoard(int np, ArrayList<String> names) throws Exception{
		if(np >=2 && np <=7){
			n_players = np;
		}else{
			throw new Exception("Number of players not allowed!!");
		}
		
		if(n_players == names.size()){
			for(int i=0; i<n_players; i++){
				players.add(new Player(names.get(i)));
			}
		}else{
			throw new Exception("Erro lista de nomes!");
		}
	}

	public void changeNextPlayer(){
		if((actualPlayer+1)>=n_players){
			actualPlayer=0;
		}else{
			actualPlayer++;
		}
	}
	
	
	
	
	
}
