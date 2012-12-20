/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pikomino;

/**
 *
 * @author Paulo Carvalho
 */
public class PecasJogo {
    
	int pecas;
	
    public PecasJogo(int actuais) {
		pecas = actuais;
	}

	public int inser(int n){
        int p = n+pecas;
        return p;
    }
    
}
