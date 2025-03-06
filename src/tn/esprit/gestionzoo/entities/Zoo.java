package tn.esprit.gestionzoo.entities;

public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages;
    private int nbrAnimals;
    private Aquatic[] aquaticAnimals;
    private int nbrAquaticAnimals;

    public static final int MAX_ANIMALS = 25;
    public static final int MAX_AQUATIC = 10;

    // Constructeur par défaut
    public Zoo() {
        animals = new Animal[MAX_ANIMALS];
        aquaticAnimals = new Aquatic[MAX_AQUATIC];
        nbrCages = 3; // Réduit à 3 selon l'instruction 33
        nbrAnimals = 0;
        nbrAquaticAnimals = 0;
    }

    // Constructeur paramétré
    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
        animals = new Animal[MAX_ANIMALS];
        aquaticAnimals = new Aquatic[MAX_AQUATIC];
        nbrAnimals = 0;
        nbrAquaticAnimals = 0;
    }

    // Getters et Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty())
            this.name = name;
        else
            System.out.println("Le nom du zoo ne peut pas être vide");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public int getNbrAnimals() {
        return nbrAnimals;
    }

    // Méthode modifiée pour utiliser les exceptions (Instructions 32 et 33)
    public void addAnimal(Animal animal) throws ZooFullException {
        if (nbrAnimals >= nbrCages) {
            throw new ZooFullException();
        }

        // Vérifier si l'animal existe déjà dans le zoo
        if (searchAnimal(animal) != -1) {
            System.out.println("L'animal existe déjà dans le zoo.");
            return;
        }

        animals[nbrAnimals] = animal;
        nbrAnimals++;
    }

    public void addAquaticAnimal(Aquatic aquatic) {
        if (nbrAquaticAnimals < MAX_AQUATIC) {
            aquaticAnimals[nbrAquaticAnimals] = aquatic;
            nbrAquaticAnimals++;
            System.out.println("Animal aquatique ajouté avec succès.");
        } else {
            System.out.println("Le tableau d'animaux aquatiques est plein.");
        }
    }

    public void displaySwimming() {
        System.out.println("Les animaux aquatiques du zoo " + name + " nagent:");
        for (int i = 0; i < nbrAquaticAnimals; i++) {
            aquaticAnimals[i].swim();
        }
    }

    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0.0f;
        for (int i = 0; i < nbrAquaticAnimals; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin penguin = (Penguin) aquaticAnimals[i];
                if (penguin.getSwimmingDepth() > maxDepth) {
                    maxDepth = penguin.getSwimmingDepth();
                }
            }
        }
        return maxDepth;
    }

    public void displayNumberOfAquaticsByType() {
        int nbrDolphins = 0;
        int nbrPenguins = 0;

        for (int i = 0; i < nbrAquaticAnimals; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                nbrDolphins++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                nbrPenguins++;
            }
        }

        System.out.println("Nombre de dauphins: " + nbrDolphins);
        System.out.println("Nombre de pingouins: " + nbrPenguins);
    }


    public void displayZoo() {
        System.out.println("Zoo Name: " + this.name);
        System.out.println("City: " + this.city);
        System.out.println("Number of cages: " + this.nbrCages);
    }

    /*public boolean addAnimal(Animal animal) {
        if (this.nbrAnimals < this.animals.length) {
            this.animals[this.nbrAnimals] = animal;
            this.nbrAnimals++;
            return true;
        }
        return false;
    }*/

    public void displayAnimals() {
        System.out.println("Animaux dans le zoo " + name + ":");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i].equals(animal)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            return false;
        }

        for (int i = index; i < nbrAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals - 1] = null;
        nbrAnimals--;
        return true;
    }

    public class ZooFullException extends Exception {
        public ZooFullException() {
            super("Le zoo est plein, impossible d'ajouter un nouvel animal.");
        }

        public ZooFullException(String message) {
            super(message);
        }

        public static Zoo comparerZoo(Zoo z1, Zoo z2) {
            if (z1 == null) return z2;
            if (z2 == null) return z1;
            if (z1.nbrAnimals >= z2.nbrAnimals) return z1;
            else return z2;
        }

        public static class InvalidAgeException extends Exception {
            public InvalidAgeException() {
                super("L'âge de l'animal ne peut pas être négatif.");
            }
        }
    }
}
