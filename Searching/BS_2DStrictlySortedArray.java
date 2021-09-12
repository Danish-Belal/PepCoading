package Searching;

import java.util.Arrays;

/*
Strictly sorted 2D array is array where element of first row , clo element is greater than privios row-1 , col-1 element.
// We can also convert this matrix into 1d Sorted array.
 */
public class BS_2DStrictlySortedArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
        };

        System.out.println(Arrays.toString(search(arr, 7)));
    }

     static int[] search(int[][] arr, int target) {




        return  new int[]{-1,-1};
    }
}
