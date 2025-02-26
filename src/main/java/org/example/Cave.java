package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pierre Le Fameux
 *
 */
public class Cave {
    private ArrayList<Boisson> rayonsBoisson;
    private ArrayList<Cocktail> rayonsCocktail;


    public Cave() {
        this.rayonsBoisson = new ArrayList<>();
        this.rayonsCocktail = new ArrayList<>();
    }

    public List<Boisson> getRayonsBoisson() {
        return rayonsBoisson;
    }

    public List<Cocktail> getRayonsCocktail() {
        return rayonsCocktail;
    }

    /**
     * Ajoute une boisson dans la cave
     * @param b Boisson à ajouter
     */
    public void add(Boisson b) {
        this.rayonsBoisson.add(b);
    }

    /**
     * Ajoute un cocktail dans la cave
     * @param c Cocktail à ajouter
     */
    public void add(Cocktail c) {
        this.rayonsCocktail.add(c);
    }
    /**
     * Récupère et retire une boisson de la cave par son nom
     * @param nom Nom de la boisson
     * @return La boisson retirée ou null si absente
     */
    public Boisson take(String nom) {
        for (Boisson b : rayonsBoisson) {
            if (b.getNom().equalsIgnoreCase(nom)) {
                rayonsBoisson.remove(b);
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
        for (Boisson b : rayonsBoisson) {
            retour.append("\t").append(b.toString()).append("\n");
        }
        return retour.toString();
    }
}