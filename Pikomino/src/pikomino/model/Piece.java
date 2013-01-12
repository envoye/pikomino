package pikomino.model;


/**
 * This class represents a Piece in the game, to create a piece use Piece.createPiece(int value).
 *
 */
public class Piece {
	
	private int value = 0;
		
	/**
	 * Creates an Piece object if the value is valid, otherwise throws an IllegalArgumentException.
	 *
	 */
	public static Piece createPiece(int value){
		if(value<20 || value>36)
			throw new IllegalArgumentException("Invalid Piece Value");
		
		return new Piece(value); 
			
	}
	
	private Piece(int value) {
		super();
		this.value = value;	
	}

	public int getValue() {
		return value;
	}
	
	public int getWormValue() {
		
		if(value < 20 || value > 36)
		{
			try {
				throw new IllegalAccessException("Piece should not hava this value: " + value);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		if(value <25){
			return 1;
		}else if(value <29){
			return 2;
		}else if(value <33){
			return 3;
		}else{
			return 4;
		}
		
	}
	
}
