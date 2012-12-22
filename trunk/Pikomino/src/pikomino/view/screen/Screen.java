package pikomino.view.screen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import pikomino.model.Model;
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
        
//		gBuffered.setColor(Color.lightGray);
//        gBuffered.setStroke(new BasicStroke(5,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
//
//        //---------------------------Imprime Baralho------------------------------
//        gBuffered.drawRect(baralhoPosX, baralhoPosY, WidthCarta-2, (int) HeightCarta-2);
//        if(baralho.size()>0)
//        {
//        	gBuffered.drawImage(Imagens.ImagemCostas, baralhoPosX, baralhoPosY,
//        			WidthCarta, HeightCarta, null);
//        }
//        gBuffered.setFont(new Font("Arial", 0,24));
//        stringBox = gBuffered.getFontMetrics().getStringBounds("Baralho", gBuffered);
//        gBuffered.drawString("Baralho", (int) (baralhoPosX + WidthCarta/2 - stringBox.getCenterX()), (int) (baralhoPosY + HeightCarta + stringBox.getHeight()));
//
//		
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
