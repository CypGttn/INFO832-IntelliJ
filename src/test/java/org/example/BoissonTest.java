package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


class BoissonTest {
    Boisson boisson1;
    Boisson boisson2;
    Boisson boisson3;

    @BeforeEach
    void setUp() {
        boisson1 = new Boisson("Cacolac");
        boisson2 = new Boisson("ChateauNeufDuPape", 12F);
        boisson3 = new Boisson("Azote", -196F);

    }

    @Test
    @DisplayName("id: 1 Tests constructeur boisson juste avec nom")
    void testBoissonAvecNom() {
        assertEquals("Cacolac",boisson1.toString()) ;

    }

    @Test
    @DisplayName("id: 2 Tests constructeur boisson juste avec nom et degre")
    void testBoissonAvecNomEtDegre() {
        assertEquals("ChateauNeufDuPape (l'abus d'alcool est dangereux pour la sante)",boisson2.toString()) ;

    }

    @Test
    @DisplayName("id: 3 Test attribut degre")
    void testBoissonAvecNomEtDegre2() {
        assertEquals(12F, boisson2.getDegre()) ;

    }

    @Test
    @DisplayName("id: 4 Test valeur negative degre")
    void testValeurNegatif() {
        // Vérifie que la méthode `add` lève une exception pour une quantité négative
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Boisson("Azote", -196F);
        });
        // Vérifie le message d'erreur de l'exception
        assertEquals("Le degré d'alcool ne peut pas être négatif", exception.getMessage());
    }

}