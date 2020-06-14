package numbers;

public class SimplifyFractions {

    //Edabit-Challange
    //https://edabit.com/challenge/bmwpoeCybNWnBxn7M

    public static String simplify(String str) {
        String[] numbers = str.split("/");
        int firstNum = Integer.parseInt(numbers[0]);
        int secondNum = Integer.parseInt(numbers[1]);
        int lowNum = Math.min(firstNum, secondNum);
        for (int i = lowNum; i > 0; i--){
            if (firstNum % i == 0 && secondNum % i == 0){
                firstNum = firstNum/i;
                secondNum = secondNum/i;
            }
        }
        if (firstNum % secondNum == 0){
            return firstNum/secondNum+"";
        } else{
            return firstNum+"/"+secondNum;
        }
    }

    public static void main(String[] args) {
        System.out.println(simplify("100/400"));
    }
}
