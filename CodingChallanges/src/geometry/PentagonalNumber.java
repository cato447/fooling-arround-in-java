package geometry;

public class PentagonalNumber {

    //Edabit-Challange
    //https://edabit.com/challenge/H6eTNH6NW36MHqkjb

    public static int pentagonal(int num) {
        int outerRings = 0;
        for(int i = num-1; i > 0; i--){
            outerRings += i * 5;
        }
        return outerRings + 1;
    }

    public static void main(String[] args) {
        System.out.println(pentagonal(10));
    }
}
