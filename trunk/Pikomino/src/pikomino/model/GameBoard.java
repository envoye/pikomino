package pikomino.model;
import java.util.ArrayList;


public class GameBoard {
	private int n_players=2;
	
	private Dice dice;
	//private Barbecue barbecue;
	private ArrayList<Player> players = new ArrayList<Player>();
	private int actualPlayer = 0;
	
	public GameBoard(int np){
		try{
			if(np >=2 && np <=7){
				n_players = np;
			}else{
				throw new Exception();
			}
		}catch(Exception e){
			System.out.println("Numero de jogadores nao aceitavel!");
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
