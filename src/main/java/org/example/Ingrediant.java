package org.example;

public class Ingrediant{
    private String nom;
    private Double quantite;

    public Ingrediant(String nom, Double quantite){
        this.nom = nom;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public Double getQuantite() {
        return quantite;
    }
}
