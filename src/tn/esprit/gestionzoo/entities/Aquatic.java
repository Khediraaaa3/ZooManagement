package tn.esprit.gestionzoo.entities;

public abstract class Aquatic extends Animal {
    private String habitat;

    // Constructeur par défaut
    public Aquatic() {
    }

    // Constructeur paramétré
    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    // Getter et Setter
    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // Méthode swim() rendue abstraite (Instruction 28)
    public abstract void swim();

    // Redéfinition de la méthode equals (Instruction 31)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass().getSuperclass() != obj.getClass().getSuperclass()) return false;

        Aquatic aquatic = (Aquatic) obj;
        return this.getName().equals(aquatic.getName()) &&
                this.getAge() == aquatic.getAge() &&
                this.habitat.equals(aquatic.habitat);
    }

    protected abstract Object getName();
    protected abstract Object getAge();

    @Override
    public String toString() {
        return super.toString() + ", Aquatic{" +
                "habitat='" + habitat + '\'' +
                '}';
    }
}