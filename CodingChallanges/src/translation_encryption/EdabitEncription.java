package translation_encryption;

public class EdabitEncription {

    //Edabit Link
    //https://edabit.com/challenge/jfCsugyp9BSLYEtwb

    public EdabitEncription(){ }

    public String encrypt(String clearText){
        String editedString = new String();
        editedString = clearText.replaceAll("\\s","");
        int length = editedString.length();
        double sqrtOfLength = Math.sqrt(length);
        int columns = (int) sqrtOfLength;
        int rows = columns + 1;

        char[][] wordtable = new char[columns][rows];

        fillWordtable(wordtable, editedString);

        String word = new String();
        String encrypted = new String();
        for (int i = 0; i < wordtable[0].length; i++){
            for (int j = 0; j < wordtable.length; j++){
                word += wordtable[j][i];
            }
            encrypted += word + " ";
            word = "";
        }

        return encrypted;
    }

    private void fillWordtable(char[][] wordtable, String text) {
        int position = 0;
        for (int i = 0; i < wordtable.length; i++){
            for (int j = 0; j < wordtable[0].length; j++){
                if (position < text.length()) {
                    wordtable[i][j] = text.charAt(position);
                    position++;
                }
                else {
                    break;
                }
            }
        }
    }

    public String decrypt(String cryptedText){
        String decrypted = new String();
        decrypted = "LOL";
        return decrypted;
    }

    public static void main(String[] args) {
        EdabitEncription encryption = new EdabitEncription();
        String clearText = "Info ist ein wenig langweilig";
        String encrypted = encryption.encrypt(clearText);
        System.out.println(encrypted);
        String decrypted = encryption.decrypt(encrypted);
        if (decrypted.equals(clearText)){
            System.out.println("The Encryption was successful!");
        } else {
            System.out.println("You made a mistake.");
        }
    }

}
