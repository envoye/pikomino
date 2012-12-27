package pikomino.view.screen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
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


	public void render(Graphics2D gBuffered) {

		Rectangle2D stringBox;
		 gBuffered.setColor(Color.black);
		  gBuffered.setStroke(new BasicStroke(5,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
        gBuffered.drawImage(Images.background, 0, 0, widthScreen, heightScreen, null);
        
        List<Piece> pieces = model.getPieces();
        gBuffered.drawRect(0 , 0 , 620, 300);
        for(int i = 0; i< pieces.size() ; i++)
        {
        	
        	gBuffered.drawImage(Images.getImageOf(pieces.get(i)), 40 + (i%8)*70 , 25 +  140 * (i/8), 50, 100, null);
        }
        
      
         List<Piece> dices = model.getPieces();
         gBuffered.drawRect(0 , 300 , 380, 150);
        for(int i = 0; i< Math.min(dices.size(),8) ; i++)
        {
        	
        	gBuffered.drawImage(Images.diceImages.get(1), 30 + (i%4)*87 , 310 +  70 * (i/4), 60, 60, null);
        }
        
        gBuffered.drawRect(0 , 450 , 380, 150);
        for(int i = 0; i< Math.min(dices.size(),8) ; i++)
        {
        	gBuffered.drawImage(Images.getImageOf(dices.get(i)), 30 + (i%4)*87 , 460 +  70 * (i/4) , 60, 60, null);
        }
        gBuffered.drawRect(620 , 0 , 179, 600);
        gBuffered.drawRect(380 , 300 , 240, 300);
        gBuffered.drawString("ola", 625, 300);
        gBuffered.setStroke(new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
        for(int i = 0; i< 7 ; i++)
        {
        	gBuffered.setColor(Color.black);
        	gBuffered.drawRect(626 ,5+ 85*i, 168, 80);
        	gBuffered.setColor(new Color(122,122,122,122));
        	gBuffered.fillRect(626 ,5+ 85*i, 168, 80);
        	
        	gBuffered.drawImage(Images.getImageOf(pieces.get(i)), 626, 5+85*i, 50, 80, null);
        	
        	gBuffered.setColor(Color.black);
        	gBuffered.drawString("Kevin", 680, 85*i+20);
        	gBuffered.drawString("Biggest", 740, 85*i+20);
        	gBuffered.drawString("22", 740, 85*i+40);
        	gBuffered.drawString("Worms", 740, 85*i+60);
        	gBuffered.drawString("14", 740, 85*i+80);
        }
        
        for(int i = 0; i< dices.size() ; i++)
        {
        	
        	gBuffered.drawImage(Images.getImageOf(dices.get(i)), 30 + (i%4)*87 , 460 +  70 * (i/4) , 60, 60, null);
        }
	}


	public void render(Graphics2D gBuffered, int widthScreen, int heightScreen) {
		
		setScreenSize(widthScreen, heightScreen);
		render(gBuffered);
	}
	
	public void setScreenSize(int widthScreen, int heightScreen){
		this.widthScreen = widthScreen;
		this.heightScreen = heightScreen;
	}
	
}
