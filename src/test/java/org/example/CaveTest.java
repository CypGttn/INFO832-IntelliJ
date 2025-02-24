package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaveTest {
    Boisson boisson2;
    Cave c;

    @BeforeEach
    void setUp() {
        boisson2 = new Boisson("ChateauNeufDuPape",12F);
        c = new Cave();
        c.add(boisson2);

    }

    @Test
    @DisplayName("id:1 test ajout boisson à cave")
    void testAjoutBoisson() {
        assertEquals("Cave : \nChateauNeufDuPape (l'abus d'alcool est dangereux pour la sante)",c.toString()) ;
    }

    @Test
    @DisplayName("Test retirer une boisson existante")
    void testTakeBoissonExistante() {
        Cave cave = new Cave();
        Boisson boisson1 = new Boisson("ChateauNeufDuPape", 12.5F);
        boisson2 = new Boisson("Bordeaux", 13.0F);
        cave.add(boisson1);
        cave.add(boisson2);

        Boisson taken = cave.take("ChateauNeufDuPape");

        assertNotNull(taken, "La boisson doit être retournée");
        assertEquals("ChateauNeufDuPape", taken.getNom(), "La boisson retirée doit correspondre au nom");
        assertEquals(1, cave.rayons.size(), "Il doit rester une boisson dans la cave");
        assertFalse(cave.rayons.contains(boisson1), "La boisson retirée ne doit plus être dans la cave");
    }

    @Test
    @DisplayName("Test tenter de retirer une boisson inexistante")
    void testTakeBoissonInexistante() {
        Cave cave = new Cave();
        Boisson boisson1 = new Boisson("ChateauNeufDuPape", 12.5F);
        cave.add(boisson1);

        Boisson taken = cave.take("Bordeaux");

        assertNull(taken, "Aucune boisson ne doit être retournée si elle n'existe pas");
        assertEquals(1, cave.rayons.size(), "La cave doit toujours contenir une boisson");
    }

    @Test
    @DisplayName("Test tenter de retirer une boisson d'une cave vide")
    void testTakeBoissonCaveVide() {
        Cave cave = new Cave(); // Cave vide

        Boisson taken = cave.take("ChateauNeufDuPape");

        assertNull(taken, "Aucune boisson ne doit être retournée car la cave est vide");
    }

    @Test
    @DisplayName("Test retirer une boisson avec nom ayant des espaces et insensibilité à la casse")
    void testTakeBoissonAvecEspacesEtInsensibiliteCasse() {
        Cave cave = new Cave();
        Boisson boisson1 = new Boisson("Chateau Neuf Du Pape", 12.5F);
        cave.add(boisson1);

        // Test avec des variations de casse et espaces
        Boisson taken = cave.take("chateau neuf du pape");

        assertNotNull(taken, "La boisson doit être retirée malgré les différences de casse et d'espaces");
        assertEquals("Chateau Neuf Du Pape", taken.getNom(), "La boisson retirée doit correspondre au nom");
    }

    @Test
    @DisplayName("Test vérifier l'intégrité des autres boissons après retrait")
    void testTakeIntegrityOtherBoissons() {
        Cave cave = new Cave();
        Boisson boisson1 = new Boisson("ChateauNeufDuPape", 12.5F);
        boisson2 = new Boisson("Bordeaux", 13.0F);
        cave.add(boisson1);
        cave.add(boisson2);

        Boisson taken = cave.take("ChateauNeufDuPape");

        assertNotNull(taken, "La boisson doit être retirée");
        assertEquals(1, cave.rayons.size(), "Il doit rester une boisson dans la cave");
        assertTrue(cave.rayons.contains(boisson2), "L'autre boisson doit toujours être dans la cave");
    }



}