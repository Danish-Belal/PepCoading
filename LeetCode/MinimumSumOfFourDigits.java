package LeetCode;

import java.util.Arrays;

public class MinimumSumOfFourDigits {

    public int minimumSum(int num) {


        int[] arr = new int[4];
        for(int i = 0 ; i<4 ; i++){
            int n1 = num%10;
            num /=10;
            arr[i] = n1;
        }

        Arrays.sort(arr);
        int n1 = arr[0];
        int n2 = arr[1];
        n1 *=10;
        n2 *=10;
        n1 += arr[2];
        n2 += arr[3];

        return n1+n2;

    }
}
