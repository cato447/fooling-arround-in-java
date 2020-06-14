package strings;

public class WordChain {

    String link = "https://edabit.com/challenge/hbHJdMv4HubYs5TRv";

    public static boolean isWordChain(String[] words){
        String firstWord, secondWord;
        for (int i = 0; i < words.length-1; i++){
            int differences = 0;
            firstWord = words[i];
            secondWord = words[i+1];

            if (firstWord.length() == secondWord.length()){
                for (int j = 0; j < firstWord.length(); j++){
                    if (firstWord.charAt(j) != secondWord.charAt(j)){
                        differences++;
                    }
                }
            } else if(firstWord.length() > secondWord.length()){
                differences = firstWord.length()-secondWord.length();
                for (int j = 0; j < secondWord.length(); j++){
                    if (firstWord.charAt(j) != secondWord.charAt(j)){
                        differences++;
                    }
                }
            } else {
                differences = secondWord.length()-firstWord.length();
                for (int j = 0; j < firstWord.length(); j++){
                    if (firstWord.charAt(j) != secondWord.charAt(j)){
                        differences++;
                    }
                }
            }
            if (differences > 1){
                break;
            }
            differences = 0;
        }
        return false;
    }

}
