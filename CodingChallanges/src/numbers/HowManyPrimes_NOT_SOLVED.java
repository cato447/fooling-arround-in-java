package numbers;

public class HowManyPrimes_NOT_SOLVED {

    //Edabit link
    //https://edabit.com/challenge/z8vvSdWjAPu5ufBuR

    public static int findPrimes(int boundary){
        int primes = 0;
        for (int i = 0; i < boundary; i++){
            if (i % 2 != 0 && i!= 0){
                for (int j = 1; j < 10; j = j+2){
                    if (i/j == 1){

                    }
                }
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        int boundary = 100;
        System.out.printf("There are %d primes within the range of 0-%d",findPrimes(boundary),boundary);
    }

}
