package org.example;

public class Ingrediant{
    private String ingrediant;
    private Double quantite;

    public Ingrediant(String ingrediant, Double quantite){
        this.ingrediant = ingrediant;
        this.quantite = quantite;
    }

    public String getIngrediant() {
        return ingrediant;
    }

    public Double getQuantite() {
        return quantite;
    }
}
