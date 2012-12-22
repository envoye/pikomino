package pikomino;

public class Dice {
	private int dieId;
	private int dieFaceValue;
	private Dice[] playableDice;
	private Dice[] playedDice;
	
	public void setDieId(int dieId){
		this.dieId = dieId;
	}
	
	public int getDieId(){
		return this.dieId;
	}
	
	public void setDieFaceValue(int dieValue){
		this.dieFaceValue = dieValue;
	}
	
	public int getDieFaceValue(){
		return this.dieFaceValue;
	}

	public Dice(int dieId, int dieValue){
		this.dieId = dieId;
		this.dieFaceValue = dieValue;
		this.playableDice = new Dice[7];
		this.playedDice = new Dice[7];	
	}

	public Dice[] getPlayableDice(){
		return this.playableDice;
	}
	
	public Dice[] getPlayedDice(){
		return this.playedDice;
	}

	public int rollDie(){
		return (int) (Math.random() * 6) + 1;
	}

	// CAUTION: Testing in progress...
	public void diceRoll(){
//		for(int i = 0; i < )
	}
	
}
