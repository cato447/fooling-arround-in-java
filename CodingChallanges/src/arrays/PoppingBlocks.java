package arrays;

import java.util.Arrays;

public class PoppingBlocks {

    //Edabit-Challange
    //https://edabit.com/challenge/p38KD5Far2g72fv3d

    public static char[] finalResult(char[] letters) {
        int firstIndex = -1;
        int lastIndex = -1;
        char[] newLetters = new char[0];
        for (int i = 0; i < letters.length - 1; i++) {
            if (letters[i] == letters[i + 1]) {
                firstIndex = i;
                break;
            }
        }

        if (firstIndex != -1) {
            for (int j = firstIndex; j < letters.length; j++) {
                if (letters[j] != letters[firstIndex]) {
                    lastIndex = j - 1;
                    break;
                }
                if (j == letters.length - 1) {
                    lastIndex = j;
                    break;
                }
            }
            newLetters = new char[letters.length - (lastIndex - firstIndex) - 1];
            int j = 0;
            for (int i = 0; i < letters.length; i++) {
                if (i < firstIndex || i > lastIndex) {
                    newLetters[j] = letters[i];
                    j++;
                }
            }
        }
        if (firstIndex == -1) {
            return letters;
        }
        return finalResult(newLetters);
    }

    public static void main(String[] args) {
        System.out.println(finalResult(new char[]{'B', 'B', 'C', 'C', 'A', 'A', 'A'}));
    }

}
