package org.example;
import java.util.ArrayList;

/**
 * @author Pierre Le Fameux
 *
 */
public class Bar {
	public ArrayList<Boisson> boissonChaude;
	public ArrayList<Boisson> boissonFroide;
	public ArrayList<Boisson> boissonAlcoolisee;
	public ArrayList<Cocktail> cocktailSansAlcoole;
	public ArrayList<Cocktail> cocktailAvecAlcoole;
	
	/**
	 * 
	 */
	public Bar(){
		this.boissonChaude = new ArrayList<Boisson>();
		this.boissonFroide = new ArrayList<Boisson>();
		this.boissonAlcoolisee = new ArrayList<Boisson>();
		
		this.cocktailAvecAlcoole = new ArrayList<Cocktail>();
		this.cocktailSansAlcoole = new ArrayList<Cocktail>();
	}
	
	/**
	 * @param boisson
	 */
	public void add(Boisson boisson){
		if(Boolean.TRUE.equals(boisson.alcoolise)){
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
		Object result;

		result = findAndRemove(boissonFroide, command);
		if (result != null) return result;

		result = findAndRemove(boissonAlcoolisee, command);
		if (result != null) return result;

		result = findAndRemove(boissonChaude, command);
		if (result != null) return result;

		result = findAndRemove(cocktailSansAlcoole, command);
		if (result != null) return result;

		return findAndRemove(cocktailAvecAlcoole, command);
	}

	private <T> T findAndRemove(ArrayList<T> list, String command) {
		for (T item : list) {
			if (item instanceof Boisson && ((Boisson) item).nom.equalsIgnoreCase(command)) {
				list.remove(item);
				return item;
			}
			if (item instanceof Cocktail && ((Cocktail) item).nom.equalsIgnoreCase(command)) {
				list.remove(item);
				return item;
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
