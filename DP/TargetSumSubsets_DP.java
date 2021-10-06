package DP;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.Scanner;

/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add
     up to "tar" or not.
 */
public class TargetSumSubsets_DP {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
     int[] arr = new int[n];
     for(int i = 0 ; i<n ; i++){
       arr[i] = in.nextInt();
     }

     int target = in.nextInt();
        System.out.println(sum(arr , 0 , target));
    }

    public static boolean sum(int[] arr , int idx , int target){

      if(target == 0) return true;
      if(idx == arr.length || target < 0){
          return false;
      }
        boolean f1 = sum(arr , idx+1 , target);
        boolean f2 = sum(arr,idx+1  , target-arr[idx]);

        boolean ans = f1  || f2;
        return ans;
    }

}
