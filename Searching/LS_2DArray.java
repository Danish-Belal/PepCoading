package Searching;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LS_2DArray {
    public static void main(String[] args) {
        int arr[][] = {
                {1,2,4},
                {3,7,8,9},
                {12,56},
                {67,90}
        };
        int target = 8;
      int[] ans =  linerSearch(arr , target);
        System.out.println(Arrays.toString(ans));
        System.out.println(max(arr));

    }
    static  int[] linerSearch(int[][] arr , int target){
        for(int i = 0 ; i<arr.length ; i++){
            for(int j = 0 ; j<arr[i].length ; j++){
                if(arr[i][j] == target){
                    return  new int[]{i , j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    static  int max(int[][] arr){
        int max = arr[0][0];
        for(int[] intn : arr){
            for(int element : intn){
                if(element > max){
                    max = element;
                }
            }

        }
        return max;
    }
}
