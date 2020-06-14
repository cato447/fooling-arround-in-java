package strings;

public class SmoothSentences {

    //Edabit-Challange
    //https://edabit.com/challenge/FtoNXq7DTCAiZ3z9T

    public static boolean isSmooth(String sentence) {
        String[] words = sentence.toLowerCase().split("\\s+");
        for (int i = 0; i < words.length-1; i++){
            char lastChar = words[i].charAt(words[i].length()-1);
            char firstChar = words[i+1].charAt(0);
            if (lastChar != firstChar){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSmooth("Marigold daffodils streaming happily."));
    }
}
