package pikomino.view.screen;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import pikomino.model.Model;
import pikomino.model.Piece;
import pikomino.utils.Images;
import pikomino.view.GamePanel;

public class Screen {

	protected GamePanel gamePanel;
	protected Model model;
	protected int widthScreen, heightScreen;
	
	public Screen(GamePanel gamePanel, Model model, int widthScreen,
			int heightScreen) {
		this.gamePanel = gamePanel;
		this.model = model;
		this.widthScreen = widthScreen;
		this.heightScreen = heightScreen;
	}


	public synchronized void render(Graphics2D gBuffered) {

		Rectangle2D stringBox;
		
        gBuffered.drawImage(Images.background, 0, 0, widthScreen, heightScreen, null);
        
        List<Piece> pieces = model.getPieces();
        
        for(int i = 0; i< pieces.size() ; i++)
        {
        	
        	gBuffered.drawImage(Images.getImageOf(pieces.get(i)), 40 + (i%8)*60 , 50 +  130 * (i/8), 50, 100, null);
        }
        
	}


	public synchronized void render(Graphics2D gBuffered, int widthScreen, int heightScreen) {
		
		setScreenSize(widthScreen, heightScreen);
		render(gBuffered);
	}
	
	public void setScreenSize(int widthScreen, int heightScreen){
		this.widthScreen = widthScreen;
		this.heightScreen = heightScreen;
	}
	
}
