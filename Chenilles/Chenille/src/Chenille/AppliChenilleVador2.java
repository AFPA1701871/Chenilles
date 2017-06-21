package Chenille;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Ouvre une fen�tre et affiche plusieurs chenilles, intialement toutes
 * positionn�es au centre de la fen�tre et qui ensuite se d�placent de mani�re
 * al�atoire. Le nombre de chenille peut �tre fix� par la ligne de commande; par
 * exemple pour avoir 6 chenilles :<BR>
 * <code>java AppliChenille2 6</code>
 *
 */
public class AppliChenilleVador2 {

    /**
     * nombre de chenilles par defaut
     */
    public static final int NBCH = 5;

    public static String[] tetesFileNames = {
        "images/darthVador.png",
        "images/leila.png",
        "images/c3po.png",
        "images/starTrooper.png"
    };

    public static void main(String[] args) throws IOException {

        int nbChenilles; // nombre de chenille a afficher
        BufferedImage[]  images = new BufferedImage[tetesFileNames.length];
        for (int i = 0; i < images.length; i++) {
           images[i] = ImageIO.read(new File(tetesFileNames[i]));
        }

        if (args.length == 0) {
            nbChenilles = NBCH;
        } else {
            nbChenilles = Integer.parseInt(args[0]);
        }

        // cr�ation de la fen�tre de l'application
        JFrame laFenetre = new JFrame("Chenilles");
        laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        laFenetre.setSize(1280, 720);

        // cr�ation de la z�ne de dessin dans la fen�tre
        Dessin d = new Dessin();
        laFenetre.getContentPane().add(d);
        // affiche la fen�tre
        laFenetre.setVisible(true);
        // creation des chenilles. elles sont stock�es dans un tableau et
        // ajout�es � la zone de dessin
        Chenille[] chen = new Chenille[nbChenilles];
        for (int i = 0; i < nbChenilles; i++) {

            chen[i] = new ChenilleImage(d, 10, (i < 3) ? images[i] : images[3]);

            d.ajouterObjet(chen[i]);
        }

        // la boucle d'animation
        while (true) {

            // fait r�aliser aux chenilles un d�placement �l�mentaire
            for (Chenille ch : chen) {
                ch.deplacer();
            }

            // la zone de dessin se r�affiche
            d.repaint();

            // un temps de pause pour avoir le temps de voir le nouveau dessin
            d.pause(50);
            

        }

    }

} 