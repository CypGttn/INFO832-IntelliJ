package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pierre Le Fameux
 *
 */
public class Cocktail {
	private String nom;
	private ArrayList<Ingrediant> ingrediants;
	private Boolean alcoolise;
	
	/**
	 * Creates a Cocktail with its name
	 * @param nom
	 */
	public Cocktail(String nom){
		this.nom = nom;
		this.ingrediants = new ArrayList<>();
		this.alcoolise = false;
	}

	public String getNom() {
		return nom;
	}

	public List<Ingrediant> getIngrediants() {
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

	/**
	 * Retourne une représentation textuelle du cocktail
	 * @return Chaîne de caractères représentant le cocktail
	 */
	@Override
	public String toString(){
		StringBuilder retour = new StringBuilder("Cocktail: " + nom + "\n");
		retour.append("Alcoolisé: ").append(Boolean.TRUE.equals(alcoolise) ? "Oui" : "Non").append("\n");
		retour.append("Ingrédients:\n");
		for (Ingrediant ingrediant : ingrediants) {
			retour.append("\t").append(ingrediant.getNom()).append(" - ")
					.append(ingrediant.getQuantite()).append("%\n");
		}
		return retour.toString();
	}

}
