package A2oOnlineSolutions;

import java.util.Scanner;

/*Problem Statement:
        When we were kids, we used to play with some stickers where these stickers contain some (but not necessarily all) lower case English alphabet letters.

        Each sticker contains some letters arranged in a single row, where all occurrences of the same letter are adjacent to each other.
         A sticker can be represented as a string of characters, for example the following are valid stickers' representations: "aabcc",
         "ccccab" and "mmaw". And the following are not valid (because not all occurrences of the same letter are adjacent to each other):
          "abacc", "cccabc" and "mawm".

        Now we found some stickers with some missing letters, but we are sure that all missing letters belong to the visible letters set (that is,
         for every missing letter, there is at least one visible letter that matches the missing one). In this problem a question mark letter represents
          a missing letter. Given some stickers' representations with zero or more missing letters, your task is to count the number of possible original
          configurations for each sticker.

        For example, this sticker "aa??bb" with missing letters could have been one of the following original stickers
         "aaaabb", "aaabbb" or "aabbbb". But it could not have been any of the following original stickers "aababb"
         (it is invalid sticker) and "aaccbb" (because the letter 'c' did not appear in the given configuration).


        Input Format:
        Your program will be tested on one or more test cases. The first line of the input will be a single integer T ,
         the number of test cases (1 ≤ T ≤ 100). Followed by the test cases,
          each test case is described in one line which contains a non-empty string which consists of up to 10,000 letters,
           each letter is either a lower case English letter (from 'a' to 'z') or a question mark ('?').
            This string represents a sticker configuration which contains zero or more question marks,
             it will also contain at least one letter which is not a question mark and there will be at least one valid original configuration for it.


        Output Format:
        For each test case, print a single line which contains a single integer representing the number of possible original configurations for the sticker,
         since the result may be very large, print it modulo 1,000,000,007 (109 + 7).


        Sample Input:
        4
        aa??bb
        aaccbb
        ?a?
        a??a


        Sample Output:
        3
        1
        1
        1
        */
public class TheAlphabetSticker {
    public static void getPossibleCharacters() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine(); // Example
        char[] arr = str.toCharArray();
        int length = arr.length;

        // Init value for count, start and end
        int count = 0;
        char start = 'a';
        char end = 'a';
        for (int i = 0; i < length; i++) {
            if (arr[i] == '?') { // We found a question mark
                boolean foundEnd = false;
                int total = 1; // Currently the total of question mark is 1
                for (int j = i + 1; j < length; j++) { // Count the total question mark for our method and the end character
                    if (arr[j] != '?') { // Not question mark
                        end = arr[j]; // Update end;
                        i = j -1;
                        foundEnd = true;
                        break;
                    } else {
                        total++;
                    }
                }

                if (!foundEnd) { // Change end to start in the case our question mark continue to the end of string
                    end = start;
                }
                // Start to counting and reset end to 'z'
                int result = countPossibleCharacters(total, start, end);
                if (count > 0) {
                    count *= result;
                } else {
                    count += result;
                }
                end = 'z';
            } else {
                start = arr[i];
            }
        }

        System.out.println("The total is : " + count);
    }

    /**
     * Count the possible characters
     * @param total the total question mark
     * @param start the character in the left side of question mark
     * @param end the character in the right side of question mark
     * @return
     */
    private static int countPossibleCharacters(int total, char start, char end) {
        if (total == 0) {
            return 0;
        }

        if (total == 1) {
            return end - start + 1;
        }

        if (total >= 2) {
            int count = 0;

            /**
             * We have a range of characters from start to end
             * and for each character we have 2 options: use or don't use it
             */
            // We use it, so the total of question mark will be decrement by 1
            count += countPossibleCharacters(total - 1, start, end);

            // We don't use it, so the range of characters will be decrement by 1
            if (start < end) {
                count += countPossibleCharacters(total, ++start, end);
            }

            return count;
        }

        return 0;
    }
}

