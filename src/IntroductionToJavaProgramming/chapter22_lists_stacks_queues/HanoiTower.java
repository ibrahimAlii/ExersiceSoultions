
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class HanoiTower {

    public static void main(String[] gg) {


        moveDisks(4, 'A', 'B', 'C');
    }

    public static void moveDisks(int n, char fromTower,
                                 char toTower, char auxTower) {
        Stack<Record> stack = new Stack<>();
        stack.push(new Record(false, n, fromTower, toTower, auxTower));
        while (!stack.isEmpty()) {
            Record record = stack.pop();
            n = record.n;
            fromTower = record.fromTower;
            toTower = record.toTower;
            auxTower = record.auxTower;
            if (record.isLast)
                System.out.println("Move disk " + n + " from " +
                        record.fromTower + " to " + record.toTower);
            else {
                if (n == 1)
                    System.out.println("Move disk " + n + " from " +
                            record.fromTower + " to " + record.toTower);
                else {
                    stack.push(new Record(false, n - 1, auxTower, toTower, fromTower));
                    stack.push(new Record(true, n, fromTower, toTower, auxTower));
                    stack.push(new Record(false, n - 1, fromTower, auxTower, toTower));
                }
            }
        }
    }

    public static class Record {
        boolean isLast = false; // isLast indicates that this is the last disk in the fromTower.
        int n;
        char fromTower;
        char toTower;
        char auxTower;

        Record(boolean isLast, int n, char fromTower, char toTower, char auxTower) {
            this.isLast = isLast;
            this.n = n;
            this.fromTower = fromTower;
            this.toTower = toTower;
            this.auxTower = auxTower;
        }
    }
}
