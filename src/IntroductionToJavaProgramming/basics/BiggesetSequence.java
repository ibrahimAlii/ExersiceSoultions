package IntroductionToJavaProgramming.basics;

public class BiggesetSequence {

    public void biggestSequence(){
        int[] arr = {4,4,6,6,6,6,6,6,4,4,4,4,4,6,8,8,8,8,8,8,8,8,8};

        boolean newSeq = false;
        int diffrentSeq = 0;
        int currentNumber;
        //Get sequence numbers
        for (int i = 0; i < arr.length; i++) {
            currentNumber = arr[i];
            if (i >= 1 && currentNumber != arr[i - 1])
                newSeq = true;
            else if (i == 0)
                newSeq = true;

            //It's new sequence!!
            if (newSeq) {
                diffrentSeq++;
                newSeq = false;
            }
        }
        System.out.println(diffrentSeq);
        int[] maxSequencSize = new int[diffrentSeq];
        int lastIndex = 0;
        for (int i = 0; i < maxSequencSize.length; i++) {
            int currentNum = arr[lastIndex];
            for (int j = lastIndex; j < arr.length; j++) {
                if (arr[j] == currentNum) {
                    maxSequencSize[i]++;
                    lastIndex = j + 1;
                } else break;
            }
        }

        System.out.println(max(maxSequencSize));
    }
    private static int max(int[] array){

        int maxVal = 0;
        for (int anArray : array) {
            if (anArray > maxVal)
                maxVal = anArray;
        }

        return maxVal;
    }
}
