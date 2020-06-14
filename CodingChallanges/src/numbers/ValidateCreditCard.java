package numbers;

// Link: https://edabit.com/challenge/RvxGLMzoPoBgXhcaC

public class ValidateCreditCard {

    public static boolean validateCard(long num) {

        if ((num+"").length()<14 || (num+"".length()<20)){
            return false;
        }

        int checkDigit = Integer.parseInt((num+"").substring((num+"").length()-1));

        int[] numInArray = new int [(num+"").length()-1];

        for (int i = 1; i < numInArray.length+1; i++){
            numInArray[i-1] = Integer.parseInt((num+"").substring((num+"").length()-i-1, (num+"").length()-i));
            if (i % 2 == 1){
                numInArray[i-1] *= 2;
                if (numInArray[i-1]>9){
                    numInArray[i-1] = (numInArray[i-1]/10) + (numInArray[i-1]-10);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < numInArray.length; i++){
            sum += numInArray[i];
        }
        return 10 - (sum-((sum/10)*10)) == checkDigit;
    }

    public static void main(String[] args) {
        System.out.println(validateCard(1234567890123456L));
    }

}
