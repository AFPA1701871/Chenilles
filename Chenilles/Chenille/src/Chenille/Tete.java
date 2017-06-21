package Chenille;

import java.awt.Graphics;

/**
 * La classe Tete étends la classe Anneau Une tête est en fait un anneau auquel
 * on ajoute la notion de cap (direction de déplacement) Autre différence, elle
 * est repreentée pra un disuqe noir et pas un cercle.
 *
 */
public class Tete extends Anneau {

	private double cap; // direction que suit la chenille

	/* constructeur avec Rayon et Cap par défaut */
	public Tete(int xInit, int yInit) {
		super(xInit, yInit);
		this.cap = 0.0;

	}

	/* constructeur complet */
	public Tete(int xInit, int yInit, int rayonInit, double capInit) {
		super(xInit, yInit, rayonInit);
		this.cap = capInit;

	}

	/*
	 * on surcharge la fonction dessiner pour faire un disque au lieu d'un
	 * cercle
	 */
	@Override
	public void dessiner(Graphics g) {
		g.fillOval(xpos - rayon, ypos - rayon, 2 * rayon, 2 * rayon);
	}

	/* permet de modifier le cap de la tête */
	public void devierCap(double deltaC) {
		this.cap += deltaC;
		this.cap = normalize(cap);
	}

	/* permet de recalculer les angles pour les normaliser */
	private double normalize(double d) {
		double res = Math.abs(d) % 360;
		if (d < 0) {
			if (res > 180) {
				res = 360 - res;
			} else {
				res = -res;
			}
		} else {
			if (res > 180) {
				res = -(360 - res);
			}
		}
		return res;
	}
	
	/* permet de déplacer la tete selon le cap */
	public void deplacerSelonCap(){
		this.xpos= (int) (xpos + rayon * Math.cos(Math.PI * cap / 180));
		this.ypos= (int) (ypos + rayon * Math.sin(Math.PI * cap / 180));
		
	}
	
	public boolean capOK(int xMax, int yMax) {
//		int newX =  (int) (xpos +  rayon * Math.cos(Math.PI * cap / 180));
//		int newY = (int) (ypos + rayon * Math.cos(Math.PI * cap / 180));
//		return newX <= (xMax - rayon) && newY <= ( yMax - rayon) && newX >= rayon && newY >=rayon;
		int x1 = (int) (xpos + rayon * Math.cos(Math.PI * cap / 180));
        int y1 = (int) (ypos + rayon * Math.sin(Math.PI * cap / 180));

        return x1 >= rayon && x1 <= (xMax - rayon) && y1 >= rayon & y1 <= (yMax - rayon);
	}
}
