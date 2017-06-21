package Chenille;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * T�te d�fine par une image
 * 
 * 
 */
public class TeteImage extends Tete {

	/**
	 * l'image a afficher pour la t�te
	 */
	private final BufferedImage img;

	/**
	 * 
	 * @param xInit
	 *            abscisse initial du centre de la t�te
	 * @param yInit
	 *            ordonn�es intiial du centre de la t�te
	 * @param cap
	 *            le cap initial de la t�te
	 * @param img
	 *            l'image de la t�te.
	 */
	public TeteImage(int xInit, int yInit, int cap, BufferedImage img) {
		super(xInit, yInit, img.getWidth() / 2, cap);
		this.img = img;
	}

	// red�finition de la m�thode dessiner
	@Override
	public void dessiner(Graphics g) {
		g.drawImage(img, this.xpos - rayon, this.ypos - rayon, this.xpos + rayon, this.ypos + rayon, 0, 0, 63, 63,
				null);
	}

}
