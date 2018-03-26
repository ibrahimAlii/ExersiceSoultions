package chapter23;

import java.util.HashSet;
import java.util.Set;

public class SetOperationHashSet23_1 {

    public static void main(String[] gg) {

        Set<String> set1 = new HashSet<>();
        set1.add("Ibrahim");
        set1.add("Ali");
        set1.add("Mohamed");
        set1.add("Ahmed");
        set1.add("Abdelrahman");
        set1.add("Hossam");

        HashSet<String> set2 = new HashSet<>();
        set2.add("Ibrahim");
        set2.add("Saad");
        set2.add("Abdelrahman");
        set2.add("Michelle");
        set2.add("Mahmoud");

        System.out.println("Set 1 " + set1 + "\nSet 2 " + set2);

        // Find sets union
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union " + union);

        // Find Difference
        Set<String> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference " + difference);

        // Find inter-section
        Set<String> interSection = new HashSet<>(set1);
        interSection.retainAll(set2);
        System.out.println("Intersection " + interSection);


    }
}
