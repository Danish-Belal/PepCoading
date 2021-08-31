package Time_space_complexity;
import java.util.*;
/*
1. You are given two sorted arrays(a,b) of integers.
2. You have to merge them and form one sorted array.
3. You have to do it in linear time complexity.
Constraints

1 <= N <= 10^8
-10^9 <= a[i],b[i] <= 10^9

Sample Input

4
-2
5
9
11
3
4
6
8

Sample Output

-2
4
5
6
8
9
11
 */
public class Merge_two_sorted_array {
    public static int[] mergeTwoSortedArrays(int[] a, int[] b){
        //write your code here

        int sz = a.length+b.length;
        int[] merged_Array = new int[sz];
       int i = 0;
       int j = 0;
       int z = 0;
       while (i != a.length && j !=b.length){
           if(a[i] < b[j]){
               merged_Array[z] = a[i];
               i++;
               z++;
           }else{
               merged_Array[z] = b[j];
               j++;
               z++;
           }

       }

           while (i <a.length){
               merged_Array[z] = a[i];
               i++;
               z++;
           }
        while (j <b.length){
            merged_Array[z] = b[j];
            j++;
            z++;
        }



        return  merged_Array;
    }

    public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n; i++){
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for(int i = 0 ; i < m; i++){
            b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a,b);
        print(mergedArray);
    }
}
