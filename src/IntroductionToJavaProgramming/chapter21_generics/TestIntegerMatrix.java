package chapter21;

public class TestIntegerMatrix {

    public static void main(String[] args) {

        Integer[][] m1 = new Integer[][]{{1, 2, 1}, {5, 8, 6}, {3, 4, 3}, {4, 1, 6}};
        Integer[][] m2 = new Integer[][]{{3, 4, 2}, {1, 8, 9}, {9, 2, 4}, {2, 2, 7}};

        IntegerMatrix integerMatrix = new IntegerMatrix();

        GenericMatrix.printResult(m1, m2, integerMatrix.addMatrix(m1, m2), '+');

        System.out.println();

        GenericMatrix.printResult(m1, m2, integerMatrix.multiplyMatrix(m1, m2), '*');
    }
}
