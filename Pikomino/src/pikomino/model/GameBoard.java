package pikomino.model;
import java.util.ArrayList;


public class GameBoard {
	private int n_players=2;
	
	private Dice dice;
	//private Barbecue barbecue;
	private ArrayList<Player> players = new ArrayList<Player>();
	private int actualPlayer = 0;
	// Arrays suited for using the Dice Class	
	//private Dice[] playableDice;
	//private Dice[] playedDice;
	private ArrayList<Dice> playableDice= new ArrayList<Dice>();
	private ArrayList<Dice> playedDice = new ArrayList<Dice>();

	
	
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
	
	public ArrayList getPlayableDice(){
		return this.playableDice;
	}
	
	public ArrayList getPlayedDice(){
		return this.playedDice;
	}

	public int rollDie(){
		return (int) (Math.random() * 6) + 1;
	}

	public void rollDice(){
		// X for die
		for(Dice x : playableDice){
			if (x.getDieId() != 0)
				x.setDieFaceValue(rollDie());
		}
	}

	public void selectedDice(){
		// X for die
		for(Dice x : playedDice){
			if (x.getDieId() != 0)
				x.setDieFaceValue(rollDie());
		}
	}
	
	public int getTotalDicePlayed(){
		int diceTotal = 0;
		
		// X for die
		for(Dice x : playedDice){
			diceTotal += x.getDieFaceValue();
		}
		return diceTotal;
	}

}
