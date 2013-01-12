package pikomino.view.screen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import pikomino.model.Dice;
import pikomino.model.Model;
import pikomino.model.Piece;
import pikomino.model.Player;
import pikomino.utils.Images;
import pikomino.view.GamePanel;

/**
 * This class represents the screen of the game, this class paints the information
 * that will be presented by the game panel.
 * 
 * In junction with the PikominoFrame and Screen class represents the Vision and
 * Control of the MVC.
 * 
 * In the next version there will be a few more screens
 * for the menus, configurations etc.
 *
 */
public class Screen {

	private static  boolean buttonsair = true;
	private static  boolean buttonhelp = true;
	private static  boolean buttonrodar = true;
	
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
		gBuffered.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		gBuffered.drawImage(Images.getBackground(), 0, 0, widthScreen, heightScreen,
				null);

		List<Piece> pieces = model.getPieces();
		gBuffered.drawRect(0, 0, 620, 300);
		for (int i = 0; i < pieces.size(); i++) {
			gBuffered.drawImage(Images.getImageOf(pieces.get(i)),
					40 + (i % 8) * 70, 25 + 140 * (i / 8), 50, 100, null);
		}

		List<Dice> playableDices = model.getPlayableDice();
		gBuffered.drawRect(0, 300, 380, 150);
		for (int i = 0; i < playableDices.size(); i++) {
			gBuffered.drawImage(Images.getImageOf(playableDices.get(i)),
					30 + (i % 4) * 87, 310 + 70 * (i / 4), 60, 60, null);
		}

		List<Dice> playedDices = model.getPlayedDice();
		gBuffered.drawRect(0, 450, 380, 150);
		for (int i = 0; i < Math.min(playedDices.size(), 8); i++) {
			gBuffered.drawImage(Images.getImageOf(playedDices.get(i)),
					30 + (i % 4) * 87, 460 + 70 * (i / 4), 60, 60, null);
		}

		//gBuffered.drawRect(620, 0, 179, 600);
        //gBuffered.drawRect(380, 300, 240, 300);
        gBuffered.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));

        for (int i = 0; i < model.getPlayers().size(); i++) {
            gBuffered.setColor(new Color(166, 165, 163));
            gBuffered.drawRect(626, 5 + 85 * i, 168, 80);
            
            gBuffered.setColor(new Color(255, 255, 255));
            gBuffered.drawRect(627, 6 + 85 * i, 167, 79);
            
            //gBuffered.setColor(new Color(122, 122, 122, 122));
            //gBuffered.fillRect(626, 5 + 85 * i, 168, 80);

            if (model.getPlayers().get(i).getPiecesStack().size() != 0)
                gBuffered.drawImage(
                        Images.getImageOf(model.getPlayers().get(i)
                                .getTopPiece()), 626, 5 + 85 * i, 50, 80, null);

            gBuffered.setColor(Color.black);
            gBuffered.drawString(model.getPlayers().get(i).getName(), 680,
                    85 * i + 20);
            gBuffered.drawString("Biggest", 740, 85 * i + 20);
            gBuffered.drawString("22", 740, 85 * i + 40);
            gBuffered.drawString("Worms", 740, 85 * i + 60);
            gBuffered.drawString("14", 740, 85 * i + 80);

        }

		gBuffered.setColor(Color.black);
		gBuffered.drawRect(390, 320, 70, 40);
		gBuffered.setColor(new Color(122, 122, 122, 122));
		gBuffered.fillRect(390, 320, 70, 40);
		gBuffered.setColor(Color.black);
		gBuffered.drawString("Roll", 415, 345);
		
		///botão sair
		gBuffered.setColor(Color.black);
		gBuffered.drawRect(490, 550, 70, 40);
		if(buttonsair==true)
			gBuffered.setColor(new Color(122, 122, 122, 122));
		else
			gBuffered.setColor(new Color(220,220,220));
		
		gBuffered.fillRect(490, 550, 70, 40);
		gBuffered.setColor(Color.black);
		gBuffered.drawString("Sair", 515, 575);
		//help
		gBuffered.setColor(Color.black);
		gBuffered.drawRect(562, 550, 40, 40);
		gBuffered.setColor(new Color(122, 122, 122, 122));
		gBuffered.fillRect(562, 550, 40, 40);
		gBuffered.setColor(Color.black);
		gBuffered.drawString("Help", 565, 575);
		
		
		
		///botão 
		

		Player actual = model.getPlayers().get(model.getActualPlayer());
		if(!actual.getPiecesStack().isEmpty())
		{
			gBuffered.drawImage(Images.getImageOf(actual.getPiecesStack().peek()), 470, 320, 50, 80,
					null);
		}
		gBuffered.setColor(Color.black);
		gBuffered.drawString(actual.getName(), 550, 330);
		gBuffered.drawString("Biggest", 550, 450);
		gBuffered.drawString(String.valueOf(actual.biggestNumber()), 550, 475);
		gBuffered.drawString("Worms", 550, 500);
		gBuffered.drawString(String.valueOf(actual.totalWorms()), 550, 525);

		gBuffered.drawString("Dice points", 390, 500);
		gBuffered.drawString(String.valueOf(model.getTotalDicePlayed()), 390, 525);
	}

	public void render(Graphics2D gBuffered, int widthScreen, int heightScreen) {

		setScreenSize(widthScreen, heightScreen);
		render(gBuffered);
	}

	public void setScreenSize(int widthScreen, int heightScreen) {
		this.widthScreen = widthScreen;
		this.heightScreen = heightScreen;
	}
	
	public void clickMouse(int x, int y) {
		
		//System.out.println(x + "-" +y);
		
		//Button "Roll" pressed
		if(x > 390 && x < 459 && y > 320 && y < 359)
		{
			model.rollDice();
			return;
		}
		if(x > 562 && x < 601 && y > 550 && y < 589)
		{
			File pdf = new File("Data\\Images\\Manual\\regras_pickomino_br.pdf");  
			try {  
			  Desktop.getDesktop().open(pdf);  
			} catch(Exception ex) {  
			  ex.printStackTrace();  
			  JOptionPane.showMessageDialog(null, "Não é possivel mostrar ajuda!");  
			}
			return;
		}
		
		
		
		if(x > 490 && x < 559 && y > 550 && y < 589)
		{
			
			return;
		}
		
		
		for (int i = 0; i < model.getPlayableDice().size(); i++) {
			
			if(x > (30 + (i % 4) * 87) && x < (90 + (i % 4) * 87) && y > (310 + 70 * (i / 4)) && y < (370 + 70 * (i / 4)))
			{
				model.moveDiceToPlayedList(i);
				//System.out.println(i);
				return;
			}
		}
		
	}
	
	public void moveMouse(int x, int y) {
		
		//System.out.println(x + "-" +y);
		
		//Button "Roll" pressed
		if(x > 390 && x < 459 && y > 320 && y < 359)
		{
			buttonrodar = false;
			model.update();
		}else{
			buttonrodar = true;
			model.update();
			
		}
	
		
		
		for (int i = 0; i < model.getPlayableDice().size(); i++) {
			
			if(x > (30 + (i % 4) * 87) && x < (90 + (i % 4) * 87) && y > (310 + 70 * (i / 4)) && y < (370 + 70 * (i / 4)))
			{
				model.moveDiceToPlayedList(i);
				//System.out.println(i);
				return;
			}
		}
		
	}
	

}
