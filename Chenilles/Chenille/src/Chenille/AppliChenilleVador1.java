package Chenille;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


/**
 * Ouvre une fen�tre et affiche une chenille, intialement positionn�e au centre
 * de la fen�tre et qui ensuite se d�place de mani�re al�atoire.
 *
 */
public class AppliChenilleVador1 {

    public static void main(String[] args) {

        BufferedImage imgVador = null;

        try {
        
            imgVador = ImageIO.read(new File("images/darthVador.png"));

            System.out.println("OK");
        } catch (IOException ex) {
            System.out.println("image vador not found");
            System.exit(0);
        }

        // cr�ation de la fen�tre de l'application
        JFrame laFenetre = new JFrame("Chenilles");
        laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        laFenetre.setSize(512, 512);

        // cr�ation de la z�ne de dessin dans la fen�tre
        Dessin d = new Dessin();
        laFenetre.getContentPane().add(d);

        // affiche la fen�tre
        laFenetre.setVisible(true);

        // creation d'un objet Chenille
        Chenille c1 = new ChenilleImage(d, 10, imgVador);

        // on rajoute cet objet la z�ne de dessin
        d.ajouterObjet(c1);

        // la boucle d'animation
        while (true) {

            // fait r�aliser � la chenille un d�placement �l�mentaire
            c1.deplacer();

            // la zone de dessin se r�affiche
            d.repaint();

            // un temps de pause pour avoir le temps de voir le nouveau dessin
            d.pause(50);

        }

    }

} 