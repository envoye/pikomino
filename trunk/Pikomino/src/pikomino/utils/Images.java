package pikomino.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import pikomino.model.Dice;
import pikomino.model.Piece;

/**
 * This class holds all the necessary images for the game, this images are private and static, they can only be
 * accessed by their own static functions
 *
 */
public class Images {
	
	private static HashMap<Integer, BufferedImage> diceImages = new HashMap<Integer, BufferedImage>();
	private static HashMap<Integer, BufferedImage> piecesImages = new HashMap<Integer, BufferedImage>();
	
	private static BufferedImage inicio = null;
	private static BufferedImage background = null;
	private static BufferedImage backgroundPlayers = null;
	private static BufferedImage minhoca1 = null;
	private static BufferedImage minhoca2 = null;
	private static BufferedImage pic1 = null;
	private static BufferedImage pic2 = null;
	
	
    static {
        try {
        	inicio = ImageIO.read(new File("Data\\Images\\bgroundInicio.png"));
        	backgroundPlayers = ImageIO.read(new File("Data\\Images\\bgroundForm.png"));
        	background = ImageIO.read(new File("Data\\Images\\Background.png"));
        	//minhoca1 = ImageIO.read(new File("Data\\Images\\Background.jpg"));
        	//minhoca2 = ImageIO.read(new File("Data\\Images\\Background.jpg"));
        	//pic1 = ImageIO.read(new File("Data\\Images\\Background.jpg"));
        	//pic2 = ImageIO.read(new File("Data\\Images\\Background.jpg"));

            diceImages.put(6, ImageIO.read(new File("Data\\Images\\Dice\\DieWorm.png")));
            diceImages.put(5, ImageIO.read(new File("Data\\Images\\Dice\\Die5.png")));
            diceImages.put(4, ImageIO.read(new File("Data\\Images\\Dice\\Die4.png")));
            diceImages.put(3, ImageIO.read(new File("Data\\Images\\Dice\\Die3.png")));
            diceImages.put(2, ImageIO.read(new File("Data\\Images\\Dice\\Die2.png")));
            diceImages.put(1, ImageIO.read(new File("Data\\Images\\Dice\\Die1.png")));
            
            piecesImages.put(20, ImageIO.read(new File("Data\\Images\\Pieces\\PieceBack.png")));
            piecesImages.put(21, ImageIO.read(new File("Data\\Images\\Pieces\\Piece21.png")));
            piecesImages.put(22, ImageIO.read(new File("Data\\Images\\Pieces\\Piece22.png")));
            piecesImages.put(23, ImageIO.read(new File("Data\\Images\\Pieces\\Piece23.png")));
            piecesImages.put(24, ImageIO.read(new File("Data\\Images\\Pieces\\Piece24.png")));
            piecesImages.put(25, ImageIO.read(new File("Data\\Images\\Pieces\\Piece25.png")));
            piecesImages.put(26, ImageIO.read(new File("Data\\Images\\Pieces\\Piece26.png")));
            piecesImages.put(27, ImageIO.read(new File("Data\\Images\\Pieces\\Piece27.png")));
            piecesImages.put(28, ImageIO.read(new File("Data\\Images\\Pieces\\Piece28.png")));
            piecesImages.put(29, ImageIO.read(new File("Data\\Images\\Pieces\\Piece29.png")));
            piecesImages.put(30, ImageIO.read(new File("Data\\Images\\Pieces\\Piece30.png")));
            piecesImages.put(31, ImageIO.read(new File("Data\\Images\\Pieces\\Piece31.png")));
            piecesImages.put(32, ImageIO.read(new File("Data\\Images\\Pieces\\Piece32.png")));
            piecesImages.put(33, ImageIO.read(new File("Data\\Images\\Pieces\\Piece33.png")));
            piecesImages.put(34, ImageIO.read(new File("Data\\Images\\Pieces\\Piece34.png")));
            piecesImages.put(35, ImageIO.read(new File("Data\\Images\\Pieces\\Piece35.png")));
            piecesImages.put(36, ImageIO.read(new File("Data\\Images\\Pieces\\Piece36.png")));
                   

		}
		catch (IOException e) {
			System.out.println("Error on upload images!");
		}
    }

    
    /**
     * The function serves the purpose of returning the correspondent image
     * of an "visible" object in the screen, so that there is no need for the
     * object to have any knowledge of the image and keep the MVC functional
     * 
     * @param object this object can be a Dice or a Piece, otherwise the function will throw a IllegalArgumentException
     * @return the image associated to the state of the Dice/Piece
     */
    public static BufferedImage getImageOf(Object object) {
    	
    	if(object instanceof Piece) {
    		
    		return piecesImages.get(((Piece)object).getValue());
    	}
    	
    	if(object instanceof Dice) {
    		
    		return diceImages.get(((Dice)object).getDieFaceValue());
    	}
    	
    	throw new IllegalArgumentException("Invalid object type");
    	
    }


	/**
	 * This function serves the purpose of returning the background image of the game board
	 * 
	 * @return the image associated with the background of the game board
	 */
	public static BufferedImage getBackground() {
		return background;
	}
	
	public static BufferedImage getInicio() {
		return inicio;
	}
	
	public static BufferedImage getBackgroundPlayers() {
		return backgroundPlayers;
	}
    
}
