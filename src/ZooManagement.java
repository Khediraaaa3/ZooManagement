
/*         -------- Instruction 1 ---------
public class ZooManagement {
    public static void main(String[] args) {
        int nbrCages = 20;
        String zooName = "my zoo";
        System.out.println(zooName + " comporte " + nbrCages + " cages");
    }
}*/

import java.util.Scanner;
public class ZooManagement {
    public static void main(String[] args) {
        int nbrCages=0;
        String zooName;
        boolean test=false;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter zoo name: ");
        zooName = s.nextLine();
        do {
            System.out.println("Enter number of Cages: ");
            if (s.hasNextInt() && s.nextInt()>0) {
                nbrCages = s.nextInt();
                test=true;
            }
        } while (!test);
        System.out.println(zooName + " comporte " + nbrCages + " cages");
    }
}
