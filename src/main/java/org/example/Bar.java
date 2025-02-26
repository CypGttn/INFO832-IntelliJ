package org.example;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Pierre Le Fameux
 *
 */
public class Bar {
	private ArrayList<Boisson> boissonChaude;
	private ArrayList<Boisson> boissonFroide;
	private ArrayList<Boisson> boissonAlcoolisee;
	private ArrayList<Cocktail> cocktailSansAlcoole;
	private ArrayList<Cocktail> cocktailAvecAlcoole;

	/**
	 * 
	 */
	public Bar(){
		this.boissonChaude = new ArrayList<>();
		this.boissonFroide = new ArrayList<>();
		this.boissonAlcoolisee = new ArrayList<>();
		
		this.cocktailAvecAlcoole = new ArrayList<>();
		this.cocktailSansAlcoole = new ArrayList<>();
	}

	public List<Boisson> getBoissonChaude() {
		return boissonChaude;
	}

	public List<Boisson> getBoissonFroide() {
		return boissonFroide;
	}

	public List<Boisson> getBoissonAlcoolisee() {
		return boissonAlcoolisee;
	}

	public List<Cocktail> getCocktailSansAlcoole() {
		return cocktailSansAlcoole;
	}

	public List<Cocktail> getCocktailAvecAlcoole() {
		return cocktailAvecAlcoole;
	}

	/**
	 * @param boisson
	 */
	public void add(Boisson boisson){
		if(Boolean.TRUE.equals(boisson.getAlcoolise())){
			this.boissonAlcoolisee.add(boisson);
		}else{
			this.boissonFroide.add(boisson);
		}
	}
	
	/**
	 * @param cocktail
	 */
	public void add(Cocktail cocktail){
		if(Boolean.TRUE.equals(cocktail.alcoolFree())){
			this.cocktailSansAlcoole.add(cocktail);
		}else{
			this.cocktailAvecAlcoole.add(cocktail);
		}
	}
	
	/**
	 * @param command
	 * @return
	 */
	public Object serv(String command) {
		for (Boisson b : boissonFroide) {
			if (b.getNom().equalsIgnoreCase(command)) {
				boissonFroide.remove(b);
				return b;
			}
		}

		for (Boisson b : boissonAlcoolisee) {
			if (b.getNom().equalsIgnoreCase(command)) {
				boissonAlcoolisee.remove(b);
				return b;
			}
		}

		for (Boisson b : boissonChaude) {
			if (b.getNom().equalsIgnoreCase(command)) {
				boissonChaude.remove(b);
				return b;
			}
		}

		for (Cocktail c : cocktailSansAlcoole) {
			if (c.getNom().equalsIgnoreCase(command)) {
				cocktailSansAlcoole.remove(c);
				return c;
			}
		}

		for (Cocktail c : cocktailAvecAlcoole) {
			if (c.getNom().equalsIgnoreCase(command)) {
				cocktailAvecAlcoole.remove(c);
				return c;
			}
		}

		return null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder retour = new StringBuilder();
		String eol = System.lineSeparator();

		retour.append("Bar : ").append(eol);
		retour.append("\t Sans alcool").append(eol);
		for (Boisson b : boissonFroide) {
			retour.append("\t\t").append(b.toString()).append(eol);
		}

		retour.append("\t Avec alcool").append(eol);
		for (Boisson b : boissonAlcoolisee) {
			retour.append("\t\t").append(b.toString()).append(eol);
		}

		retour.append("\t Cocktail sans alcool").append(eol);
		for (Cocktail c : cocktailSansAlcoole) {
			retour.append("\t\t").append(c.toString()).append(eol);
		}

		retour.append("\t Cocktail avec alcool").append(eol);
		for (Cocktail c : cocktailAvecAlcoole) {
			retour.append("\t\t").append(c.toString()).append(eol);
		}

		retour.append("\t Boissons chaudes").append(eol);
		for (Boisson b : boissonChaude) {
			retour.append("\t\t").append(b.toString()).append(eol);
		}

		return retour.toString();
	}

}
