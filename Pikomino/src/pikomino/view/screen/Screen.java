package pikomino.view.screen;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

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

	private static int saveddice = -1;
	private static  boolean buttonsair = true;
	private static  boolean buttonhelp = true;
	private static  boolean buttonrodar = true;
	
	protected GamePanel gamePanel;
	protected Model model;
	protected int widthScreen, heightScreen;
	
	JButton btroll;
	JButton bTake;
	JButton bSteal;

	public Screen(GamePanel gamePanel, final Model model, int widthScreen,
			int heightScreen) {
		this.gamePanel = gamePanel;
		this.model = model;
		this.widthScreen = widthScreen;
		this.heightScreen = heightScreen;
		
		btroll = new JButton("Roll");
        btroll.setSize(80, 40);
        btroll.setLocation(390, 341);
        gamePanel.add(btroll);
        
        btroll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				model.rollDice();
			}
		});
        
        bTake = new JButton("Take");
        bTake.setSize(80, 40);
        bTake.setLocation(390, 381);
        gamePanel.add(bTake);
        
        bTake.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				model.takePiece();
			}
		});
        
        bSteal = new JButton("Steal");
        bSteal.setSize(80, 40);
        bSteal.setLocation(390, 421);
        gamePanel.add(bSteal);
        
        bSteal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				model.stealPiece();
			}
		});
        
	}

	public void render(Graphics2D gBuffered) {

		Rectangle2D stringBox;
		gBuffered.setColor(Color.black);
		gBuffered.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		gBuffered.setFont(new Font("Arial", Font.BOLD, 13));
		
		gBuffered.drawImage(Images.getBackground(), 0, 0, widthScreen, heightScreen,
				null);

		List<Piece> pieces = model.getPieces();
		//gBuffered.drawRect(0, 0, 620, 300);
		for (int i = 0; i < pieces.size(); i++) {
			gBuffered.drawImage(Images.getImageOf(pieces.get(i)),
					40 + (i % 8) * 70, 25 + 140 * (i / 8), 50, 100, null);
		}

		List<Dice> playableDices = model.getPlayableDice();
		//gBuffered.drawRect(0, 300, 380, 150);
		for (int i = 0; i < playableDices.size(); i++) {
			if(saveddice>=0 && saveddice < playableDices.size() && 
					playableDices.get(i).getDieFaceValue()==playableDices.get(saveddice).getDieFaceValue())
			{
				gBuffered.drawImage(Images.getImageOf(playableDices.get(i)),
						30 + (i % 4) * 87-5, 310 + 70 * (i / 4)-5, 70, 70, null);
				
			}
			else
			{
				gBuffered.drawImage(Images.getImageOf(playableDices.get(i)),
						30 + (i % 4) * 87, 310 + 70 * (i / 4), 60, 60, null);
			}
		}

		List<Dice> playedDices = model.getPlayedDice();
		//gBuffered.drawRect(0, 450, 380, 150);
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
            gBuffered.setColor(Color.green);
            if(model.getActualPlayerID() == i)
            	gBuffered.fillRect(626, 5 + 85 * i, 168, 80);
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
            gBuffered.drawString(""+ model.getPlayers().get(i).biggestNumber(), 740, 85 * i + 40);
            gBuffered.drawString("Worms", 740, 85 * i + 60);
            gBuffered.drawString(""+ model.getPlayers().get(i).totalWorms(), 740, 85 * i + 80);

        }

        /*gBuffered.setColor(Color.black);
		gBuffered.drawRect(390, 320, 70, 40);
		
		if(buttonrodar==true){
			gBuffered.setColor(new Color(122, 122, 122, 122));
		}
		else{
=======
		
		if(buttonrodar){
			gBuffered.setColor(new Color(33, 103, 204));
			gBuffered.drawRect(390, 320, 70, 40);
			gBuffered.setColor(new Color(122, 122, 122, 122));	
			
			
			
		}
		else{
			gBuffered.setColor(Color.WHITE);
			gBuffered.drawRect(390, 320, 70, 40);
>>>>>>> .r127
			gBuffered.setColor(new Color(182, 182, 132, 122));
<<<<<<< .mine
		}
		
=======
			
		}
>>>>>>> .r127
		gBuffered.fillRect(390, 320, 70, 40);
		gBuffered.setColor(Color.black);
		gBuffered.drawString("Roll", 415, 345);
		*/
        
        
        if(model.canRoll())
        	btroll.setEnabled(true);
        else
        	btroll.setEnabled(false);
        
        
        if(model.canPick())
        	bTake.setEnabled(true);
        else
        	bTake.setEnabled(false);
        
        
        if(model.canSteal())
        	bSteal.setEnabled(true);
        else
        	bSteal.setEnabled(false);
        
        
        
        
		///bot�o sair
