package pikomino.model;

public class Dice {
//	private int dieId;
	private int dieFaceValue;
	
	//public Dice(int dieId, int dieValue){
	public Dice(int dieValue){
		this.dieFaceValue = dieValue;
	}
	
	public Dice(Dice die){
		this.dieFaceValue = die.getDieFaceValue();
	}

//	public void setDieId(int dieId){
//		if (dieId < 1 || dieId > 8){
//			return;
//		}else{
//			this.dieId = dieId;
//		}
//	}
//	
//	public int getDieId(){
//		return this.dieId;
//	}
	
	public void setDieFaceValue(int dieValue){
		if (dieValue < 1 || dieValue > 6){
			return;
		}else{
			this.dieFaceValue = dieValue;
		}
	}
	
	public int getDieFaceValue(){
		return this.dieFaceValue;
	}

}
