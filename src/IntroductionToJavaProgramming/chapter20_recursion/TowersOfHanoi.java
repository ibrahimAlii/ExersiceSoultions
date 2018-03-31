package IntroductionToJavaProgramming.chapter20_recursion;

public class TowersOfHanoi {

    public static void main(String[] m) {

        moveDisks(4, 'A', 'B', 'C');
    }

    public static void moveDisks(int n, char fromTower,
                                 char auxTower, char toTower) {

        if (n == 1)
            System.out.println("Move disk " + n + " from "
                    + fromTower + " to " + toTower);
        else {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println("Move disk " + n + " from " +
                    fromTower + " to " + toTower);
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }
}
