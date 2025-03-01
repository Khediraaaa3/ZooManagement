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

    public Zoo() {
        animals = new Animal[MAX_ANIMALS];
        aquaticAnimals = new Aquatic[MAX_AQUATIC];
        nbrCages = 20;
        nbrAnimals = 0;
        nbrAquaticAnimals = 0;
    }

    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
        animals = new Animal[MAX_ANIMALS];
        aquaticAnimals = new Aquatic[MAX_AQUATIC];
        nbrAnimals = 0;
        nbrAquaticAnimals = 0;
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

    private void setName(String name) {
        if (name == null || name.length() == 0)
            System.out.println("Name cannot be empty");
        else
            this.name = name;

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
    public boolean addAnimal(Animal animal) {
        if ( isZooFull() )
            return false;
        else {
            animals[nbrAnimals] = animal;
            nbrAnimals++;
            return true;
        }
    }

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

    public boolean isZooFull() {
        return nbrAnimals >= nbrCages;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1 == null) return z2;
        if (z2 == null) return z1;
        if (z1.nbrAnimals >= z2.nbrAnimals) return z1;
        else return z2;
    }
}
