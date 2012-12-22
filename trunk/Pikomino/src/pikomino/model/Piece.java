package pikomino.model;

public class Piece {
	int value;
	int wormValue;
	
	public Piece() {
		super();
	
		// TODO Auto-generated constructor stub
	}

	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		if(value<20 || value>36){
			return;
		}else{
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
	public int getWormValue() {
		return wormValue;
	}

	public void disable(){
		 this.value = 20;
		 this.wormValue = 0;
	}
	
}
