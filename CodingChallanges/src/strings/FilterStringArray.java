package strings;

import java.util.Arrays;
import java.util.Stack;

public class FilterStringArray {

    //Edabit-Link
    //https://edabit.com/challenge/vNszi3mbJA5BhgGFX

    public static String[] filterArray(String[] str) {
        Stack<String> stack = new Stack<>();
        int stackSize = 0;
        for (int i = 0; i < str.length; i++) {
            try {
                int possibleNum = Integer.parseInt(str[i]);
                if (stack.search(possibleNum) < 0) {
                    stack.push(str[i]);
                    stackSize++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String[] strArray = new String[stackSize];
        return stack.toArray(strArray);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(filterArray(new String[]{"1", "2", "aasf", "1", "123", "123"})));
    }

}
