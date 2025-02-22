package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class ZooManagement {
    public static void main(String[] args) {

        Aquatic aquatic = new Aquatic();
        Terrestrial terrestrial = new Terrestrial();
        Dolphin dolphin = new Dolphin();
        Penguin penguin = new Penguin();


        Aquatic aquatic2 = new Aquatic("Poisson", "Nemo", 2, false, "Océan");
        Terrestrial terrestrial2 = new Terrestrial("Félin", "Lion", 5, true, 4);
        Dolphin dolphin2 = new Dolphin("Cétacé", "Flipper", 10, true, "Océan", 40.0f);
        Penguin penguin2 = new Penguin("Manchot", "Tux", 3, true, "Antarctique", 100.0f);


        System.out.println("\nAffichage des animaux :");
        System.out.println(aquatic2);
        System.out.println(terrestrial2);
        System.out.println(dolphin2);
        System.out.println(penguin2);


        System.out.println("\nTest de la méthode swim() :");
        aquatic2.swim();
        dolphin2.swim();
        penguin2.swim();
    }
}