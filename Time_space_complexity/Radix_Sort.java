package Time_space_complexity;
import java.util.*;
/*
Sample Input

5
7
2
4
1
3

Sample Output
After sorting on 1 place -> 1 2 3 4 7
1 2 3 4 7
 */

public class Radix_Sort {
    public static void radixSort(int[] arr , int max) {
        // write code here
        int exp = 1 ;
         while (max !=0){
             max /=10;
             countSort(arr , exp);
             exp *=10;
         }
    }

    public static void countSort(int[] arr, int exp) {
        // write code here
        int[] fre  = new int[10];

        for(int i = 0 ; i<arr.length ; i++){
            fre[(arr[i]/exp) %10]++;
        }
         for(int i = 1 ; i<fre.length ; i++){
             fre[i] += fre[i-1];
         }

         int[] ans = new int[arr.length];
         for(int i = arr.length-1 ; i>=0 ; i--){
             int pos  = fre[(arr[i] / exp) %10];
             ans[pos-1] = arr[i];
             fre[(arr[i] /exp) %10]--;

         }

        System.arraycopy(ans, 0, arr, 0, arr.length);
        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int maxval = Integer.MIN_VALUE;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            maxval = max(maxval , arr[i]);
        }
        radixSort(arr , maxval);
        print(arr);
    }
    public static int max(int a , int b){
        if(a > b){
            return a;
        }
        return b;

    }

}