//		gBuffered.setColor(Color.black);
//		gBuffered.drawRect(490, 550, 70, 40);
//		if(buttonsair==true)
//			gBuffered.setColor(new Color(122, 122, 122, 122));
//		else
//			gBuffered.setColor(new Color(220,220,220));
//		
//		gBuffered.fillRect(490, 550, 70, 40);
//		gBuffered.setColor(Color.black);
//		gBuffered.drawString("Sair", 515, 575);
//		//help
//		gBuffered.setColor(Color.black);
//		gBuffered.drawRect(562, 550, 40, 40);
//		gBuffered.setColor(new Color(122, 122, 122, 122));
//		gBuffered.fillRect(562, 550, 40, 40);
//		gBuffered.setColor(Color.black);
//		gBuffered.drawString("Help", 565, 575);
//		
		///bot�o 
		
		Player actual = model.getPlayers().get(model.getActualPlayer());
		if(!actual.getPiecesStack().isEmpty())
		{
			gBuffered.drawImage(Images.getImageOf(actual.getPiecesStack().peek()), 470, 320, 50, 80,
					null);
		}
		gBuffered.setColor(Color.black);
		gBuffered.drawString(actual.getName(), 550, 430);
		gBuffered.drawString("Biggest", 550, 450);
		gBuffered.drawString(String.valueOf(actual.biggestNumber()), 550, 475);
		gBuffered.drawString("Worms", 550, 500);
		gBuffered.drawString(String.valueOf(actual.totalWorms()), 550, 525);

		gBuffered.drawString("Dice points", 390, 500);
		gBuffered.drawString(String.valueOf(model.getTotalDicePlayed()), 390, 525);
		
		if(model.isGameOver())
        {
        	gBuffered.setColor(Color.red);
        	gBuffered.setFont(new Font("Arial", Font.BOLD, 33));
        	gBuffered.drawString("Game Over", 310, 290);
        }
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
//		if(x > 562 && x < 601 && y > 550 && y < 589)
//		{
//			File pdf = new File("Data\\Images\\Manual\\regras_pickomino_br.pdf");  
//			try {  
//			  Desktop.getDesktop().open(pdf);  
//			} catch(Exception ex) {  
//			  ex.printStackTrace();  
//			  JOptionPane.showMessageDialog(null, "N�o � possivel mostrar ajuda!");  
//			}
//			return;
//		}
		
		
		
//		if(x > 490 && x < 559 && y > 550 && y < 589)
//		{
//			
//			return;
//		}
		
		y-=21;
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
			buttonrodar = true;
			model.update();
		}else{
			buttonrodar = false;
			model.update();
			
		}
	
		y-=21;
		ArrayList<Dice> p = model.getPlayedDice();
		for (int i = 0; i < model.getPlayableDice().size(); i++) {
			if(model.canPickDice() && x > (30 + (i % 4) * 87) &&
					x < (90 + (i % 4) * 87) && y > (310 + 70 * (i / 4)) && y < (370 + 70 * (i / 4)))
			{
				int face = model.getPlayableDice().get(i).getDieFaceValue();
				Boolean b = true;
				
				for (int j = 0; j <p.size(); j++){
					if(face==p.get(j).getDieFaceValue()){
						b=false;
						break;
					}
				}
				if(b){
					gamePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
					saveddice = i;
				}
				return;
			}
		}
		gamePanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		saveddice=-1;
		
	}
	

}
