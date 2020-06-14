package strings;

//Link: https://edabit.com/challenge/FToTLuiB7bmFngkjr

public class FiscalCode {

    static String[] months = {"A", "B", "C", "D", "E", "H", "L", "M", "P", "R", "S", "T"};
    static String vowels = "AEIOU";

    public static String fiscalCode(String name, String surName, String gender, String dob) {
        String returnString = "";
        returnString += generateLetters(surName, 's');
        returnString += generateLetters(name, 'n');
        returnString += generateNumbers(dob, gender);
        return returnString;
    }

    private static String generateLetters(String string, char mode) {
        String returnString = "";
        string = string.toUpperCase();
        for (int i = 0; i < string.length(); i++) {
            if (vowels.indexOf(string.charAt(i)) == -1) {
                returnString += string.charAt(i);
            }
        }

        if (returnString.length() == 3) {
            return returnString;
        } else if (returnString.length() > 3) {
            if (mode != 'n' && mode != 's') {
                System.err.println("Not a valid value");
                System.exit(0);
            }
            return mode == 'n' ? "" + returnString.charAt(0) + returnString.charAt(2) + returnString.charAt(3) : returnString.substring(0, 3);
        } else {
            int index = 0;
            while (returnString.length() < 3 && string.length() > index) {
                if (vowels.indexOf(string.charAt(index)) > -1) {
                    returnString += string.charAt(index);
                }
                index++;
            }
            return returnString.length() == 3 ? returnString : returnString + "X";
        }
    }

    private static String generateNumbers(String dob, String gender) {
        String returnString = "";
        String date = dob.substring(dob.length() - 2);
        int month = Integer.parseInt(dob.substring(dob.indexOf("/") + 1, dob.lastIndexOf("/")))-1;
        if (gender.equals("M")) {
            return date + months[month] + (dob.substring(0, dob.indexOf("/")).length() == 2 ? dob.substring(0, dob.indexOf("/")) :
                    0 + dob.substring(0, dob.indexOf("/")));
        } else {
            int day = Integer.parseInt(dob.substring(0, dob.indexOf("/")))+40;
            return date + months[month] + day;
        }
    }

    public static void main(String[] args) {
        System.out.println(fiscalCode("Mickey", "Mouse", "M", "6/1/1928"));
    }

}
