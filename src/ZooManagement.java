public class ZooManagement {
    public ZooManagement() {
    }

    public static void main(String[] args) {
        Animal lion = new Animal("lion", "Hugo", 8, true);
        Zoo myZoo = new Zoo("Frigya", "Tunis", 25);
        /*myZoo.displayZoo();
        System.out.println(myZoo);
        System.out.println(myZoo.toString());*/

        /*for (int i=0; i<30; i++){
           System.out.println(myZoo.addAnimal(lion));
        }*/

        System.out.println(myZoo.addAnimal(lion));
        Animal lion1 = new Animal("lion", "Hugo", 8, true);
        System.out.println(myZoo.searchAnimal(lion));
        System.out.println(myZoo.searchAnimal(lion1));

        Animal ganfoud = new Animal("ganfoud", "Sonic", 4, true);
        System.out.println(myZoo.addAnimal(ganfoud));


    }

}
