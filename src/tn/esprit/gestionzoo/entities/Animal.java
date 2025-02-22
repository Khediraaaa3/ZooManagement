package tn.esprit.gestionzoo.entities;
public class Animal {
    public String family;
    public String name;
    public int age;
    public boolean isMammal;

    public Animal() {
    }

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        setAge (age);
        this.isMammal = isMammal;

    }

    private void setAge(int age) {
        if (age >= 0)
            this.age = age;
        else
            System.out.println("Invalid Age");
    }
}
