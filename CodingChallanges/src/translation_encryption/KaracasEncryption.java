package translation_encryption;

public class KaracasEncryption {

    //Edabit-Challange
    //https://edabit.com/challenge/SmL32HnRnmsCqGC5g

    public KaracasEncryption(){

    }

    public String replaceVowles(String reversedText){
        String tempText = new String();
        for (int i = 0; i < reversedText.length(); i++){
            char c = reversedText.charAt(i);
            switch (c){
                case 'a':
                    tempText += 0;
                    break;
                case 'e':
                    tempText+= 1;
                    break;
                case 'o':
                    tempText += 2;
                    break;
                case 'u':
                    tempText += 3;
                    break;
                default:
                    tempText += reversedText.charAt(i);
                    break;
            }
        }
        tempText += "aca";
        return tempText;
    }

    public String reverseString(String clearText){
        String tempText = new String();
        for (int i = clearText.length()-1; i >= 0; i--){
            tempText += clearText.charAt(i);
        }
        return tempText;
    }

    public String encrypt(String clearText){
       String reversed = reverseString(clearText);
       String fullencrypted = replaceVowles(reversed);
       return fullencrypted;
    }

    public static void main(String[] args) {
        KaracasEncryption karacas = new KaracasEncryption();
        karacas.encrypt("alpaca");
    }

}
