package Time_space_complexity;
import java.util.*;
/*
1. You are given an array(arr) containing only 0's and 1's.
2. You have to sort the given array in increasing order and in linear time.
Constraints

1 <= N <= 10000
arr[i] = 0,1

Sample Input

5
0
1
0
1
0

Sample Output

Swapping index 0 and index 0
Swapping index 2 and index 1
Swapping index 4 and index 2
0
0
0
1
1
 */
public class Sort_01 {

    public static void sort01(int[] arr){
        //write your code here
        

    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args)  {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
            arr[i] = scn.nextInt();
        }
        sort01(arr);
        print(arr);
    }
}
