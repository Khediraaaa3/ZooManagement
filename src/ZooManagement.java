public class ZooManagement {
    public static void main(String[] args) {
        Animal lion = new Animal("lion", "Hugo", 8, true);
        Zoo myZoo = new Zoo("Frigya", "Tunis", 25);
        myZoo.displayZoo();
        System.out.println(myZoo);
        System.out.println(myZoo.toString());
    }
}