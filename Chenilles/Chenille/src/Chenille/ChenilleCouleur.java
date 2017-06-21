package Chenille;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Chenille en couleur
 *
  */
public class ChenilleCouleur extends Chenille {

    /**
     * la couleur de la Chenille
     */
    private final Color coul;

    /**
     * @param coul couleur de la chenille.
     * @param d le dessin o� elle se d�place.
     * @param r le rayon des ses ann�eaux et de sa t�te.
     * @param nbAnneaux le nombre d'anneaux.
     */
    public ChenilleCouleur(Color coul, Dessin d, int r, int nbAnneaux) {
        super(d, r, nbAnneaux);
        this.coul = coul;
    }

    @Override
    public void dessiner(Graphics g) {
        Graphics gd = g.create();   // fait une copie du contexte graphique
        gd.setColor(coul);   // pour que le changement de couleur n'affecte que
        // cette chenille
        super.dessiner(gd);
    }

}
