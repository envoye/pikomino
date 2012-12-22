package pikomino.model;

public class Dice {
	private int dieId;
	private int dieFaceValue;
	
	public void setDieId(int dieId){
		if (dieId<1 || dieId>8){
			return;
		}else{
			this.dieId = dieId;
		}
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
	}
	
}
