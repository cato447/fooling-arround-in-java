package translation_encryption;

import java.util.Arrays;

public class PigLatinTranslation {

    //Edabit-Challange
    //https://edabit.com/challenge/2aajqTB69y7ZSSo9v

    public static String pigLatin(String str) {
        String[] words = str.split("\\s|(?=[!\\.?])");
        String returnString = "";
        for (int i = 0; i < words.length-1; i++) {
            String s = "";

            if ("AEIOUaeiou".indexOf(words[i].charAt(0)) == -1) {
                if (i == 0) {
                    if (words[i].length() > 1) {
                        s = words[i].toUpperCase().charAt(1) + words[i].substring(2) + words[i].toLowerCase().charAt(0);
                    } else {
                        s = words[i].toUpperCase();
                    }
                } else {
                    if (words[i].length() > 2) {
                        s = words[i].substring(1) + words[i].toLowerCase().charAt(0);
                    } else if (words[i].length() == 2) {
                        s = words[i].toLowerCase().charAt(1) + String.valueOf(words[i].toLowerCase().charAt(0));
                    } else {
                        s = words[i].toLowerCase();
                    }
                }
                s += "ay";
            } else {
                s += words[i] + "way";
            }

            if (i < words.length-2) {
                returnString += s + " ";
            } else{
                returnString += s + words[i+1];
            }
        }
        return returnString;
    }

    public static void main(String[] args) {
        System.out.println(pigLatin("Tom got a small piece of pie."));
    }

}
