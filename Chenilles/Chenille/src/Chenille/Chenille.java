package Chenille;

import java.awt.Graphics;

public class Chenille {

	private final Anneau[] lesAnneaux; // liste des anneaux de la chenille
	private Tete laTete; // définit la tet de la chenille
	private Dessin dess; // définit la zone de dessin

	public Chenille(Dessin d, int r, int nbAnneaux) {
		this(d,new Tete(d.getLargeur()/2, d.getHauteur()/2,r,0.0),r,nbAnneaux);
	}
	
	public Chenille(Dessin d, Tete tete, int r, int nbAnneaux){
		this.dess=d;
		this.laTete = tete;
		int xTete = laTete.getXpos();
		int yTete = laTete.getYpos();
		// creer un tableau
		lesAnneaux = new Anneau[nbAnneaux];
		// remplir le tableau
		for (int i =0;i<lesAnneaux.length;i++){
			lesAnneaux[i] = new Anneau(xTete -(i+1) *r, yTete, r);
		}
				
	}

	public void dessiner(Graphics g) {
		laTete.dessiner(g);
		for (int i=0; i< lesAnneaux.length;i++){
			lesAnneaux[i].dessiner(g);
		}
		
	}
	/**
     * fait effectuer à la chenille un déplacement élémentaire en avant dans la
     * direction indiquée par son cap. Le cap subit une déviation alétoire d'un
     * angle de plus ou moins 30 degrés. Si la tête de la chenille atteint un
     * des bords , son cap est alors dévié de 90°.
     */
    public void deplacer() {
        if (lesAnneaux.length > 0) {
        // fait avancer les anneaux.
        // le ième anneau prends la place du (i-1)ème anneau, l'anneau 0 prenant la place
        // de la tête
        for (int i = lesAnneaux.length - 1; i > 0; i--) {
            lesAnneaux[i].placerA(lesAnneaux[i - 1].getXpos(), lesAnneaux[i - 1].getYpos());
        }

        
        lesAnneaux[0].placerA(laTete.getXpos(), laTete.getYpos());
        }

        // calcule un nouveau cap qui garanti que la tête reste dans la zone
        // de dessin
        laTete.devierCap(-30.0 + Math.random() * 60.0);
        while (!laTete.capOK(dess.getLargeur(), dess.getHauteur())) {
            laTete.devierCap(10);
        }
        // fait avancer la tête
        laTete.deplacerSelonCap();
    }
}
