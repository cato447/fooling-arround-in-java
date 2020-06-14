package strings;

import java.util.LinkedList;

public class LongestAlternatingSubstring {

    //Edabit-Challange
    //https://edabit.com/challenge/De5e8kdsCFmKvc6w8

    public static String longestSubstring(String digits) {
        char[] digitsArr = digits.toCharArray();
        LinkedList<Integer> indexes = new LinkedList<>();
        indexes.addLast(0);
        for (int i = 0; i < digitsArr.length - 1; i++) {
            if ((digitsArr[i] % 2 == 0 && digitsArr[i + 1] % 2 == 0) || (digitsArr[i] % 2 != 0 && digitsArr[i + 1] % 2 != 0)) {
                indexes.addLast(i+1 );
            }
        }
        indexes.addLast(digits.length());
        LinkedList<String> substrings = new LinkedList<String>();
        LinkedList<Integer> indexDump = (LinkedList<Integer>) indexes.clone();
        for (int i = 0; i < indexes.size()-1; i++) {
            if (indexDump.get(i+1)-indexDump.get(i)>1) {
                String sub = digits.substring(indexDump.get(i), indexDump.get(i + 1));
                substrings.addLast(sub);
            }
        }
        String longest = new String();
        for (int i = 0;i < substrings.size();i++){
            if (substrings.get(i).length() > longest.length()){
                longest = substrings.get(i);
            }
        }
        return "lll";
    }

    public static void main(String[] args) {
        longestSubstring("594127169973391692147228678476");
    }
}
