package org.example;

import java.util.Vector; 
import java.util.Enumeration;

/**
 * @author Pierre Le Fameux
 *
 */
public class Cocktail {
	private String nom;
	private Vector<Ingrediant> ingrediants;
	private Boolean alcoolise;
	
	/**
	 * Creates a Cocktail with its name
	 * @param nom
	 */
	public Cocktail(String nom){
		this.nom = nom;
		this.ingrediants = new Vector<Ingrediant>();
		this.alcoolise = false;
	}

	public String getNom() {
		return nom;
	}

	public Vector<Ingrediant> getIngrediants() {
		return ingrediants;
	}

	public Boolean getAlcoolise() {
		return alcoolise;
	}

	public void setAlcoolise(Boolean alcoolise) {
		this.alcoolise = alcoolise;
	}

	/**
	 * add a new element into the Cocktail.
	 * @param ingrediant
	 * @param quantite
	 */
	public void add(String ingrediant, Double quantite) {
		if (quantite <= 0) {
			throw new IllegalArgumentException("La quantité ne peut pas être négative ou nulle");
		}
		this.ingrediants.add(new Ingrediant(ingrediant, quantite));

	}


	/**
	 * alcoolFree test if the Cocktail is free alcool.
	 * @return true if the Cocktail is free alcool
	 */
	public Boolean alcoolFree(){
		return this.alcoolise;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String retour = new String();
		Enumeration e = this.ingrediants.elements ();
		Ingrediant current;
		while (e.hasMoreElements ()) {
			current = (Ingrediant)e.nextElement();
			retour = retour + current.getIngrediant() + " " + current.getQuantite() + "%" + "\t";
		}
		return retour;
	}

}
