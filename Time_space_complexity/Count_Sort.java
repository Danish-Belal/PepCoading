package Time_space_complexity;
/*
1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using count sort.
Sample Input

5
7
-2
4
1
3

Sample Output

-2
1
3
4
7
 */
import java.util.*;
public class Count_Sort {
    public static void countSort(int[] arr, int min, int max) {
        //write your code here

        //1. Create a frequency Array.
        int[] fre = new int[max-min+1];
        for (int j : arr) {
            fre[j - min]++;
        }

        //2. convert frequency array into prefix sum.
        for(int i = 1 ; i<fre.length ; i++){
            fre[i] += fre[i-1];
        }

        // 3. create  ans array.
        int[] ans = new int[arr.length];
        for(int i =arr.length-1 ; i>= 0 ; i--){
            int position = fre[arr[i]-min];
            ans[position-1] = arr[i];
            fre[arr[i] - min]--;
        }

        //4. Fill original Array.
        System.arraycopy(ans, 0, arr, 0, arr.length);

    }

    public static void print(int[] arr) {
        for (int j : arr) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
      //  System.out.println(min + " " + max);
        countSort(arr,min,max);
        print(arr);
    }
}
