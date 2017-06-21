package Chenille;

import java.awt.image.BufferedImage;

/**
 * Chenille dont la tête est définie par une image.
 */
public class ChenilleImage extends Chenille {

    /**
     * @param d la feuille de dessin où se situe la chenille
     * @param nbAnneaux nombre d'anneaux de la chenille
     * @param img l'image de la tête
     */
    public ChenilleImage(Dessin d, int nbAnneaux, BufferedImage img) {
        super(d, new TeteImage(d.getLargeur() /2 , d.getHauteur() /2, 0, img),
                img.getWidth() /2, nbAnneaux);
    }
}