package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pierre Le Fameux
 *
 */
public class Cave {
	private ArrayList<Boisson> rayons;

	public Cave() {
		this.rayons = new ArrayList<>();
	}

	public List<Boisson> getRayons() {
		return rayons;
	}

	/**
	 * Ajoute une boisson dans la cave
	 * @param b Boisson à ajouter
	 */
	public void add(Boisson b) {
		this.rayons.add(b);
	}

	/**
	 * Récupère et retire une boisson de la cave par son nom
	 * @param nom Nom de la boisson
	 * @return La boisson retirée ou null si absente
	 */
	public Boisson take(String nom) {
		for (Boisson b : rayons) {
			if (b.getNom().equalsIgnoreCase(nom)) {
				rayons.remove(b);
				return b;
			}
		}
		return null;
	}

	/**
	 * Retourne une représentation textuelle de la cave
	 * @return Chaîne de caractères représentant la cave
	 */
	@Override
	public String toString() {
		StringBuilder retour = new StringBuilder("Cave :\n");
		for (Boisson b : rayons) {
			retour.append("\t").append(b.toString()).append("\n");
		}
		return retour.toString();
	}
}
