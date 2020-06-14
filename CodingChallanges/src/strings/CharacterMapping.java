package strings;

import java.util.Arrays;

public class CharacterMapping {

    //Edabit-Challange
    //https://edabit.com/challenge/zcobRojF5p8DWkfiC

    public static int[] characterMapping(String str) {
        int[] mappedArr = new int[str.length()];
        String chars = new String();
        for (int i = 0; i < str.length(); i++){
            if (chars.indexOf(str.charAt(i)) == -1){
                chars += str.charAt(i);
            }
            mappedArr[i] = chars.indexOf(str.charAt(i));
        }
        return mappedArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(characterMapping("hmmmmm")));
    }

}
