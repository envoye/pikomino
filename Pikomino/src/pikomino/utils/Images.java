package pikomino.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Images {
	public static HashMap<Integer, BufferedImage> diceImages = new HashMap<Integer, BufferedImage>();
	public static HashMap<Integer, BufferedImage> piecesImages = new HashMap<Integer, BufferedImage>();
	
	public static BufferedImage background = null;
	
    static {
        try {
        	
        	background = ImageIO.read(new File("Data\\Images\\Background.jpg"));

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

    
}
