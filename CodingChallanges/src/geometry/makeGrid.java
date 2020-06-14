package geometry;

import java.util.Arrays;

public class makeGrid {

    //Edabit-Challange
    //https://edabit.com/challenge/7Tb7qMDQHtz3xpydd

    public static int[][] squarePatch( int n ){
        int[][] array = new int[n][n];
        int i = 0;
        while (i < n){
            for (int j = 0; j < n; j++){
                array[i][j] = n;
            }
            i++;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(squarePatch(4)));
    }

}
