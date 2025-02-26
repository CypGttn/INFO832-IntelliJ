package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Démarrage du Pub...");

        /* Création du pub */
        Pub pub = new Pub();

        Boisson coca = new Boisson("Coca");
        Boisson eau = new Boisson("Eau");
        Boisson sky = new Boisson("Whisky", 40F);
        Boisson bierre = new Boisson("Bière", 8F);

        pub.getCave().add(coca);
        pub.getCave().add(coca);
        pub.getCave().add(coca);
        pub.getCave().add(sky);
        pub.getCave().add(sky);
        pub.getCave().add(bierre);
        pub.getCave().add(bierre);
        pub.getCave().add(eau);

        LOGGER.info("Cave initiale :\n" + pub.getCave());

        pub.approvisionnerBar("Bière");
        pub.approvisionnerBar("Whisky");
        pub.approvisionnerBar("Coca");
        pub.approvisionnerBar("Eau");

        Cocktail maz = new Cocktail("Mazout");
        maz.add("Bière", 50.0);
        maz.add("Coca", 50.0);
        pub.getBar().add(maz);

        Boisson cafe = new Boisson("Café");
        pub.getBar().getBoissonChaude().add(cafe);

        LOGGER.info("État de la cave après approvisionnement :\n" + pub.getCave());
        LOGGER.info("État du bar après approvisionnement :\n" + pub.getBar());

        Object servie = pub.getBar().serv("Café");
        if (servie != null) {
            LOGGER.info("Boisson servie : " + servie);
        } else {
            LOGGER.warning("La boisson demandée n'est pas disponible !");
        }

        LOGGER.info("État final du bar :\n" + pub.getBar());
    }
}
