/**
 * 
 */
package pikomino.stateMachine;

import java.io.Serializable;

import pikomino.model.Model;

/**
 * This is an abstract class to serve as an interface to the other states.
 * 
 */
public abstract class State {
	
	protected Model pikominoModel;
	
    public State(Model pikominoModel) {
		this.pikominoModel = pikominoModel;
	}
    
    
    /**
     * To be executed when the state starts
     */
    public void startState() {}

    /** 
     * To be executed in the beginning of the game 
     * @return
     */
    public boolean gameStart()
    {
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
    
	/**
     * Message when leaving a state.
     */
    public void endingStateMsg() {
    }
    
    //Help function implemented on their own subclass  
    /**
     * @return String Returns the text with the help message
     */
    public abstract String help();
}