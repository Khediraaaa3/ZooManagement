package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class ZooManagement {
    public static void main(String[] args) {

        Zoo myZoo = new Zoo("Wildlife Park", "Ariana", 25);

        Dolphin dolphin1 = new Dolphin("Cétacé", "Naruto", 7, true, "Océan", 25.5f);
        Dolphin dolphin2 = new Dolphin("Cétacé", "Sasuke", 10, true, "Mer", 30.0f);
        Penguin penguin1 = new Penguin("Oiseau", "Taki", 4, false, "Antarctique", 100.0f);
        Penguin penguin2 = new Penguin("Oiseau", "Mitsuha", 3, false, "Arctique", 150.0f);

        System.out.println("\n=== Ajout d'animaux aquatiques ===");
        myZoo.addAquaticAnimal(dolphin1);
        myZoo.addAquaticAnimal(dolphin2);
        myZoo.addAquaticAnimal(penguin1);
        myZoo.addAquaticAnimal(penguin2);

        System.out.println("\n=== Test de la méthode swim() pour tous les animaux aquatiques ===");
        myZoo.displaySwimming();

        System.out.println("\n=== Profondeur maximale de nage des pingouins ===");
        System.out.println("Profondeur maximale: " + myZoo.maxPenguinSwimmingDepth() + " mètres");

        System.out.println("\n=== Nombre d'animaux aquatiques par type ===");
        myZoo.displayNumberOfAquaticsByType();

        System.out.println("\n=== Test de la méthode equals ===");
        Dolphin dolphin3 = new Dolphin("Cétacé", "Jack", 7, true, "Océan", 40.0f);
        Dolphin dolphin4 = new Dolphin("Cétacé", "Babayaga", 7, true, "Rivière", 20.0f);
        System.out.println("dolphin1 equals dolphin3 (même nom, âge et habitat): " + dolphin1.equals(dolphin3));
        System.out.println("dolphin1 equals dolphin4 (même nom et âge, habitat différent): " + dolphin1.equals(dolphin4));
    }
}