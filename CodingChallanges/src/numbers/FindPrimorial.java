package numbers;

public class FindPrimorial {

    //Edabit-Link
    //https://edabit.com/challenge/Tyzp6S67dtXPAAQan
    static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19};
    public static int primorial(int n) {
        if (n > 0) {
            int primorial = primes[n-1] * primorial(n - 1);
            return primorial;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(primorial(1));
    }

}
