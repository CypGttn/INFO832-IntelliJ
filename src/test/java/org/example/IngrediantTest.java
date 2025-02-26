package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IngrediantTest {

    @Test
    void testCreationIngrediant() {
        // Création d'un ingrédient
        Ingrediant ingrediant = new Ingrediant("Farine", 500.0);

        // Vérification des valeurs
        assertEquals("Farine", ingrediant.getNom(), "Le nom de l'ingrédient doit être 'Farine'");
        assertEquals(500.0, ingrediant.getQuantite(), "La quantité doit être 500.0");
    }

    @Test
    void testQuantiteNegative() {
        // Création d'un ingrédient avec quantité négative
        Ingrediant ingrediant = new Ingrediant("Sucre", -200.0);

        // Vérification de la valeur (on s'attend à ce que la quantité soit bien enregistrée même si elle est négative)
        assertEquals(-200.0, ingrediant.getQuantite(), "La quantité négative doit être prise en compte");
    }
}
