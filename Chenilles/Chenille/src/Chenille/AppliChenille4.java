package Chenille;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Ouvre une fen�tre et affiche plusieurs chenilles de diff�rents type (Star War,
 * couleur, une chenille de Noel), initialement toutes positionn�es au centre de la
 * fen�tre et qui ensuite se d�placent de mani�re al�atoire.
 *
 * Le nombre de chenille starwar, couleur et la vitesse d'animation (temps de
 * pause entre deux r�affichage) peuvent �tre contr�l�s en les passant comme
 * arguments de la ligne de commande.
 *
 * Par exemple pour avoir 6 chenilles Star WAR, 5 chenilles couleur et un temps
 * de pause de 60ms <code>java AppliChenille4 6 5 60.</code>
 *
 */
public class AppliChenille4 {

    /**
     * nombre de chenilles Star War par defaut
     */
    public static final int NBCH_SW = 5;

    /**
     * nombre de chenilles Star War par defaut
     */
    public static final int NBCH_COUL = 5;

    public static String[] tetesFileNames = {
        "images/darthVador.png",
        "images/leila.png",
        "images/c3po.png",
        "images/starTrooper.png"
    };

    /**
     * Les arguments de la ligne de commande, si ils sont pr�sent, d�finissent
     * dans leur ordre d'apparition:
     *
     * - le nombre de chenilles Star War (sachant qu'il y a une seule princesse
     * Leila, un seul Darth Vador, tout le reste �tant des Stormtroopers). La
     * valeur par d�faut si cet argument est absent est 5.
     *
     * - le nombre de chenilles en couleur. La valeur par d�faut si cet argument
     * est absent est 5.
     *
     * - la vitesse d'animation. La valeur par d�faut si cet argument est absent
     * est 100ms.
     *
     * @param args arguments de la ligne de commande
     * @throws IOException si une image pour une t�te de Chenille n'est pas
     * trouv�e
     */
    public static void main(String[] args) throws IOException {

        int nbChenillesStarWar = NBCH_SW; // nombre de chenille Star War � afficher
        int nbChenillesCoul = NBCH_COUL;  // nombre de chenille couleur � afficher
        int tempsPause = 100; // temps de pause entre deux r�afficahge (en ms).
        BufferedImage[] images = new BufferedImage[tetesFileNames.length];
        for (int i = 0; i < images.length; i++) {
            images[i] = ImageIO.read(new File(tetesFileNames[i]));
        }

        if (args.length >= 1) {
            nbChenillesStarWar = Integer.parseInt(args[0]);
            if (args.length >= 2) {
                nbChenillesCoul = Integer.parseInt(args[1]);
            }
            if (args.length >= 3) {
                tempsPause = Integer.parseInt(args[2]);
            }
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
        Chenille[] chen = new Chenille[nbChenillesStarWar + nbChenillesCoul];
        for (int i = 0; i < nbChenillesStarWar; i++) {

            chen[i] = new ChenilleImage(d, 10, (i < 3) ? images[i] : images[3]);

            d.ajouterObjet(chen[i]);
        }
        for (int i = 0; i < nbChenillesCoul; i++) {
            chen[nbChenillesStarWar + i] = new ChenilleCouleur(
                    new Color((float) Math.random(),
                            (float) Math.random(),
                            (float) Math.random()),
                    d, 20, 15);
            d.ajouterObjet(chen[nbChenillesStarWar + i]);
        }

        // la chenille de Noel
        Chenille cNoel = new ChenilleImage(d, 0, ImageIO.read(new File("images/chenilleNoel.png")));
        d.ajouterObjet(cNoel);

        // la boucle d'animation
        while (true) {

            // fait r�aliser aux chenilles un d�placement �l�mentaire
            for (Chenille ch : chen) {
                ch.deplacer();
            }
            cNoel.deplacer();

            // la zone de dessin se r�affiche
            d.repaint();

            // un temps de pause pour avoir le temps de voir le nouveau dessin
            d.pause(tempsPause);

        }

    }

} 