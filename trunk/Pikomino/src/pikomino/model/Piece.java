package pikomino.model;

public class Piece {
	int value = 0;
	int wormValue = 0;
		
	public static Piece createPiece(int value){
		if(value<20 || value>36)
			throw new IllegalArgumentException();
		
		return new Piece(value); 
			
	}
	
	private Piece(int value) {
		super();
		setValue(value);	
	}

	public int getValue() {
		return value;
	}
	
	public int getWormValue() {
		return wormValue;
	}
	
	private void setValue(int value) {
			this.value = value;
			if(value == 20){
				this.wormValue = 0;
			}else if(value <25){
				this.wormValue = 1;
			}else if(value <29){
				this.wormValue = 2;
			}else if(value <33){
				this.wormValue = 3;
			}else{
				this.wormValue = 4;
			}
	}
	
}
