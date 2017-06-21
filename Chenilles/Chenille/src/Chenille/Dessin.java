package Chenille;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * Defini le contenu de la fen�tre de l'application d'animation des Chenille.
 * Une zone de dessin est un JPanel qui g�re un liste d'objets Chenille.
 * Lorsqu'il se r�affiche l'objet Dessin redessinne les diff�rents objets
 * Chenille contenus dans cette liste.
 */
public class Dessin extends JPanel {


	/**
	 * stocke la liste des Chenilles ayant �t� ajout�es � cette zone de dessin.
	 */
	private final List<Chenille> listeDesChenilles = new ArrayList<>();

	/**
	 * retourne la largeur de la zone de dessin.
	 *
	 * @return la largeur.
	 */
	public int getLargeur() {
		return getWidth();
	}

	/**
	 * retourne la hauteur de la zone de dessin.
	 *
	 * @return la hauteur.
	 */
	public int getHauteur() {
		return getHeight();
	}

	/**
	 * ajoute un Chenille � la zone de dessin.
	 *
	 * @param ch
	 *            la Chenille � ajouter au Dessin
	 * @see Chenille
	 */
	public void ajouterObjet(Chenille ch) {

		if (!listeDesChenilles.contains(ch)) {
			// l'objet n'est pas d�j� dans la liste
			// on le rajoute a la liste des objets du dessin
			listeDesChenilles.add(ch);
			// le dessin se r�affiche
			repaint();
			this.pause(10);
		}
	}

	/**
	 * temporisation de l'animation.
	 *
	 * @param duree
	 *            delai de temporisation en ms.
	 */
	public void pause(int duree) {
		try {
			Thread.sleep(duree);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * affiche la zone de dessin et son contenu
	 *
	 * @param g
	 *            le contexte graphique
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// dessiner les Objets que contient le dessin
		for (Chenille c : listeDesChenilles) {
			c.dessiner(g);
		}
	}
} // Dessin