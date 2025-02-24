package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CocktailTest {
    Cocktail mojito;

    @BeforeEach
    void setUp() {
        mojito = new Cocktail("Mojito");
    }

    @Test
    @DisplayName("id:2 Test Constructeur Cocktail")
    void testConstructeurCocktail() {
        assertEquals("Mojito", mojito.nom);
    }

    @Test
    @DisplayName("id:3 Test alcoolFree")
    void testAlcoolFree() {
        assertEquals(false, mojito.alcoolFree());
    }

    @Test
    @DisplayName("id:5 Test quantite negative")
    void testQuantiteNegative() {

        // Vérifie que la méthode `add` lève une exception pour une quantité négative
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mojito.add("Banane", -1D);
        });

        // Vérifie le message d'erreur de l'exception
        assertEquals("La quantité ne peut pas être négative ou nulle", exception.getMessage());
    }

    @Test
    @DisplayName("id:6 Test quantite nulle")
    void testQuantiteNulle() {

        // Vérifie que la méthode `add` lève une exception pour une quantité négative
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mojito.add("Banane", 0D);
        });

        // Vérifie le message d'erreur de l'exception
        assertEquals("La quantité ne peut pas être négative ou nulle", exception.getMessage());

    }


}