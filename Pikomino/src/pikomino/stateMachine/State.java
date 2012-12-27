/**
 * 
 */
package pikomino.stateMachine;

import java.io.Serializable;

import pikomino.model.Model;

/**
 * @author Valter
 *
 */
public abstract class State implements Serializable {
  	/**
	 * 
	 */
	private static final long serialVersionUID = -4132701446815438976L;
	
	protected Model pikominoModel;
	
    public State(Model pikominoModel) {
		this.pikominoModel = pikominoModel;
	}

	// @ the beginning of the game 
    public boolean gameStart()
    {
//    	VistaOnirim.messageManager.dispatchMessage("Not a valid option at this time!" + "\nHelp:\n" + help());
        return false;
    }
    
    //Message when activating a state
    abstract public void initialStateMsg();
    
    public Model getPikominoModel() {
		return pikominoModel;
	}

	public void setPikominoModel(Model pikominoModel) {
		this.pikominoModel = pikominoModel;
	}
    
	//Message when leaving a state
    public void endingStateMsg() {
    }
    
    //Help function implemented on their own subclass  
    public abstract String help();
}