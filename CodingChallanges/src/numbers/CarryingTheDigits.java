package numbers;

public class CarryingTheDigits {

    //Edabit-Challange:
    //https://edabit.com/challenge/5snfPLPbvjAsZ5kjo

    public static int carryDigits(int n1, int n2){
        String firstNum = String.valueOf(n1);
        String secondNum = String.valueOf(n2);
        String first = new String();
        String second = new String();
        if (firstNum.length() > secondNum.length()){
            String filler = new String();
            for (int i = 0; i < firstNum.length()-secondNum.length();i++){
                filler += "0";
            }
            first = firstNum;
            second = filler + secondNum;
        } else {
            String filler = new String();
            for (int i = 0; i < secondNum.length()-firstNum.length();i++){
                filler += "0";
            }
            first = filler + firstNum;
            second = secondNum;
        }
        System.out.println(first+ ", "+ second);
        int tempCarry = 0;
        int carry = 0;
        for (int i = first.length()-1; i >= 0; i--){
            int num = Integer.parseInt(Character.toString(first.charAt(i))) + Integer.parseInt(Character.toString(second.charAt(i))) + tempCarry;
            if (num > 9){
                tempCarry = num - 9;
                if (tempCarry <= 0) {
                    tempCarry = 0;
                }
                carry++;
            }
        }
        return carry;
    }

    public static void main(String[] args) {
        System.out.println( carryDigits(671, 329));
    }

}
