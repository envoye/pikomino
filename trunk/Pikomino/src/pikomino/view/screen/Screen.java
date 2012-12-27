package pikomino.view.screen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import pikomino.model.Dice;
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
        for(int i = 0; i< pieces.size() ; i++){        
        	gBuffered.drawImage(Images.getImageOf(pieces.get(i)), 40 + (i%8)*70 , 25 +  140 * (i/8), 50, 100, null);
        }
              
        List<Dice> dices = model.getPlayableDice();
        gBuffered.drawRect(0 , 300 , 380, 150);
        for(int i = 0; i< dices.size(); i++){
        	gBuffered.drawImage(Images.getImageOf(dices.get(i)), 30 + (i%4)*87 , 310 +  70 * (i/4), 60, 60, null);
        }
        
        List<Dice> dices_ = model.getPlayedDice();
        gBuffered.drawRect(0 , 450 , 380, 150);
        for(int i = 0; i< Math.min(dices_.size(),8) ; i++){
        	gBuffered.drawImage(Images.getImageOf(dices_.get(i)), 30 + (i%4)*87 , 460 +  70 * (i/4) , 60, 60, null);
        	gBuffered.drawImage(Images.diceImages.get(1), 30 + (i%4)*87 , 460 +  70 * (i/4) , 60, 60, null);
        }
        
        gBuffered.drawRect(620 , 0 , 179, 600);
        gBuffered.drawRect(380 , 300 , 240, 300);
        gBuffered.setStroke(new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
        
        for(int i = 0; i< model.getPlayers().size() ; i++)
        {
        	gBuffered.setColor(Color.black);
        	gBuffered.drawRect(626 ,5+ 85*i, 168, 80);
        	gBuffered.setColor(new Color(122,122,122,122));
        	gBuffered.fillRect(626 ,5+ 85*i, 168, 80);
        	
        	if(model.getPlayers().get(i).getPiecesStack().size()!=0)
        		gBuffered.drawImage(Images.getImageOf(model.getPlayers().get(i).getTopPiece()), 626, 5+85*i, 50, 80, null);
        	
        	
        	gBuffered.setColor(Color.black);
        	gBuffered.drawString(model.getPlayers().get(i).getName(), 680, 85*i+20);
        	gBuffered.drawString("Biggest", 740, 85*i+20);
        	gBuffered.drawString("22", 740, 85*i+40);
        	gBuffered.drawString("Worms", 740, 85*i+60);
        	gBuffered.drawString("14", 740, 85*i+80);

        }
        
        gBuffered.setColor(Color.black);
    	gBuffered.drawRect(390 ,320, 70, 40);
    	gBuffered.setColor(new Color(122,122,122,122));
    	gBuffered.fillRect(390 ,320, 70, 40);
    	gBuffered.setColor(Color.black);
    	gBuffered.drawString("Roll", 415, 345);
        
        gBuffered.drawImage(Images.getImageOf(pieces.get(1)), 470, 320, 50, 80, null);
        gBuffered.setColor(Color.black);
    	gBuffered.drawString("Kevin", 550, 330);
    	gBuffered.drawString("Biggest", 550, 450);
    	gBuffered.drawString("22", 550, 475);
    	gBuffered.drawString("Worms", 550, 500);
    	gBuffered.drawString("14", 550, 525);
        
    	
    	gBuffered.drawString("Dice points", 390, 500);
    	gBuffered.drawString("24", 390, 525);
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


