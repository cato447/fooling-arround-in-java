package strings;

import java.util.LinkedList;

public class DistanceToNearestVowel {

    //Edabit-Challange
    //https://edabit.com/challenge/Ls6pbLkC9wfYuaDgm

    public static int[] distanceToNearestVowel(String str) {
        LinkedList<Character> vowels= new LinkedList<Character>();
        char[] vowelsArr = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < vowelsArr.length; i++) {
            vowels.add(vowelsArr[i]);
        }
        LinkedList<Integer> values = new LinkedList<>();
        for (int i = 0; i < str.length();i++){
            if (vowels.contains(str.charAt(i))){
                values.addLast(1);
            } else{
                values.addLast(0);
            }
        }
        LinkedList<Integer> indexesVowels = new LinkedList<>();
        for (int i = 0 ; i < values.size(); i++){
            if (values.get(i) == 1){
                indexesVowels.addLast(i);
            }
        }
        int[] distances = new int[values.size()];
        for (int i = 0; i < distances.length; i++){
            distances[i] = 1000;
        }
        for (int i = 0; i < values.size(); i++){
            if (values.get(i) == 1){
                distances[i] = 0;
            }
        }
        for (int i = 0; i < indexesVowels.size(); i++){
            for (int j = 0; j < distances.length; j++){
                if (distances[j] != 0){
                    if (distances[j] > Math.abs(j - indexesVowels.get(i))){
                        distances[j] = Math.abs(j - indexesVowels.get(i));
                    }
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        distanceToNearestVowel("shopper");
    }
}
