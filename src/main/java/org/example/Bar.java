package org.example;
import java.util.ArrayList;

/**
 * @author Pierre Le Fameux
 *
 */
public class Bar {
	private Vector<Boisson> boissonChaude;
	private Vector<Boisson> boissonFroide;
	private Vector<Boisson> boissonAlcoolisee;
	private Vector<Cocktail> cocktailSansAlcoole;
	private Vector<Cocktail> cocktailAvecAlcoole;

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

	public Vector<Boisson> getBoissonChaude() {
		return boissonChaude;
	}

	public Vector<Boisson> getBoissonFroide() {
		return boissonFroide;
	}

	public Vector<Boisson> getBoissonAlcoolisee() {
		return boissonAlcoolisee;
	}

	public Vector<Cocktail> getCocktailSansAlcoole() {
		return cocktailSansAlcoole;
	}

	public Vector<Cocktail> getCocktailAvecAlcoole() {
		return cocktailAvecAlcoole;
	}

	/**
	 * @param boisson
	 */
	public void add(Boisson boisson){
		if(boisson.getAlcoolise()){
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
	public Object serv(String command){
		Boisson retourB=null;
		Cocktail retourC=null;
		Enumeration e;
		
		e = this.boissonFroide.elements ();
		while (e.hasMoreElements () && !((retourB = (Boisson) e.nextElement()).getNom().equalsIgnoreCase(command))){}
		if(retourB.getNom().equalsIgnoreCase(command)){
			this.boissonFroide.remove(retourB);
			return retourB;
		}
		
		e = this.boissonAlcoolisee.elements ();
		while (e.hasMoreElements () && !((retourB = (Boisson) e.nextElement()).getNom().equalsIgnoreCase(command))){}
		if(retourB.getNom().equalsIgnoreCase(command)){
			this.boissonAlcoolisee.remove(retourB);
			return retourB;
		}
		
		e = this.boissonChaude.elements ();
		while (e.hasMoreElements () && !((retourB = (Boisson) e.nextElement()).getNom().equalsIgnoreCase(command))){}
		if(retourB.getNom().equalsIgnoreCase(command)){
			this.boissonChaude.remove(retourB);
			return retourB;
		}
		
		e = this.cocktailSansAlcoole.elements ();
		while (e.hasMoreElements () && !((retourC = (Cocktail) e.nextElement()).getNom().equalsIgnoreCase(command))){}
		if(retourC.getNom().equalsIgnoreCase(command)){
			this.cocktailSansAlcoole.remove(retourC);
			return retourC;
		}
		
		e = this.cocktailAvecAlcoole.elements ();
		while (e.hasMoreElements () && !((retourC = (Cocktail) e.nextElement()).getNom().equalsIgnoreCase(command))){}
		if(retourC.getNom().equalsIgnoreCase(command)){
			this.cocktailAvecAlcoole.remove(retourC);
			return retourC;
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
