package pikomino.model;

/**
 * This class represents a Dice in the game, to create a dice use Dice.createDice(int value).
 *
 */
public class Dice {

	private int dieFaceValue;
	
	/**
	 * Creates an Dice object if the value is valid, otherwise throws an IllegalArgumentException.
	 *
	 */
	public static Dice createDice(int value){
		if(value<1 || value>6)
			throw new IllegalArgumentException("Invalid Dice Value");
		
		return new Dice(value); 
			
	}
	
	private Dice(int dieValue){
		this.dieFaceValue = dieValue;
	}
	
	public Dice(Dice die){
		this.dieFaceValue = die.getDieFaceValue();
	}
	
	public void setDieFaceValue(int dieValue){
		if (dieValue < 1 || dieValue > 6){
			throw new IllegalArgumentException("Invalid Dice Value");
		}else{
			this.dieFaceValue = dieValue;
		}
	}
	
	public int getDieFaceValue(){
		return this.dieFaceValue;
	}

}
