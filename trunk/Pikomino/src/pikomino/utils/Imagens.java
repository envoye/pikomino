package pikomino.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Imagens {

    public static BufferedImage ImagemDadoMinhoca = null;
    public static BufferedImage ImagemDadoCinco = null;
    public static BufferedImage ImagemDadoQuatro = null;
    public static BufferedImage ImagemDadoTres = null;
    public static BufferedImage ImagemDadoDois = null;
    public static BufferedImage ImagemDadoUm = null;
    
    public static BufferedImage ImagemPeca21 = null;
    public static BufferedImage ImagemPeca22 = null;
    public static BufferedImage ImagemPeca23 = null;
    public static BufferedImage ImagemPeca24 = null;
    public static BufferedImage ImagemPeca25 = null;
    public static BufferedImage ImagemPeca26 = null;
    public static BufferedImage ImagemPeca27 = null;
    public static BufferedImage ImagemPeca28 = null;
    public static BufferedImage ImagemPeca29 = null;
    public static BufferedImage ImagemPeca30 = null;
    public static BufferedImage ImagemPeca31 = null;
    public static BufferedImage ImagemPeca32 = null;
    public static BufferedImage ImagemPeca33 = null;
    public static BufferedImage ImagemPeca34 = null;
    public static BufferedImage ImagemPeca35 = null;
    public static BufferedImage ImagemPeca36 = null;

    static {
        try {


            ImagemDadoMinhoca = ImageIO.read(new File("Imagens\\DadoMinhoca.png"));
            ImagemDadoCinco = ImageIO.read(new File("Imagens\\DadoCinco.png"));
            ImagemDadoQuatro = ImageIO.read(new File("Imagens\\DadoQuatro.png"));
            ImagemDadoTres = ImageIO.read(new File("Imagens\\DadoTres.png"));
            ImagemDadoDois = ImageIO.read(new File("Imagens\\DadoDois.png"));
            ImagemDadoUm = ImageIO.read(new File("Imagens\\DadoUm.png"));
    
            ImagemPeca21 = ImageIO.read(new File("Imagens\\Peca21.png"));
            ImagemPeca22 = ImageIO.read(new File("Imagens\\Peca22.png"));
            ImagemPeca23 = ImageIO.read(new File("Imagens\\Peca23.png"));
            ImagemPeca24 = ImageIO.read(new File("Imagens\\Peca24.png"));
            ImagemPeca25 = ImageIO.read(new File("Imagens\\Peca25.png"));
            ImagemPeca26 = ImageIO.read(new File("Imagens\\Peca26.png"));
            ImagemPeca27 = ImageIO.read(new File("Imagens\\Peca27.png"));
            ImagemPeca28 = ImageIO.read(new File("Imagens\\Peca28.png"));
            ImagemPeca29 = ImageIO.read(new File("Imagens\\Peca29.png"));
            ImagemPeca30 = ImageIO.read(new File("Imagens\\Peca30.png"));
            ImagemPeca31 = ImageIO.read(new File("Imagens\\Peca31.png"));
            ImagemPeca32 = ImageIO.read(new File("Imagens\\Peca32.png"));
            ImagemPeca33 = ImageIO.read(new File("Imagens\\Peca33.png"));
            ImagemPeca34 = ImageIO.read(new File("Imagens\\Peca34.png"));
            ImagemPeca35 = ImageIO.read(new File("Imagens\\Peca35.png"));
            ImagemPeca36 = ImageIO.read(new File("Imagens\\Peca36.png"));
            
            

}
catch (IOException e) {
        }
    }

    
}
