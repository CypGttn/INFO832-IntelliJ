package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class BarTest {

    @Test
    @DisplayName("Ajout d'une boisson alcoolisée dans le bon rayon")
    void testAjoutBoissonAlcoolisee() {
        Bar bar = new Bar();
        Boisson vin = new Boisson("Vin Rouge", 12.5F);

        bar.add(vin);

        assertEquals(1, bar.getBoissonAlcoolisee().size(), "La boisson alcoolisée doit être dans boissonAlcoolisee");
        assertTrue(bar.getBoissonAlcoolisee().contains(vin), "La boisson doit être présente dans boissonAlcoolisee");
    }

    @Test
    @DisplayName("Ajout d'une boisson froide non alcoolisée")
    void testAjoutBoissonFroide() {
        Bar bar = new Bar();
        Boisson jus = new Boisson("Jus d'Orange", 0.0F);

        bar.add(jus);

        assertEquals(1, bar.getBoissonFroide().size(), "La boisson froide doit être dans boissonFroide");
        assertTrue(bar.getBoissonFroide().contains(jus), "La boisson doit être présente dans boissonFroide");
    }

    @Test
    @DisplayName("Ajout d'un cocktail sans alcool")
    void testAjoutCocktailSansAlcool() {
        Bar bar = new Bar();
        Cocktail virginMojito = new Cocktail("Virgin Mojito"); // Par défaut, sans alcool
        bar.add(virginMojito);

        assertEquals(1, bar.getCocktailSansAlcoole().size(), "Le cocktail sans alcool doit être dans cocktailSansAlcoole");
        assertTrue(bar.getCocktailSansAlcoole().contains(virginMojito), "Le cocktail doit être présent dans cocktailSansAlcoole");
    }

    @Test
    @DisplayName("Ajout d'un cocktail avec alcool")
    void testAjoutCocktailAvecAlcool() {
        Bar bar = new Bar();
        Cocktail pinaColada = new Cocktail("Pina Colada");
        pinaColada.setAlcoolise(true); // On précise qu'il contient de l'alcool
        bar.add(pinaColada);

        assertEquals(1, bar.getCocktailAvecAlcoole().size(), "Le cocktail alcoolisé doit être dans cocktailAvecAlcoole");
        assertTrue(bar.getCocktailAvecAlcoole().contains(pinaColada), "Le cocktail doit être présent dans cocktailAvecAlcoole");
    }

    @Test
    @DisplayName("Servir une boisson alcoolisée existante")
    void testServirBoissonAlcoolisee() {
        Bar bar = new Bar();
        Boisson whisky = new Boisson("Whisky", 40.0F);
        bar.add(whisky);

        Object servi = bar.serv("Whisky");

        assertNotNull(servi, "La boisson doit être servie");
        assertTrue(servi instanceof Boisson, "L'objet retourné doit être une boisson");
        assertEquals("Whisky", ((Boisson) servi).getNom(), "La boisson servie doit être celle demandée");
        assertEquals(0, bar.getBoissonAlcoolisee().size(), "La boisson doit être retirée du bar");
    }

    @Test
    @DisplayName("Servir une boisson froide existante")
    void testServirBoissonFroide() {
        Bar bar = new Bar();
        Boisson coca = new Boisson("Coca Cola", 0.0F);
        bar.add(coca);

        Object servi = bar.serv("Coca Cola");

        assertNotNull(servi, "La boisson doit être servie");
        assertTrue(servi instanceof Boisson, "L'objet retourné doit être une boisson");
        assertEquals("Coca Cola", ((Boisson) servi).getNom(), "La boisson servie doit être celle demandée");
        assertEquals(0, bar.getBoissonFroide().size(), "La boisson doit être retirée du bar");
    }

    @Test
    @DisplayName("Servir un cocktail sans alcool existant")
    void testServirCocktailSansAlcool() {
        Bar bar = new Bar();
        Cocktail sunrise = new Cocktail("Tequila Sunrise");
        bar.add(sunrise);

        Object servi = bar.serv("Tequila Sunrise");

        assertNotNull(servi, "Le cocktail doit être servi");
        assertTrue(servi instanceof Cocktail, "L'objet retourné doit être un cocktail");
        assertEquals("Tequila Sunrise", ((Cocktail) servi).getNom(), "Le cocktail servi doit être celui demandé");
        assertEquals(0, bar.getCocktailSansAlcoole().size(), "Le cocktail doit être retiré du bar");
    }

    @Test
    @DisplayName("Servir un cocktail avec alcool existant")
    void testServirCocktailAvecAlcool() {
        Bar bar = new Bar();
        Cocktail blueLagoon = new Cocktail("Blue Lagoon");
        blueLagoon.setAlcoolise(true); // Spécifier qu'il est alcoolisé
        bar.add(blueLagoon);

        Object servi = bar.serv("Blue Lagoon");

        assertNotNull(servi, "Le cocktail doit être servi");
        assertTrue(servi instanceof Cocktail, "L'objet retourné doit être un cocktail");
        assertEquals("Blue Lagoon", ((Cocktail) servi).getNom(), "Le cocktail servi doit être celui demandé");
        assertEquals(0, bar.getCocktailAvecAlcoole().size(), "Le cocktail doit être retiré du bar");
    }

    @Test
    @DisplayName("Servir une boisson non existante")
    void testServirBoissonInexistante() {
        Bar bar = new Bar();

        Object servi = bar.serv("Bière");

        assertNull(servi, "Aucune boisson ne doit être servie");
    }

    @Test
    @DisplayName("Test de l'affichage du bar")
    void testToString() {
        Bar bar = new Bar();
        Boisson cafe = new Boisson("Café", 0.0F);
        Boisson whisky = new Boisson("Whisky", 40.0F);
        Cocktail mojito = new Cocktail("Mojito");
        mojito.setAlcoolise(true); // Mojito alcoolisé

        bar.add(cafe);
        bar.add(whisky);
        bar.add(mojito);

        String result = bar.toString();

        assertTrue(result.contains("Bar :"), "Le texte doit contenir 'Bar :'");
        assertTrue(result.contains("Café"), "Le texte doit contenir 'Café'");
        assertTrue(result.contains("Whisky"), "Le texte doit contenir 'Whisky'");
        assertTrue(result.contains("Mojito"), "Le texte doit contenir 'Mojito'");
    }
}
