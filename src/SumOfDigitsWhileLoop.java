import java.util.Scanner;

public class SumOfDigitsWhileLoop {
    public void getSum() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int sum = 0, value = 0;

        do {
            value = num % 10;
            num = num / 10;
            sum += value;
        } while (num > 0);

        System.out.println(sum);
    }
}
