package Searching;

import java.util.Arrays;

/*
Suppose you are given a 2D sorted array in row wise and column wise.  search for an element in 0(n) time complexity.
this can be done by using binary search .
 */
public class BS_2DArray {
    public static void main(String[] args) {
        int[][] arr = {{10,20,30,40} ,
                       {15,25,35,45},
                       {28,29,37,49},
                       {33,34,38,50}};
        int target = 37;

//        int[][] arr = {{1,3} , {2,4}};
//        int target = 3;

//        int[][] arr = {{1}};
//        int target = 1;


        int[] ans = search(arr , target);
        System.out.println(Arrays.toString(ans));
      //  System.out.println(arr.length);
    }

    static int[] search(int[][] arr, int target) {
       ;
        int r = 0;
        int c = arr[r].length-1;

        while(r < arr.length &&  c >= 0){
           if(arr[r][c] == target){
               return new int[]{r,c};
           }
           if(arr[r][c] < target){
               r++;
           }else{
               c--;
           }
        }

        return new int[]{-1,-1};
    }

}
