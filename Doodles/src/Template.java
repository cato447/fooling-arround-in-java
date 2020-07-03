import java.util.Arrays;

public class Template {

    /*
        1  2  3  4  5
        12 13 14 15 6
        11 10 9  8  7

     */

    public static void main(String[] args) {
        int num = 1000;
        for (int j = 0; j < 50; j++) {
            for (int i = 0; i < 59; i++) {
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }

}
