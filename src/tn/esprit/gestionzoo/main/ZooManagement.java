package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

import tn.esprit.gestionzoo.entities.*;

public class ZooManagement {
    public static void main(String[] args) {
        // Création d'un zoo avec seulement 3 cages
        Zoo myZoo = new Zoo("Wildlife Park", "Ariana", 3);

        // Création d'animaux
        Animal lion = new Animal("Félin", "Lion", 5, true);
        Animal tiger = new Animal("Félin", "Tigre", 7, true);
        Animal elephant = new Animal("Éléphantidés", "Éléphant", 10, true);
        Animal giraffe = new Animal("Giraffidés", "Girafe", 8, true);

        // Test d'ajout d'animaux avec gestion de l'exception ZooFullException
        System.out.println("\n=== Test d'ajout d'animaux avec exceptions ===");

        try {
            myZoo.addAnimal(lion);
            System.out.println("Nombre d'animaux après ajout: " + myZoo.getNbrAnimals());

            myZoo.addAnimal(tiger);
            System.out.println("Nombre d'animaux après ajout: " + myZoo.getNbrAnimals());

            myZoo.addAnimal(elephant);
            System.out.println("Nombre d'animaux après ajout: " + myZoo.getNbrAnimals());

            // Cette ligne devrait lancer une exception car le zoo est plein (3 cages)
            myZoo.addAnimal(giraffe);
            System.out.println("Nombre d'animaux après ajout: " + myZoo.getNbrAnimals());
        } catch (Zoo.ZooFullException e) {
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Nombre d'animaux actuel: " + myZoo.getNbrAnimals());
        }

        // Test d'ajout d'un animal avec âge négatif
        System.out.println("\n=== Test d'ajout d'un animal avec âge négatif ===");
        try {
            Animal invalidAnimal = new Animal("Canidé", "Loup", -3, true);
            myZoo.addAnimal(invalidAnimal);
        } catch (Zoo.ZooFullException e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }
}