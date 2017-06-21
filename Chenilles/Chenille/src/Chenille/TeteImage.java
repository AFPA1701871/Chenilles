package Chenille;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Tête défine par une image
 * 
 * 
 */
public class TeteImage extends Tete {

	/**
	 * l'image a afficher pour la tête
	 */
	private final BufferedImage img;

	/**
	 * 
	 * @param xInit
	 *            abscisse initial du centre de la tête
	 * @param yInit
	 *            ordonnées intiial du centre de la tête
	 * @param cap
	 *            le cap initial de la tête
	 * @param img
	 *            l'image de la tête.
	 */
	public TeteImage(int xInit, int yInit, int cap, BufferedImage img) {
		super(xInit, yInit, img.getWidth() / 2, cap);
		this.img = img;
	}

	// redéfinition de la méthode dessiner
	@Override
	public void dessiner(Graphics g) {
		g.drawImage(img, this.xpos - rayon, this.ypos - rayon, this.xpos + rayon, this.ypos + rayon, 0, 0, 63, 63,
				null);
	}

}
