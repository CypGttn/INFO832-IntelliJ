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
    @DisplayName("id: 1 test ajout boisson à cave")
    void testAjoutBoisson() {
        assertEquals("Cave : \nChateauNeufDuPape (l'abus d'alcool est dangereux pour la sante)",c.toString()) ;
    }

}