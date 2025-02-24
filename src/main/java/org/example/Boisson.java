package org.example;


/**
 * @author Pierre Le Fameux stagiaire
 *
 */
public class Boisson {
	public String nom;
	public Boolean alcoolise;
	public Float degre;

	/**
	 * @param nom
	 */
	public Boisson(String nom){
		this.nom = nom;
		this.alcoolise = false;
	}

	public String getNom() {
		return nom;
	}

	public Boolean getAlcoolise() {
		return alcoolise;
	}

	public Float getDegre() {
		return degre;
	}

	/**
	 * @param nom
	 * @param degre
	 */
	public Boisson(String nom, Float degre) {
		if (degre < 0) {
			throw new IllegalArgumentException("Le degré d'alcool ne peut pas être négatif");
		}
		this.nom = nom;
		this.degre = degre;
		this.alcoolise = true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String retour = this.nom;
		if(Boolean.TRUE.equals(this.alcoolise)){
			return retour + " (l'abus d'alcool est dangereux pour la sante)";
		}else{
			return retour;
		}
	}
}
