package Chenille;

import java.awt.image.BufferedImage;

/**
 * Chenille dont la t�te est d�finie par une image.
 */
public class ChenilleImage extends Chenille {

    /**
     * @param d la feuille de dessin o� se situe la chenille
     * @param nbAnneaux nombre d'anneaux de la chenille
     * @param img l'image de la t�te
     */
    public ChenilleImage(Dessin d, int nbAnneaux, BufferedImage img) {
        super(d, new TeteImage(d.getLargeur() /2 , d.getHauteur() /2, 0, img),
                img.getWidth() /2, nbAnneaux);
    }
}