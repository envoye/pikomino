package pikomino.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Images {
	public static HashMap<Integer, BufferedImage> diceImages = new HashMap<Integer, BufferedImage>();
	
//    public static BufferedImage imageDieWorm = null;
//    public static BufferedImage imageDie5 = null;
//    public static BufferedImage imageDie4 = null;
//    public static BufferedImage imageDie3 = null;
//    public static BufferedImage imageDie1 = null;
//    public static BufferedImage imageDie2 = null;
    
//    public static BufferedImage ImagemPeca21 = null;
//    public static BufferedImage ImagemPeca22 = null;
//    public static BufferedImage ImagemPeca23 = null;
//    public static BufferedImage ImagemPeca24 = null;
//    public static BufferedImage ImagemPeca25 = null;
//    public static BufferedImage ImagemPeca26 = null;
//    public static BufferedImage ImagemPeca27 = null;
//    public static BufferedImage ImagemPeca28 = null;
//    public static BufferedImage ImagemPeca29 = null;
//    public static BufferedImage ImagemPeca30 = null;
//    public static BufferedImage ImagemPeca31 = null;
//    public static BufferedImage ImagemPeca32 = null;
//    public static BufferedImage ImagemPeca33 = null;
//    public static BufferedImage ImagemPeca34 = null;
//    public static BufferedImage ImagemPeca35 = null;
//    public static BufferedImage ImagemPeca36 = null;

    static {
        try {

            diceImages.put(6, ImageIO.read(new File("resources\\Images\\Dice\\DieWorm.png")));
            diceImages.put(5, ImageIO.read(new File("resources\\Images\\Dice\\Die5.png")));
            diceImages.put(4, ImageIO.read(new File("resources\\Images\\Dice\\Die4.png")));
            diceImages.put(3, ImageIO.read(new File("resources\\Images\\Dice\\Die3.png")));
            diceImages.put(2, ImageIO.read(new File("resources\\Images\\Dice\\Die2.png")));
            diceImages.put(1, ImageIO.read(new File("resources\\Images\\Dice\\Die1.png")));
    
//            ImagemPeca21 = ImageIO.read(new File("Images\\Peca21.png"));
//            ImagemPeca22 = ImageIO.read(new File("Images\\Peca22.png"));
//            ImagemPeca23 = ImageIO.read(new File("Images\\Peca23.png"));
//            ImagemPeca24 = ImageIO.read(new File("Images\\Peca24.png"));
//            ImagemPeca25 = ImageIO.read(new File("Images\\Peca25.png"));
//            ImagemPeca26 = ImageIO.read(new File("Images\\Peca26.png"));
//            ImagemPeca27 = ImageIO.read(new File("Images\\Peca27.png"));
//            ImagemPeca28 = ImageIO.read(new File("Images\\Peca28.png"));
//            ImagemPeca29 = ImageIO.read(new File("Images\\Peca29.png"));
//            ImagemPeca30 = ImageIO.read(new File("Images\\Peca30.png"));
//            ImagemPeca31 = ImageIO.read(new File("Images\\Peca31.png"));
//            ImagemPeca32 = ImageIO.read(new File("Images\\Peca32.png"));
//            ImagemPeca33 = ImageIO.read(new File("Images\\Peca33.png"));
//            ImagemPeca34 = ImageIO.read(new File("Images\\Peca34.png"));
//            ImagemPeca35 = ImageIO.read(new File("Images\\Peca35.png"));
//            ImagemPeca36 = ImageIO.read(new File("Images\\Peca36.png"));
            
            

}
catch (IOException e) {
	System.out.println("Aki");
        }
    }

    
}
