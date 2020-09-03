import java.util.Arrays;

public class Template {

    /*
        1  2  3  4  5
        12 13 14 15 6
        11 10 9  8  7

     */

    public static void main(String[] args) {
        int num = 1;
        for (int j = 0; j < 3; j++) {
            //Cycle through rows
            for (int i = 0; i < 5; i++) {
                //Cycle through columns
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }

}
