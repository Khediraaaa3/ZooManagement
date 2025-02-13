package tn.esprit.gestionzoo.entities;

public class Zoo {
    public Animal[] animals;
    public String name;
    public String city;
    public final int nbrCages=25;
    public int nbrAnimals;

    public Zoo(String name, String city, int nbrCages) {
        setName(name);
        this.city = city;
        this.animals = new Animal[nbrCages];
        this.nbrAnimals = 0;
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
