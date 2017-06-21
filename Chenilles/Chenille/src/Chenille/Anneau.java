package Chenille;

import java.awt.Graphics;

public class Anneau {

	public final static int Rayon = 5; // constante pour définir le rayon par
										// défaut
	protected int xpos; // abscisse du centre de l'anneau
	protected int ypos; // ordonnée du centre de l'anneau
	protected int rayon; // rayon de l'anneau constant

	/**
	 * crée un Anneau en fixant sa position initiale et son rayon
	 * 
	 * @param xInit
	 *            abscisse du centre de l'anneau
	 * @param yInit
	 *            ordonnée du centre de l'anneau
	 * @param r
	 *            rayon de l'anneau
	 */
	public Anneau(int xInit, int yInit, int rInit) {
		this.xpos = xInit;
		this.ypos = yInit;
		this.rayon = rInit;
	}

	/* Constructeur avec rayon par défaut */
	public Anneau(int xInit, int yInit) {
		this.xpos = xInit;
		this.ypos = yInit;
		this.rayon = Rayon;
	}

	/**
	 * retourne abscisse du centre de l'anneau
	 * 
	 * @return abscisse du centre de l'anneau
	 */

	public int getXpos() {
		return xpos;
	}

	/**
	 * retourne ordonnée du centre de l'anneau
	 * 
	 * @return ordonnée du centre de l'anneau
	 */
	public int getYpos() {
		return ypos;
	}

	/**
	 * positionne le centre de l'anneau en un point donné
	 * 
	 * @param px
	 *            abscisse du point
	 * @param py
	 *            ordonnée du point
	 */
	public void placerA(int px, int py) {
		this.xpos = px;
		this.ypos = py;
	}

	/**
	 * affiche l'anneau en le matérialisant par un cercle noir
	 * 
	 * @param g
	 *            objet de classe java.awt.Graphics qui prend en charge la
	 *            gestion de l'affichage dans la fenêtre de dessin
	 */
	public void dessiner(Graphics g) {
		g.drawOval(xpos - rayon, ypos - rayon, 2 * rayon, 2 * rayon);
	}
}
