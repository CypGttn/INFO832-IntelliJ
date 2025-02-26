package org.example;
import java.util.Vector; 
import java.util.Enumeration;

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
		this.boissonChaude = new Vector<Boisson>();
		this.boissonFroide = new Vector<Boisson>();
		this.boissonAlcoolisee = new Vector<Boisson>();
		
		this.cocktailAvecAlcoole = new Vector<Cocktail>();
		this.cocktailSansAlcoole = new Vector<Cocktail>();	
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
		if(cocktail.alcoolFree()){
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
	public String toString(){
		String retour = "";
		String eol = System.getProperty("line.separator"); 
		Enumeration e;
		
		retour = retour + "Bar : " + eol;
		
		retour = retour + "\t Sans alcool" + eol;
		e = this.boissonFroide.elements ();
		while (e.hasMoreElements ()) {
			retour = retour + "\t\t" + e.nextElement().toString() + eol;
		}
		
		retour = retour + "\t Avec alcool" + eol;
		e = this.boissonAlcoolisee.elements();
		while (e.hasMoreElements ()) {
			retour = retour + "\t\t" + e.nextElement().toString() + eol;
		}
		
		retour = retour + "\t Cocktail sans alcool" + eol;
		e = this.cocktailSansAlcoole.elements();
		while (e.hasMoreElements ()) {
			retour = retour + "\t\t" + e.nextElement().toString() + eol;
		}
		
		retour = retour + "\t Cocktail avec alcool" + eol;
		e = this.cocktailAvecAlcoole.elements();
		while (e.hasMoreElements ()) {
			retour = retour + "\t\t" + e.nextElement().toString() + eol;
		}
		
		retour = retour + "\t Boissons chaudes" + eol;
		e = this.boissonChaude.elements();
		while (e.hasMoreElements ()) {
			retour = retour + "\t\t" + e.nextElement().toString() + eol;
		}
		
		return retour;
	}

}
