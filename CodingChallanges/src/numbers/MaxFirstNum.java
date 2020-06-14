package numbers;

public class MaxFirstNum {

    public static int maxPossible(int n1, int n2) {
        String firstNum = n1 + "";
        String secondNum = n2 + "";
        String maxNum = null;
        for (int i = 0; i < firstNum.length(); i++){

            int num1 = Integer.parseInt(Character.toString(firstNum.charAt(i)));
            boolean found = false;

            for (int j = 0; j < secondNum.length(); j++){
                if (num1 < Integer.parseInt(Character.toString(secondNum.charAt(i)))){
                    firstNum.replace(Character.toString(firstNum.charAt(i)), Character.toString(secondNum.charAt(j)));
                    secondNum.replace(Character.toString(secondNum.charAt(j)),"");
                }
            }
        }
        return Integer.parseInt(firstNum);
    }

    public static void main(String[] args) {
        System.out.println(maxPossible(9132, 5564));
    }
}
