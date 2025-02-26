package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PubTest {

    private Pub pub;

    @BeforeEach
    void setUp() {
        pub = new Pub(); // Initialisation d'un nouveau Pub avant chaque test
    }

    @Test
    void testInitialisationPub() {
        assertNotNull(pub.getBar(), "Le bar ne doit pas être null après initialisation");
        assertNotNull(pub.getCave(), "La cave ne doit pas être null après initialisation");
    }

    @Test
    void testApprovisionnementBarAvecBoissonExistante() {
        Boisson biere = new Boisson("Bière", 7F); // Boisson alcoolisée
        pub.getCave().add(biere); // Ajout dans la cave

        pub.approvisionnerBar("Bière"); // Approvisionnement du bar

        assertFalse(pub.getCave().getRayonsBoisson().contains(biere), "La bière doit être retirée de la cave");
        assertTrue(pub.getBar().getBoissonAlcoolisee().contains(biere), "La bière doit être ajoutée au bar");
    }

    @Test
    void testApprovisionnementBarAvecBoissonInexistante() {
        pub.approvisionnerBar("Vin"); // Tentative de prendre une boisson qui n'existe pas

        assertTrue(pub.getBar().getBoissonAlcoolisee().isEmpty(), "Le bar ne doit pas contenir la boisson");
        assertTrue(pub.getCave().getRayonsBoisson().isEmpty(), "La cave ne doit pas contenir la boisson");
    }

    @Test
    void testApprovisionnementBarAvecCocktail() {
        Cocktail mojito = new Cocktail("Mojito"); // Cocktail avec alcool
        pub.getCave().add(mojito); // Ajout du cocktail dans la cave

        pub.approvisionnerBar("Mojito"); // Approvisionnement du bar

        assertFalse(pub.getCave().getRayonsCocktail().contains(mojito), "Le Mojito doit être retiré de la cave");
        assertTrue(pub.getBar().getCocktailAvecAlcoole().contains(mojito), "Le Mojito doit être ajouté au bar");
    }
}
